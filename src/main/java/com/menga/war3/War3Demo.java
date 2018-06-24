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
        test5();
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
        900 攻
        90 防
        7500 血
         */
        Hero hero = new Hero()
                .setStrength(100)
                .setAgility(100)
                .setIntelligence(100)
                .setMainAbilityType(2)
                .setAddedAttack(0)
                .setAddedArmor(0)
                .setAddedHp(0);

        System.out.println(hero);

        System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero, 2));

        hero = new Hero()
                .setStrength(100)
                .setAgility(100)
                .setIntelligence(100)
                .setMainAbilityType(2)
                .setAddedAttack(800)
                .setAddedArmor(90)
                .setAddedHp(5000);

        System.out.println(hero);

        System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero, 2));
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

    public static void test4() {

        /*
        100 属性 => 100 攻，30 防，2500 血
        900 攻
        90 防
        7500 血
         */
        Hero hero;

        int strength = 100;
        int agility = 100;
        int intelligence = 100;
        int attack = 800;
        int armor = 90;
        int hp = 5000;

        for (int i = 1; i < 30; i++) {
            hero = new Hero()
                    .setLevel(i)
                    .setStrength(strength * i)
                    .setAgility(agility * i)
                    .setIntelligence(intelligence * i)
                    .setMainAbilityType(2)
                    .setAddedAttack((int)(attack * Math.pow(1.6, i - 1)))
                    .setAddedArmor((int)(armor * Math.pow(1.3, i - 1)))
                    .setAddedHp((int)(hp * Math.pow(1.3, i - 1)));

            System.out.println(hero);

            System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero, 2));
        }

    }

    public static void test5() {
        Hero hero;

//        int strength;
//        int agility;
//        int intelligence;
        int attack;

        for (int i = 1; i <= 30; i++) {
//            strength = 100 * i;
//            agility = 100 * i;
//            intelligence = 100 * i;
            // 怪物攻击列表
            attack = (int)(150 * Math.pow(1.4, i - 1));

            System.out.println(i + " :attack=" + attack);

//            hero = new Hero()
//                    .setLevel(i)
//                    .setStrength(strength)
//                    .setAgility(agility)
//                    .setIntelligence(intelligence)
//                    .setMainAbilityType(2)
//                    .setAddedAttack(attack);
//
//            System.out.println(hero);
//            System.out.println("WithstandTime = " + calWithstandTimeByAttack(hero, hero, 2));
        }
    }

}
