package com.menga.head_first_design_patterns.c1_2;

import com.menga.head_first_design_patterns.c1_2.fly.FlyNoWay;
import com.menga.head_first_design_patterns.c1_2.quack.Squeak;

/**
 * Created by Marvel on 2018/5/28.
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super("橡皮鸭子", new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        System.out.println("我是橡皮鸭子");
    }
}
