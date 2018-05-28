package com.menga.head_first_design_patterns.c1_2;

import com.menga.head_first_design_patterns.c1_2.fly.FlyNoWay;
import com.menga.head_first_design_patterns.c1_2.fly.FlyWithWings;
import com.menga.head_first_design_patterns.c1_2.quack.Quack;

/**
 * Created by Marvel on 2018/5/28.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        super("绿头鸭", new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }

    /**
     * 受伤了
     */
    public void getHurt() {
        this.setFlyBehavior(new FlyNoWay());
    }
}
