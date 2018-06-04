package com.menga.war3;

/**
 * Created by Marvel on 2018/6/4.
 */
public class Monster extends Unit {

    // 怪物等级，表示波数
    private Integer level;

    public Monster() {
        super();
        setAttackDelay(1.0);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
