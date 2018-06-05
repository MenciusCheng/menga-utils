package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class Boss extends Unit {

    public Boss() {
        super();
    }

    @Override
    public String toString() {
        return "Boss{" +
                "attack=" + getAttack() +
                ", armor=" + getArmor() +
                ", hp=" + getHp() +
                ", attackDelay=" + getAttackDelay() +
                ", level=" + getLevel() +
                '}';
    }
}
