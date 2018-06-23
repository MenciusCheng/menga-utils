package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class Hero implements UnitPower {

    private final static Double ADD_ATTACK_PER_ABILITY = 1.0;
    private final static Double ADD_ARMOR_PER_ABILITY = 0.3;
    private final static Double ADD_HP_PER_ABILITY = 25.0;
    private final static Double ADD_MP_PER_ABILITY = 15.0;
    private final static Double MAGIC_DAMAGE_PER_ABILITY = 4.0;

    // the level of power
    private Integer level = 1;
    // the time of attack once
    private Double attackDelay = 0.5;
    private Double coolDown = 1.0;

    private Integer strength = 0;
    private Integer agility = 0;
    private Integer intelligence = 0;

    // 1: strength, 2: agility, 3: intelligence
    private Integer mainAbilityType = 1;

    private Integer addedAttack = 0;
    private Integer addedArmor = 0;
    private Integer addedHp = 0;
    private Integer addedMp = 0;

    public Hero() {}

    @Override
    public Integer getPdps() {
        return (int)(getAttack() / attackDelay);
    }

    @Override
    public Integer getMdps() {
        return (int)(getMagic() / coolDown);
    }

    @Override
    public Integer getRps() {
        return 0;
    }

    @Override
    public Integer getArmor() {
        return (int)(agility * ADD_ARMOR_PER_ABILITY + addedArmor);
    }

    @Override
    public Integer getHp() {
        return (int)(strength * ADD_HP_PER_ABILITY + addedHp);
    }

    private Integer getMp() {
        return (int)(intelligence * ADD_MP_PER_ABILITY + addedMp);
    }

    private Integer getAttack() {
        return (int)(getMainAbility() * ADD_ATTACK_PER_ABILITY + addedAttack);
    }

    private Integer getMagic() {
        return (int)(getMainAbility() * MAGIC_DAMAGE_PER_ABILITY);
    }

    private Integer getMainAbility() {
        if (mainAbilityType == 1)
            return strength;
        else if (mainAbilityType == 2)
            return agility;
        else if (mainAbilityType == 3)
            return intelligence;
        else
            return 0;
    }

    // Setter

    public Hero setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Hero setAttackDelay(Double attackDelay) {
        this.attackDelay = attackDelay;
        return this;
    }

    public Hero setCoolDown(Double coolDown) {
        this.coolDown = coolDown;
        return this;
    }

    public Hero setStrength(Integer strength) {
        this.strength = strength;
        return this;
    }

    public Hero setAgility(Integer agility) {
        this.agility = agility;
        return this;
    }

    public Hero setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public Hero setMainAbilityType(Integer mainAbilityType) {
        this.mainAbilityType = mainAbilityType;
        return this;
    }

    public Hero setAddedAttack(Integer addedAttack) {
        this.addedAttack = addedAttack;
        return this;
    }

    public Hero setAddedArmor(Integer addedArmor) {
        this.addedArmor = addedArmor;
        return this;
    }

    public Hero setAddedHp(Integer addedHp) {
        this.addedHp = addedHp;
        return this;
    }

    public Hero setAddedMp(Integer addedMp) {
        this.addedMp = addedMp;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hero{");
        sb.append("level=").append(level);
        sb.append(", pdps=").append(getPdps());
        sb.append(", mdps=").append(getMdps());
        sb.append(", attack=").append(getAttack());
        sb.append(", magic=").append(getMagic());
        sb.append(", armor=").append(getArmor());
        sb.append(", hp=").append(getHp());
//        sb.append(", attackDelay=").append(attackDelay);
//        sb.append(", coolDown=").append(coolDown);
        sb.append(", strength=").append(strength);
        sb.append(", agility=").append(agility);
        sb.append(", intelligence=").append(intelligence);
        sb.append(", mainAbilityType=").append(mainAbilityType);
        sb.append(", addedAttack=").append(addedAttack);
        sb.append(", addedArmor=").append(addedArmor);
        sb.append(", addedHp=").append(addedHp);
        sb.append('}');
        return sb.toString();
    }

}
