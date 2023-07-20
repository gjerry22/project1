package com.jerry.study.jdbc.basic;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: PreStatementCURD
 * Package: com.hello.test
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/8
 */
public class PreStatementCURD {

    @Test
    public void testInsert(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into user(account, password, name) values(?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1, "user4");
            preparedStatement.setObject(2, "123");
            preparedStatement.setObject(3, "Alice");
            int rows = preparedStatement.executeUpdate();

            if(rows > 0) {
                System.out.println("数据插入成功！");
            } else {
                System.out.println("数据插入失败！");
            }

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testUpdate(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn  = DriverManager.getConnection(url, user, password);

            String sql = "update user set name = ? where id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1, "Joy");
            preparedStatement.setObject(2, 4);
            int rows = preparedStatement.executeUpdate();

            if(rows > 0) {
                System.out.println("修改成功!");
            } else {
                System.out.println("修改失败！");
            }
            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDelete(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "delete from user where id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1, 4);
            int rows = preparedStatement.executeUpdate();

            if(rows > 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void testSelect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "select id, account, password, name, age from user;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Map<String, Object>> list = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
//                map.put("id", String.valueOf(resultSet.getInt("id")));
//                map.put("account", resultSet.getString("account"));
//                map.put("password", resultSet.getString("password"));
//                map.put("name", resultSet.getString("name"));
//                map.put("age", String.valueOf(resultSet.getInt("age")));
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(map);
            }
            System.out.println("list = " + list);
            resultSet.close();
            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
