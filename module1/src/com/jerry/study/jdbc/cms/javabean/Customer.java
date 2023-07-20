package com.jerry.study.jdbc.cms.javabean;

/**
 * ClassName: Customer
 * Package: com.jerry.study.jdbc.cms.javabean
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/10
 */
public class Customer {

    private int id;
    private String name;
    private String gender;
    private int age;
    private double salary;
    private String phone;

    public Customer() {

    }

    public Customer(String name, String gender, int age, double salary, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
