package com.jerry.study.jdbc.banknew;

import com.jerry.study.jdbc.utils.JdbcUtilsV2;

import java.sql.Connection;
import java.sql.DriverManager;
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
            Connection conn = JdbcUtilsV2.getConnection();

            try {
                conn.setAutoCommit(false);

                BankDao bankDao = new BankDao();
                bankDao.add(addAccount, money);
                System.out.println("----------");
                bankDao.minus(minusAccount, money);

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException(e);
            }

            JdbcUtilsV2.freeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
