package com.jerry.study.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: jdbcCRUD
 * Package: com.jerry.study.jdbc.utils
 * Description: 基于工具类的CRUD
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public class JdbcCRUD {

    public void testInsert() throws SQLException {

        Connection conn = JdbcUtils.getConnection();
        JdbcUtils.freeConnection(conn);

    }
}
