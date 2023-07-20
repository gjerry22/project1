package com.jerry.study.jdbc.cms.service;

import com.jerry.study.jdbc.cms.dao.CustomerDao;
import com.jerry.study.jdbc.cms.javabean.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: CustomerService
 * Package: com.jerry.study.jdbc.cms.service
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/10
 */
public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();

    public List<Customer> getList() {
        try {
            return customerDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getCustomer(int id) {
        try {
            return customerDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(Customer customer) {
        try {
            customerDao.addCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean modifyCustomer(int id, Customer customer) {
        int rows = 0;
        try {
            rows = customerDao.updateById(id, customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows != 0;
    }

    public boolean removeCustomer(int id) {
        int rows = 0;
        try {
            rows = customerDao.removeById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows != 0;
    }

}
