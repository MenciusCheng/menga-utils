package com.menga.head_first_design_patterns.c3_1;

/**
 * 浓咖啡
 *
 * Created by Marvel on 2018/5/31.
 */
public class Espresso extends Beverage {

    public Espresso() {
        setDescription("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 18;
    }
}
