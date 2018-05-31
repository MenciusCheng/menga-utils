package com.menga.head_first_design_patterns.c3_1;

/**
 * Created by Marvel on 2018/5/31.
 */
public class CoffeeDemo {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " 价格：" + beverage.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Milk(beverage2);
        System.out.println(beverage2.getDescription() + " 价格：" + beverage2.cost());
    }
}
