package com.jerry.study.jdbc.basic;

import java.sql.*;
import java.util.Scanner;

/**
 * ClassName: PreStatementUserLogin
 * Package: com.hello.test
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/8
 */
public class PreStatementUserLogin {

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

            //5.编写sql语句
            String sql = "SELECT * FROM user WHERE account = ? AND password = ?;";

            //6.创建预编译statement
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //7.单独的占位符进行赋值
            preparedStatement.setObject(1, account);
            preparedStatement.setObject(2, password);

            //8.发送sql语句，并获取返回结果
            ResultSet resultSet = preparedStatement.executeQuery();

            //9.处理结果集
            if(resultSet.next()) {
                System.out.println(resultSet.getString("account") + "登录成功！");
            } else {
                System.out.println(account + "登录失败！");
            }
            //10.释放资源
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        scan.close();
    }
}
