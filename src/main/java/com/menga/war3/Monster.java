package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class Monster {

    // the level of power
    private Integer level = 1;
    // the time of attack once
    private Double attackDelay = 1.0;
    private String name = "";

    private Integer attack;
    private Integer armor;
    private Integer hp;

    public Monster() {}

    public Integer getLevel() {
        return level;
    }

    public Monster setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Monster setName(String name) {
        this.name = name;
        return this;
    }

    public Double getAttackDelay() {
        return attackDelay;
    }

    public Monster setAttackDelay(Double attackDelay) {
        this.attackDelay = attackDelay;
        return this;
    }

    public Integer getAttack() {
        return attack;
    }

    public Monster setAttack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public Integer getArmor() {
        return armor;
    }

    public Monster setArmor(Integer armor) {
        this.armor = armor;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public Monster setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    /**
     * damage per second
     */
    public Integer getDps() {
        return (int)(attack / attackDelay);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monster{");
        sb.append("level=").append(level);
        if (name != null && name.length() > 0) {
            sb.append(", name=").append(name);
        }
        sb.append(", attack=").append(attack);
        sb.append(", armor=").append(armor);
        sb.append(", hp=").append(hp);
        sb.append(", attackDelay=").append(attackDelay);
        sb.append('}');
        return sb.toString();
    }
}
