package com.jerry.study.jse.devteam.domain;

import com.jerry.study.jse.devteam.service.Status;

/**
 * ClassName: Programmer
 * Package: com.jerry.study.jse.devteam.domain
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/17
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
