package com.jerry.study.jse.devteam.domain;

/**
 * ClassName: Architect
 * Package: com.jerry.study.jse.devteam.domain
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/17
 */
public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
