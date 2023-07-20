package com.jerry.study.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName: BankService
 * Package: com.jerry.study.jdbc.bank
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class BankService {

    public void transfer(String addAccount, String minusAccount, int money){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql:///dbtest";
            String user = "root";
            String password = "root123";
            Connection conn = DriverManager.getConnection(url, user, password);

            try {
                conn.setAutoCommit(false);

                BankDao bankDao = new BankDao();
                bankDao.add(addAccount, money, conn);
                System.out.println("----------");
                bankDao.minus(minusAccount, money, conn);

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException(e);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
