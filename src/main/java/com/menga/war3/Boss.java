package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class Boss extends Unit {

    public Boss() {
        super();
        attackDelay = 0.5;
    }

    @Override
    public Integer getRps() {
        return (int)(hp * 0.05);
    }

    // Setter

    @Override
    public Boss setLevel(Integer level) {
        super.setLevel(level);
        return this;
    }

    @Override
    public Boss setAttackDelay(Double attackDelay) {
        super.setAttackDelay(attackDelay);
        return this;
    }

    @Override
    public Boss setAttack(Integer attack) {
        super.setAttack(attack);
        return this;
    }

    @Override
    public Boss setArmor(Integer armor) {
        super.setArmor(armor);
        return this;
    }

    @Override
    public Boss setHp(Integer hp) {
        super.setHp(hp);
        return this;
    }
}
