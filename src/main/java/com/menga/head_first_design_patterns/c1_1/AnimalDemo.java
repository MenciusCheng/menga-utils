package com.menga.head_first_design_patterns.c1_1;

/**
 * Created by Marvel on 2018/5/28.
 */
class AnimalDemo {

    public static void main(String[] args) {
        Animal a1 = AnimalFactory.getAnimal();
        a1.makeSound();
        Animal a2 = AnimalFactory.getAnimal();
        a2.makeSound();
        Animal a3 = AnimalFactory.getAnimal();
        a3.makeSound();
    }
}
