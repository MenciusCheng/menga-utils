package com.menga.head_first_design_patterns.c1_2;

import com.menga.head_first_design_patterns.c1_2.fly.FlyBehavior;
import com.menga.head_first_design_patterns.c1_2.quack.QuackBehavior;

/**
 * Created by Marvel on 2018/5/28.
 */
public abstract class Duck {

    private String name;
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(String name, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.println(name + "在游泳");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performMyself() {
        System.out.println("==========================");
        display();
        swim();
        performFly();
        performQuack();
    }
}
