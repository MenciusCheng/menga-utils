package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class War3Utils {

    public final static Integer BASE_HERO_ATTACK = 100;
    public final static Integer BASE_HERO_ARMOR = 10;
    public final static Integer BASE_HERO_HP = 500;
    public final static Double BASE_HERO_ATTACK_DELAY = 1.0;


    /**
     * 计算攻击力对护甲减伤后的伤害
     * damage = atk * (1 - def * 0.06 / (1 + def * 0.06))
     * damage = atk * (1 / (1 + def * 0.06))
     */
    public static Integer calDamage(Integer attack, Integer armor) {
        return new Double(attack * (1 / (1 + armor * 0.06))).intValue();
    }

    /**
     * 计算击败该血量需要的攻击次数
     */
    public static Integer calHits(Integer attack, Integer armor, Integer hp) {
        Integer damage = calDamage(attack, armor);
        Integer remainder = hp % damage;
        if (remainder > 2) {
            // 有余数时算多一次打击数，允许一点误差
            return hp / damage + 1;
        } else {
            return hp / damage;
        }
    }
}
