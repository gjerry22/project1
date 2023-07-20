package com.jerry.study.jdbc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BaseDao
 * Package: com.jerry.study.jdbc.utils
 * Description: 封装数据库重复代码
 *
 * @Author: Jerry
 * @Date: 2023/4/9
 */
public abstract class BaseDao {

    public int executeUpdate(String sql, Object... params) throws SQLException {
        Connection conn = JdbcUtilsV2.getConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1, params[i]);
        }
        int rows = preparedStatement.executeUpdate();
        preparedStatement.close();
        //是否回收连接，需要考虑是不是事务
        if(conn.getAutoCommit()) {
            //没有开启事务，正常回收连接
            JdbcUtilsV2.freeConnection();
        }
        return rows;
    }

    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception {
        Connection conn = JdbcUtilsV2.getConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        if(params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        List<T> list = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while(resultSet.next()) {
            T t = clazz.getDeclaredConstructor().newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i);
                Object value = resultSet.getObject(i);

                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t, value);
            }
            list.add(t);
        }

        resultSet.close();
        preparedStatement.close();
        if(conn.getAutoCommit()) {
            JdbcUtilsV2.freeConnection();
        }
        return list;
    }

}
