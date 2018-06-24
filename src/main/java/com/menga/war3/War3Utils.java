package com.menga.war3;

import scala.Int;

/**
 * Created by Marvel on 2018/6/4.
 */
public class War3Utils {

    public final static Integer BASE_HERO_ATTACK = 100;
    public final static Integer BASE_HERO_ARMOR = 10;
    public final static Integer BASE_HERO_HP = 500;
    public final static Double BASE_HERO_ATTACK_DELAY = 1.0;

    // 护甲减伤因子
    public final static Double DEFENSE_ARMOR = 0.06;

    public static void main(String[] args) {

    }

    /**
     * 计算攻击力对护甲减伤后的伤害
     * damage = 攻击力 * (1 - 护甲 * 护甲减伤因子 / (1 + 护甲 * 护甲减伤因子))
     * damage = 攻击力 * (1 / (1 + 护甲 * 护甲减伤因子))
     */
    public static Integer calDamage(Integer attack, Integer armor) {
        return new Double(attack * (1 / (1 + armor * DEFENSE_ARMOR))).intValue();
    }

    /**
     * 总血量 = 血量 * (1 + 护甲 * 护甲减伤因子)
     */
    public static Integer getSumHpByArmorAndHp(Integer armor, Integer hp) {
        return (int)(hp * (1 + armor * DEFENSE_ARMOR));
    }

    /**
     * 血量 =  总血量 / (1 + 护甲 * 护甲减伤因子)
     */
    public static Integer getHpByArmorAndSumHp(Integer armor, Integer sumHp) {
        return (int)(sumHp / (1 + armor * DEFENSE_ARMOR));
    }

    /**
     * 护甲 = (总血量 / 血量 - 1) / 护甲减伤因子
     */
    public static Integer getArmorByHpAndSumHp(Integer hp, Integer sumHp) {
        return (int)((sumHp / hp - 1) / DEFENSE_ARMOR);
    }

    /**
     * 获得旗鼓相当的怪物
     * @param hero 英雄
     * @param heroWithstandTime 英雄可承受伤害时间
     * @param monsterWithstandTime 怪物可承受伤害时间
     * @param delay 怪兽攻击间隔
     * @param amount 怪兽同时攻击的数量
     * @param monsterType 1: monster; 2: boss
     */
    public static Monster getMonsterByHero(UnitPower hero, Integer heroWithstandTime, Integer monsterWithstandTime, Double delay, Integer amount, Integer monsterType) {
        Integer heroWithstandDamage = getSumHpByArmorAndHp(hero.getArmor(), hero.getHp());
        Integer monsterDps = heroWithstandDamage / heroWithstandTime;
        Integer monsterAttack = (int)(monsterDps * delay / amount);
        Integer monsterWithstandDamage = (hero.getPdps() + hero.getMdps()) * monsterWithstandTime;
        Integer monsterHp = hero.getMdps() * monsterWithstandTime;
        Integer monsterArmor = getArmorByHpAndSumHp(monsterHp, monsterWithstandDamage);

        Monster monster = new Monster()
                .setAttack(monsterAttack)
                .setHp(monsterHp)
                .setArmor(monsterArmor)
                .setAttackDelay(delay);

        if (monsterType == 2) {
            monster.setName("boss");
        }

        return monster;
    }

    /**
     * 计算能承受伤害的时间
     * @param attacker 攻击者
     * @param defender 防御者
     * @param attackType 攻击类型：1. 英雄攻击，算上魔法伤害；2. 怪物攻击，不算魔法伤害
     * @return 承受时间
     */
    public static Integer calWithstandTimeByAttack(UnitPower attacker, UnitPower defender, Integer attackType) {
        Integer withstandDps = 1;
        if (attackType == 1) {
            // 每秒承受伤害 = 护甲减伤后的每秒物理伤害 + 每秒魔法伤害 - 每秒恢复值
            withstandDps = calDamage(attacker.getPdps(), defender.getArmor()) + defender.getMdps() - defender.getRps();
        } else if (attackType == 2) {
            withstandDps = calDamage(attacker.getPdps(), defender.getArmor()) - defender.getRps();
        }
        return defender.getHp() / withstandDps;
    }
}
