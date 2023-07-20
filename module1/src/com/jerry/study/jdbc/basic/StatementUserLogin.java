package com.jerry.study.jdbc.basic;

import java.sql.*;
import java.util.Scanner;

/**
 * ClassName: StatementUserLogin
 * Package: com.hello.test
 * Description: 模拟用户登录
 *
 * @Author: Jerry
 * @Date: 2023/4/8
 */
public class StatementUserLogin {

    public static void main(String[] args) {

        //1.获取用户输入信息
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入账号：");
        String account = scan.nextLine();
        System.out.print("请输入密码：");
        String password = scan.nextLine();

        try {
            //2.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //3.获取数据库连接
            String url = "jdbc:mysql://localhost:3306/dbtest";
            String user = "root";
            String pwd = "root123";
            Connection conn = DriverManager.getConnection(url, user, pwd);

            //4.创建statement对象
            Statement statement = conn.createStatement();

            //5.发送sql语句,并返回结果
            String sql = "SELECT * FROM user WHERE account = '" + account + "' AND password = '" + password  + "';";
            ResultSet resultSet = statement.executeQuery(sql);

            //6.处理结果集
            if(resultSet.next()) {
                System.out.println(resultSet.getString("account") + "登录成功！");
            } else {
                System.out.println(account + "登录失败！");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        scan.close();
    }
}
