package com.menga.head_first_design_patterns.c1_2;

/**
 * Created by Marvel on 2018/5/28.
 */
public class DuckDemo {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();

        mallardDuck.performMyself();
        rubberDuck.performMyself();
        mallardDuck.getHurt();
        mallardDuck.performMyself();
    }
}
