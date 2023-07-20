package com.jerry.study.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: jdbcUtilsV2
 * Package: com.jerry.study.jdbc.utils
 * Description: 内部包含一个连接池对象，并且对外提供获取连接和回收连接的方法！
 *              改进：利用线程本地变量，存储连接信息，确保一个线程的多个方法可以获取同一个connection对象！
 *              优势：事务操作的时候，service和dao属于同一个线程，不用再传递参数了！
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class JdbcUtilsV2 {

    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("module1/src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection conn = tl.get();
        if(conn == null) {
            conn = dataSource.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    public static void freeConnection() throws SQLException {

        Connection conn = tl.get();
        if(conn != null) {
            tl.remove();
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
