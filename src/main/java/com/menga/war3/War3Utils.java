package com.menga.war3;

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

    /**
     * 计算攻击力对护甲减伤后的伤害
     * damage = 攻击力 * (1 - 护甲 * 护甲减伤因子 / (1 + 护甲 * 护甲减伤因子))
     * damage = 攻击力 * (1 / (1 + 护甲 * 护甲减伤因子))
     */
    public static Integer calDamage(Integer attack, Integer armor) {
        return new Double(attack * (1 / (1 + armor * 0.06))).intValue();
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
    public static Monster getMonsterByHero(Hero hero, Integer heroWithstandTime, Integer monsterWithstandTime, Double delay, Integer amount, Integer monsterType) {
        Integer heroWithstandDamage = getSumHpByArmorAndHp(hero.getArmor(), hero.getHp());
        Integer monsterDps = heroWithstandDamage / heroWithstandTime;
        Integer monsterAttack = (int)(monsterDps * delay / amount);
        Integer monsterWithstandDamage = hero.getDps() * monsterWithstandTime;
        Integer monsterHp = hero.getMdps() * monsterWithstandTime;
        Integer monsterArmor = getArmorByHpAndSumHp(monsterHp, monsterWithstandDamage);

        Monster monster = new Monster()
                .setLevel(hero.getLevel())
                .setAttack(monsterAttack)
                .setHp(monsterHp)
                .setArmor(monsterArmor)
                .setAttackDelay(delay);

        if (monsterType == 2) {
            monster.setName("boss");
        }

        return monster;
    }
}
