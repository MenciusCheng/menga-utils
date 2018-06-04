package com.menga.war3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvel on 2018/6/4.
 */
public class War3Demo {

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        Integer attack = 32;
        Integer armor = 16;
        Double p = 1.6;
        Integer level = 1;
        while (level <= 20) {
            Integer xAttack = new Double(attack * (Math.pow(p, level - 1))).intValue();
//            Integer xArmor = 10 * level;
            Integer xArmor = new Double(armor * (Math.pow(1.3, level - 1))).intValue();
            Integer xHp = calDamage(xAttack, xArmor) * 10;

            Monster monster = new Monster();
            monster.setLevel(level);
            monster.setAttack(xAttack);
            monster.setArmor(xArmor);
            monster.setHp(xHp);
            monsters.add(monster);

            System.out.println(monster);

            Integer hp2 = calDamage(xAttack, 0) * 10;
            System.out.println("hp2=" + hp2 + "; hp2/hp=" + (double)hp2 / xHp);

            level += 1;
        }

        for (int i = 1; i < monsters.size() - 1; i++) {
            Monster m = monsters.get(i);
            Monster mUp = monsters.get(i + 1);
            Monster mDown = monsters.get(i - 1);

            System.out.print("(" + m.getLevel() + " -> " + m.getLevel() + ": ");
            System.out.print("hitTimes=" + calHitTimes(m.getAttack(), m.getArmor(), m.getHp()) + ") ");

            System.out.print("(" + m.getLevel() + " -> " + mDown.getLevel() + ": ");
            System.out.print("hitTimes=" + calHitTimes(m.getAttack(), mDown.getArmor(), mDown.getHp()) + ", hp/=" + (double)(m.getHp()) / mDown.getHp() + ") ");

            System.out.print("(" + m.getLevel() + " -> " + mUp.getLevel() + ": ");
            System.out.print("hitTimes=" + calHitTimes(m.getAttack(), mUp.getArmor(), mUp.getHp()) + ") ");

            System.out.println();
        }

//        Integer damage = calDamage(1000, 100);
//        System.out.println(damage);
    }

    public static Integer calHitTimes(Integer attack, Integer armor, Integer hp) {
        Integer damage = calDamage(attack, armor);
        return hp / damage;
    }

    /**
     * atk * (1 - def * 0.06 / (1 + def * 0.06))
     * atk * (1 / (1 + def * 0.06))
     */
    public static Integer calDamage(Integer attack, Integer armor) {
        Double damage = attack * (1 / (1 + armor * 0.06));
        return damage.intValue();
    }
}
