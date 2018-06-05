package com.menga.war3;

/**
 * 单位
 *
 * Created by Marvel on 2018/6/4.
 */
public class Unit {

    // the level of power
    protected Integer level = 1;
    // the time of attack once
    protected Double attackDelay = 0.5;

    protected Integer attack;
    protected Integer armor;
    protected Integer hp;

    public Unit() {}

    public Integer getPdps() {
        return (int)(getAttack() / attackDelay);
    }

    public Integer getMdps() {
        return 0;
    }

    public Integer getDps() {
        return getPdps() + getMdps();
    }

    public Integer getLevel() {
        return level;
    }

    public Unit setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Unit setAttackDelay(Double attackDelay) {
        this.attackDelay = attackDelay;
        return this;
    }

    public Integer getAttack() {
        return attack;
    }

    public Unit setAttack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public Integer getArmor() {
        return armor;
    }

    public Unit setArmor(Integer armor) {
        this.armor = armor;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public Unit setHp(Integer hp) {
        this.hp = hp;
        return this;
    }
}
