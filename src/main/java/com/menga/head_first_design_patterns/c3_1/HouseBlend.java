package com.menga.head_first_design_patterns.c3_1;

/**
 * 浓咖啡
 *
 * Created by Marvel on 2018/5/31.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        setDescription("综合咖啡");
    }

    @Override
    public double cost() {
        return 19;
    }
}
