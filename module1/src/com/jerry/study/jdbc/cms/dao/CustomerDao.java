package com.jerry.study.jdbc.cms.dao;

import com.jerry.study.jdbc.cms.javabean.Customer;
import com.jerry.study.jdbc.cms.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: CustomerDao
 * Package: com.jerry.study.jdbc.cms.dao
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/10
 */
public class CustomerDao extends BaseDao {


    public List<Customer> findAll() throws Exception {
        String sql = "SELECT * FROM customer";
        List<Customer> customerList = executeQuery(Customer.class, sql);
        return customerList;
    }

    public Customer findById(int id) throws Exception {
        String sql = "SELECT * FROM customer where id=?;";
        List<Customer> customerList = executeQuery(Customer.class, sql, id);
        if(customerList != null && customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer(name,gender,age,salary,phone) values(?,?,?,?,?);";
        executeUpdate(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getSalary(), customer.getPhone());
    }

    public int updateById(int id, Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name=?,gender=?,age=?,salary=?,phone=? where id=?;";
        int rows = executeUpdate(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getSalary(),
                customer.getPhone(), customer.getId());
        return rows;
    }

    public int removeById(int id) throws SQLException {
        String sql = "DELETE FROM customer where id=?;";
        int rows = executeUpdate(sql, id);
        return rows;
    }
}
