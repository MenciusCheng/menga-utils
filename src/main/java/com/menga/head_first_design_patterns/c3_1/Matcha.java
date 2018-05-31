package com.menga.head_first_design_patterns.c3_1;

/**
 * 抹茶
 *
 * Created by Marvel on 2018/5/31.
 */
public class Matcha extends CondimentDecorator {
    private Beverage beverage;

    public Matcha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "，抹茶";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.5;
    }
}
