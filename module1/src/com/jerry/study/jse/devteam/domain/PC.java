package com.jerry.study.jse.devteam.domain;

/**
 * ClassName: PC
 * Package: com.jerry.study.jse.devteam.domain
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/17
 */
public class PC implements Equipment{
    private String model;
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
