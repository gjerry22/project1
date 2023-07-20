package com.jerry.study.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName: BankDao
 * Package: com.jerry.study.jdbc.bank
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class BankDao {

    public void add(String account, int money, Connection conn) {

        String sql = "update bank set money = money + ? where account = ?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setObject(1, money);
            preparedStatement.setObject(2, account);
            preparedStatement.executeUpdate();

            System.out.println("add success");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void minus(String account, int money, Connection conn) {

        String sql = "update bank set money = money - ? where account = ?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setObject(1, money);
            preparedStatement.setObject(2, account);
            preparedStatement.executeUpdate();

            System.out.println("minus success");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
