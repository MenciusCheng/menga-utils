package com.menga.head_first_design_patterns.c1_2.fly;

/**
 * Created by Marvel on 2018/5/28.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
