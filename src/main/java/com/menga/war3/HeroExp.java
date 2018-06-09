package com.menga.war3;

import java.util.Arrays;
import java.util.List;

/**
 * 英雄经验值
 *
 * Created by menci on 2018/6/9.
 */
public class HeroExp {

    // 英雄经验获得 - 普通，上一个因数
    private static final Double obtainedLastFactor = 1.00;
    // 英雄经验获得 - 普通，固定因数
    private static final Double obtainedFixedFactor = 5.00;
    // 英雄经验获得 - 普通，等级因数
    private static final Double obtainedLevelFactor = 5.00;
    // 英雄经验获得 - 普通，表格
    private static final List<Integer> obtainedGrid = Arrays.asList(25);

    // 英雄经验获得 - 英雄，上一个因数
    private static final Double obtainedLastFactorByHero = 1.00;
    // 英雄经验获得 - 英雄，固定因数
    private static final Double obtainedFixedFactorByHero = 100.00;
    // 英雄经验获得 - 英雄，等级因数
    private static final Double obtainedLevelFactorByHero = 0.00;
    // 英雄经验获得 - 英雄，表格
    private static final List<Integer> obtainedGridByHero = Arrays.asList(100,120,160,220,300);

    // 英雄经验需求 - 上一个因数
    private static final Double neededLastFactor = 1.00;
    // 英雄经验需求 - 固定因数
    private static final Double neededFixedFactor = 0.00;
    // 英雄经验需求 - 等级因数
    private static final Double neededLevelFactor = 100.00;
    // 英雄经验需求 - 表格（从2级开始）
    private static final List<Integer> neededGrid = Arrays.asList(200);

    /**
     * 获取 N 级怪物给与的经验值
     * N 为怪物等级，当表格内有配置经验值则取表格内的值，否则：
     * EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
     */
    public static Double getObtainedExpByLevel(Integer level) {
        if (level == null || level <= 0) {
            return 0.0;
        }
        if (level <= obtainedGrid.size()) {
            return (double)obtainedGrid.get(level - 1);
        } else {
            //  EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
            return getObtainedExpByLevel(level - 1) * obtainedLastFactor + level * obtainedLevelFactor + obtainedFixedFactor;
        }
    }

    /**
     * 获取 N 级英雄给与的经验值
     * N 为英雄等级，当表格内有配置经验值则取表格内的值，否则：
     * EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
     */
    public static Double getObtainedExpHeroByLevel(Integer level) {
        if (level == null || level <= 0) {
            return 0.0;
        }
        if (level <= obtainedGridByHero.size()) {
            return (double)obtainedGridByHero.get(level - 1);
        } else {
            //  EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
            return getObtainedExpHeroByLevel(level - 1) * obtainedLastFactorByHero + level * obtainedLevelFactorByHero + obtainedFixedFactorByHero;
        }
    }

    /**
     * 获取达到 N 级英雄需要的经验值
     * N 为英雄等级，当表格内有配置经验值则取表格内的值，否则：
     * EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
     */
    public static Double getNeededExpByLevel(Integer level) {
        if (level == null || level < 2) {
            return 0.0;
        }
        if (level <= neededGrid.size()) {
            return (double)neededGrid.get(level - 2);
        } else {
            //  EXP(N) = EXP(N-1) * 上一个因数 + N * 等级因数 + 固定因数
            return getNeededExpByLevel(level - 1) * neededLastFactor + level * neededLevelFactor + neededFixedFactor;
        }
    }

    /**
     * N 级英雄升级时需要的经验值
     */
    public static Double getUpgradedExpByLevel(Integer level) {
        return getNeededExpByLevel(level + 1) - getNeededExpByLevel(level);
    }

    public static void main(String[] args) {
//        for (int i = 1; i <= 20; i++) {
//            Double obtainedExp = getObtainedExpByLevel(i);
//            System.out.println("怪物等级为" + i + "，给与的经验值为：" + obtainedExp);
//        }
        Double obtainedExpLevel1 = getObtainedExpByLevel(1);
        Double obtainedExpLevel2 = getObtainedExpByLevel(2);
        for (int i = 1; i <= 100; i++) {
            Double upgradedExp = getUpgradedExpByLevel(i);
            Integer n1 = (int)(upgradedExp / obtainedExpLevel1);
            Integer n2 = (int)(upgradedExp / obtainedExpLevel2);
            System.out.println("英雄等级为" + i + "，升级需要的经验值为：" + upgradedExp + "，需要击杀1级怪" + n1 + "个，或者击杀2级怪" + n2 + "个");
        }
    }

}
