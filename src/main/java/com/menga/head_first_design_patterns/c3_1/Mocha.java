package com.menga.head_first_design_patterns.c3_1;

/**
 * 摩卡
 *
 * Created by Marvel on 2018/5/31.
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，摩卡";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3;
    }
}
