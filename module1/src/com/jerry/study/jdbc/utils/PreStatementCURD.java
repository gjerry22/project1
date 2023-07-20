package com.jerry.study.jdbc.utils;

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
public class PreStatementCURD extends BaseDao{

    @Test
    public void testInsert() throws SQLException {

        String sql = "insert into user(account, password, name) values(?, ?, ?);";
        executeUpdate(sql, "temp6", "123", "John");

    }

    @Test
    public void testUpdate() throws SQLException {

        String sql = "update user set name = ? where id = ?;";
        executeUpdate(sql, "David", 6);

    }

    @Test
    public void testDelete() throws SQLException {

        String sql = "delete from user where id = ?;";
        executeUpdate(sql, 6);

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
