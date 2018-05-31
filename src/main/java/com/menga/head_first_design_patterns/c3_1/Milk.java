package com.menga.head_first_design_patterns.c3_1;

/**
 * 牛奶
 *
 * Created by Marvel on 2018/5/31.
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，牛奶";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3.5;
    }
}
