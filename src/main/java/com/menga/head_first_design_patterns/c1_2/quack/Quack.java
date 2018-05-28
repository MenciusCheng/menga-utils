package com.menga.head_first_design_patterns.c1_2.quack;

/**
 * Created by Marvel on 2018/5/28.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
