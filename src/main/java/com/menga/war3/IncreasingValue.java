package com.menga.war3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 递增值
 *
 *  设 N 为等级
 *  递增值(N) = 递增值(N-1) * 上一个因数 + N * 等级因数 + 固定因数
 *
 * Created by Marvel on 2018/6/22.
 */
public class IncreasingValue {

    // 上一个因数
    private Double lastFactor = 0.0;
    // 固定因数
    private Double fixedFactor = 0.0;
    // 等级因数
    private Double levelFactor = 0.0;
    // 表格因数，即等级直接对应的值
    private List<Double> grid = new ArrayList<>();

    public Double getValueByLevel(Integer level) {
        if (level == null || level <= 0) {
            return 0.0;
        }if (level <= grid.size() && grid.get(level - 1) != null) {
            return grid.get(level - 1);
        } else {
            //  递增值(N) = 递增值(N-1) * 上一个因数 + N * 等级因数 + 固定因数
            return getValueByLevel(level - 1) * lastFactor + level * levelFactor + fixedFactor;
        }
    }

    public static void main(String[] args) {
        IncreasingValue iv = new IncreasingValue().setLastFactor(1.6).setGrid(Collections.singletonList(100.0));
        for (int level = 1; level <= 30; level++) {
            System.out.println("v" + level + "   = " + iv.getValueByLevel(level).longValue());
            System.out.println("v" + level + ".5 = " + (int)(iv.getValueByLevel(level) * 1.3));
        }

//        IncreasingValue iv2 = new IncreasingValue().setLastFactor(1.6).setGrid(Arrays.asList(2.0));
//        for (int level = 1; level <= 7; level++) {
//            System.out.println("hits = " + iv2.getValueByLevel(level).longValue());
//        }

    }

    // Setter

    public IncreasingValue setLastFactor(Double lastFactor) {
        this.lastFactor = lastFactor;
        return this;
    }

    public IncreasingValue setFixedFactor(Double fixedFactor) {
        this.fixedFactor = fixedFactor;
        return this;
    }

    public IncreasingValue setLevelFactor(Double levelFactor) {
        this.levelFactor = levelFactor;
        return this;
    }

    public IncreasingValue setGrid(List<Double> grid) {
        this.grid = grid;
        return this;
    }
}
