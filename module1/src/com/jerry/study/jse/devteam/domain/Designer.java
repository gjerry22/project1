package com.jerry.study.jse.devteam.domain;

/**
 * ClassName: Designer
 * Package: com.jerry.study.jse.devteam.domain
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/17
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
