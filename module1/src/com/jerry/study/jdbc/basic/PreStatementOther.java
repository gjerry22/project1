package com.jerry.study.jdbc.basic;

import java.sql.*;

/**
 * ClassName: PreStatementOther
 * Package: com.hello.test
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class PreStatementOther {

    public void returnPrimaryKey() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into user(account, password, name) values(?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, "user5");
            preparedStatement.setObject(2, "123");
            preparedStatement.setObject(3, "Rock");
            int rows = preparedStatement.executeUpdate();

            if(rows > 0) {
                System.out.println("插入成功！");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                generatedKeys.next();
                int id = generatedKeys.getInt(1);
                System.out.println("id = " + id);
            } else {
                System.out.println("插入失败！");
            }

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 插入10000条数据
    public void testInsert() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into user(account, password, name) values(?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < 10000; i++) {
                preparedStatement.setObject(1, "temp"+i);
                preparedStatement.setObject(2, "123");
                preparedStatement.setObject(3, "Rock"+i);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 批量插入10000条数据
    public void testBatchInsert() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest?rewriteBatchedStatements=true";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into user(account, password, name) values(?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < 10000; i++) {
                preparedStatement.setObject(1, "temp"+i);
                preparedStatement.setObject(2, "123");
                preparedStatement.setObject(3, "Rock"+i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
