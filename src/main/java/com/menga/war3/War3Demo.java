package com.menga.war3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.menga.war3.War3Utils.*;

/**
 * Created by Marvel on 2018/6/4.
 */
public class War3Demo {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        Hero hero = new Hero()
                .setStrength(50)
                .setAgility(50)
                .setIntelligence(34)
                .setMainAbilityType(2)
                .setAddedAttack(100)
                .setAddedHp(500);

        System.out.println(hero);

        Monster monster = getMonsterByHero(hero, 6, 3, 1.0, 10, 1);

        System.out.println(monster);

        Monster boss = getMonsterByHero(hero, 6, 60, 0.5, 1, 2);

        System.out.println(boss);
    }

    public static void test2() {
        /*
        100 属性 => 100 攻，30 防，2500 血
        300 攻
        90 防
        7500 血
         */
        Hero hero = new Hero()
                .setStrength(100000)
                .setAgility(100000)
                .setIntelligence(100000)
                .setMainAbilityType(2)
                .setAddedAttack(0)
                .setAddedArmor(0)
                .setAddedHp(0);

        System.out.println(hero);

        System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero));

        hero = new Hero()
                .setStrength(0)
                .setAgility(0)
                .setIntelligence(0)
                .setMainAbilityType(2)
                .setAddedAttack(100)
                .setAddedArmor(30)
                .setAddedHp(2500);

        System.out.println(hero);

        System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero));
    }

    public static void test3() {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> z = new ArrayList<>();

        Integer x_y = 100;

        for (int i = 1; i < x_y; i++) {
            x.add(i);
            y.add(x_y - i);
            z.add(i + i * (x_y - i));
        }

        for (int i = 0; i < z.size(); i++) {
            System.out.println("x=" + x.get(i) + ",y=" + y.get(i) + ",z=" + z.get(i));
        }
    }

}
