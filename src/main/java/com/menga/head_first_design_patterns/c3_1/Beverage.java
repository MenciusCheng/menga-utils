package com.menga.head_first_design_patterns.c3_1;

/**
 * 饮料
 *
 * Created by Marvel on 2018/5/31.
 **/
public abstract class Beverage {

    private String description;

    public Beverage() {
        this.description = "Unknown Beverage";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();
}
