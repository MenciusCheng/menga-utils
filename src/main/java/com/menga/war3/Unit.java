package com.menga.war3;

/**
 * 单位
 *
 * Created by Marvel on 2018/6/4.
 */
public class Unit {

    private Integer attack;
    private Integer armor;
    private Integer hp;
    // 攻击间隔，单位为秒，表示攻击一次需要的时间
    private Double attackDelay;

    public Unit() {
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Double getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(Double attackDelay) {
        this.attackDelay = attackDelay;
    }
}
