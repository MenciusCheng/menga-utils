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
        Integer hAttack = 150;
        Integer hDamage = getDamageByAttackDuration(hAttack, 0.5, 3);
        Integer mArmor = 2;
        Integer mHp = getHpByArmor(mArmor, hDamage);
        System.out.println("hero_attack=" + hAttack + ", monster_armor=" + mArmor + ", monster_hp=" + mHp);

        Integer mAttack = 50;
        Integer mDamage = getDamageByAttackDuration(mAttack, 1.0, 60);
        Integer hArmor = 15;
        Integer hHp = getHpByArmor(hArmor, mDamage);
        System.out.println("monster_attack=" + mAttack + ", hero_armor=" + hArmor + ", hero_hp=" + hHp);

        Integer hBDamage = getDamageByAttackDuration(hAttack, 0.5, 60);
        Integer bArmor = 30;
        Integer bHp = getHpByArmor(bArmor, hBDamage);
        Integer bAttack = getAttackByHp(hHp, hArmor, 6, 0.5);
        System.out.println("boss_attack=" + bAttack + ", boss_armor=" + bArmor + ", boss_hp=" + bHp);
    }

    /**
     * 承受伤害 = 生命值 * (1 + armor * 护甲减伤因子)
     * 攻击力 = 承受伤害 / 攻击持续时间(秒) * 攻击间隔(秒)
     */
    public static Integer getAttackByHp(Integer hp, Integer armor, Integer duration, Double delay) {
        Double damage = hp * (1 + armor * DEFENSE_ARMOR);
        return (int)(damage / duration * delay);
    }

    /**
     * 造成伤害 = 攻击力 / 攻击间隔(秒) * 攻击持续时间(秒)
     */
    public static Integer getDamageByAttackDuration(Integer attack, Double delay, Integer duration) {
        return (int)(attack / delay * duration);
    }

    /**
     *     由公式 总生命值 = 生命值 * (1 + armor * 护甲减伤因子) 得到
     * 生命值 = 总生命值 / (1 + armor * 护甲减伤因子)
     */
    public static Integer getHpByArmor(Integer armor, Integer hp) {
        return (int)(hp / (1 + armor * DEFENSE_ARMOR));
    }

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
