package com.menga.war3;

/**
 * 单位
 *
 * Created by Marvel on 2018/6/4.
 */
public class Unit implements UnitPower {

    // the level of power
    protected Integer level;
    // the time of attack once
    protected Double attackDelay;

    protected Integer attack;
    protected Integer armor;
    protected Integer hp;

    public Unit() {
        level = 1;
        attackDelay = 1.0;
    }

    @Override
    public Integer getPdps() {
        return (int)(attack / attackDelay);
    }

    @Override
    public Integer getMdps() {
        return 0;
    }

    @Override
    public Integer getRps() {
        return 0;
    }

    @Override
    public Integer getArmor() {
        return armor;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    // Setter

    public Unit setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Unit setAttackDelay(Double attackDelay) {
        this.attackDelay = attackDelay;
        return this;
    }

    public Unit setAttack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public Unit setArmor(Integer armor) {
        this.armor = armor;
        return this;
    }

    public Unit setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

}
