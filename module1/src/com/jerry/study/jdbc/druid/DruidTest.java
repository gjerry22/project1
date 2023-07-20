package com.jerry.study.jdbc.druid;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: DruidUse
 * Package: com.jerry.study.jdbc.druid
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class DruidTest {

    public static void main(String[] args) {
        new DruidTest().testSoft();
    }

    /**
     * 直接使用代码设置连接池连接参数
     * 1、创建一个druid连接池对象
     * 2、设置连接池参数
     * 3、获取连接
     * 4、回收连接
     */
    @Test
    public void testHard() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///dbtest");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        try {
            Connection conn = dataSource.getConnection();
            System.out.println("111");
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 通过读取外部配置文件的方式设置连接池连接参数
     */
    @Test
    public void testSoft() {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("module1/src/druid.properties"));
//            System.out.println(properties);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            System.out.println("222");
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
