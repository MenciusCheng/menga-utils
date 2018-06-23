package com.menga.war3;

/**
 * Created by menci on 2018/6/23.
 */
public interface UnitPower {

    /**
     * physical damage per second
     */
    Integer getPdps();

    /**
     * magic damage per second
     */
    Integer getMdps();

    /**
     * recovery per second
     */
    Integer getRps();

    Integer getArmor();

    Integer getHp();

}
