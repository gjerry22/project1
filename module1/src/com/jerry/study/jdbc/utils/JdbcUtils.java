package com.jerry.study.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: jdbcUtils
 * Package: com.jerry.study.jdbc.utils
 * Description: 内部包含一个连接池对象，并且对外提供获取连接和回收连接的方法！
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void freeConnection(Connection conn) throws SQLException {
        conn.close();
    }
}
