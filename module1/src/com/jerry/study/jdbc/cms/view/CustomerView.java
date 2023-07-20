package com.jerry.study.jdbc.cms.view;

import com.jerry.study.jdbc.cms.javabean.Customer;
import com.jerry.study.jdbc.cms.service.CustomerService;

import java.util.List;
import java.util.Scanner;

/**
 * ClassName: CustomerView
 * Package: com.jerry.study.jdbc.cms.view
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/10
 */
public class CustomerView {

    private final CustomerService customerService = new CustomerService();
    private final Scanner scan = new Scanner(System.in);

    public void enterMainMenu() {

        boolean flag = true;
        while(flag) {
            System.out.println("\n--------------------客户信息管理---------------------");
            listAllCustomers();
            System.out.print("1 添加客户 2 删除客户 3 修改客户 4 查找客户 5 退  出 请选择（1-5）：");
            int choice = KeyboardUtility.readMenuSelection();
            switch(choice) {
                case 1 -> addCustomer();
                case 2 -> deleteCustomer();
                case 3 -> modifyCustomer();
                case 4 -> getCustomer();
                case 5 -> {
                    System.out.print("确认退出（Y/N）：");
                    String s = scan.nextLine();
                    if("Y".equalsIgnoreCase(s)) {
                        flag = false;
                    }
                }
            }
        }
    }

    private void addCustomer() {
        System.out.println("------------添加客户-------------");
        System.out.print("姓名：");
        String name = scan.nextLine();
        System.out.print("性别：");
        String gender = scan.nextLine();
        System.out.print("年龄：");
        int age = Integer.parseInt(scan.nextLine().strip());
        System.out.print("工资：");
        double salary = Double.parseDouble(scan.nextLine().strip());
        System.out.print("电话：");
        String phone = scan.nextLine();
        customerService.addCustomer(new Customer(name, gender, age, salary, phone));
        System.out.println("添加成功！");
    }

    private void deleteCustomer() {
        System.out.println("------------删除客户-------------");
        System.out.print("请输入待删除客户的ID（-1退出）：");
        int id = Integer.parseInt(scan.nextLine().strip());
        if(id == -1) {
            return;
        }
        System.out.print("确认删除（Y/N）：");
        String s = scan.nextLine();
        if("Y".equalsIgnoreCase(s)) {
            if(customerService.removeCustomer(id)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("指定ID为" + id + "的客户不存在");
            }
        }
    }

    private void modifyCustomer() {
        System.out.println("------------修改客户-------------");
        System.out.print("请输入待修改客户的ID（-1退出）：");
        int id = Integer.parseInt(scan.nextLine().strip());
        if(id == -1) {
            return;
        }
        Customer customer = customerService.getCustomer(id);
        if(customer == null) {
            System.out.println("指定ID为" + id + "的客户不存在");
            return;
        }
        System.out.println("<直接回车表示不修改>");
        System.out.print("姓名（" + customer.getName() + "）：");
        String name = scan.nextLine();
        if(!"".equals(name)) {  // && !customer.getName().equals(name)
            customer.setName(name);
        }
        System.out.print("性别（" + customer.getGender() + "）：");
        String gender = scan.nextLine();
        if(!"".equals(gender)) {
            customer.setGender(gender);
        }
        System.out.print("年龄（" + customer.getAge() + "）：");
        String s = scan.nextLine().strip();
        if(!"".equals(s)) {
            int age = Integer.parseInt(s);
            customer.setAge(age);
        }
        System.out.print("工资（" + customer.getSalary() + "）：");
        s = scan.nextLine().strip();
        if(!"".equals(s)) {
            double salary = Double.parseDouble(s);
            customer.setSalary(salary);
        }
        System.out.print("电话（" + customer.getPhone() + "）：");
        String phone = scan.nextLine();
        if(!"".equals(phone)) {
            customer.setPhone(phone);
        }
        customerService.modifyCustomer(id, customer);
        System.out.println("修改成功！");
    }

    private void getCustomer() {
        System.out.println("------------查找客户-------------");
        System.out.print("请待查找客户的ID（-1退出）：");
        int id = Integer.parseInt(scan.nextLine().strip());
        if(id == -1) {
            return;
        }
        Customer customer = customerService.getCustomer(id);
        if(customer == null) {
            System.out.println("指定ID为" + id + "的客户不存在");
            return;
        }
        System.out.println("ID\tName\tgender\tage\tsalary\tphone");
        System.out.println(customer.getId() + "\t" + customer.getName() + "\t" + customer.getGender() + "\t" +
                customer.getAge() + "\t" + customer.getSalary() + "\t" + customer.getPhone());
    }

    private void listAllCustomers() {
        List<Customer> list = customerService.getList();
        System.out.println("---------------------客户列表-----------------------");
        System.out.println("ID\tName\tgender\tage\tsalary\tphone");
        for (Customer customer : list) {
            System.out.println(customer.getId() + "\t" + customer.getName() + "\t" + customer.getGender() + "\t" +
                    customer.getAge() + "\t" + customer.getSalary() + "\t" + customer.getPhone());
        }
    }
}
