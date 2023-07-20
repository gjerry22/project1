package com.jerry.study.jdbc.basic;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * ClassName: StatementQuery
 * Package: com.hello.test
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/7
 */
public class StatementQuery {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.注册驱动
//        DriverManager.registerDriver(new Driver());
//        new Driver();
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/dbtest";
        String userName = "root";
        String password = "root123";
        Connection conn = DriverManager.getConnection(url, userName, password);
        //3.创建statement
        Statement statement = conn.createStatement();
        //4.发送sql语句，并且获取返回结果
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);
        //5.进行结果集解析
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id + "--" + name + "--" + age);
        }
        //6.关闭资源
        resultSet.close();
        statement.close();
        conn.close();

    }

}
