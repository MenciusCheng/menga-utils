package com.menga.head_first_design_patterns.c1_1;

/**
 * Created by Marvel on 2018/5/28.
 */
class AnimalFactory {

    static Animal getAnimal() {
        if (Math.random() >= 0.5) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
