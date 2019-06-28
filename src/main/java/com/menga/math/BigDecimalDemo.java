package com.menga.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Marvel on 2019/6/27.
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        // 初始化值的方法
        BigDecimal b = BigDecimal.valueOf(2.3);
        BigDecimal a = BigDecimal.valueOf(2);
        System.out.println("a = " + a + ", b = " + b);

        Integer z = b.intValue();

        BigDecimal a2 = new BigDecimal("2");
        BigDecimal b2 = new BigDecimal("2.3");
        System.out.println("a2 = " + a2 + ", b2 = " + b2);

        // 这种方式会有精度问题
        BigDecimal b3 = new BigDecimal(2.3);
        System.out.println("b3 = " + b3);

        System.out.println("a + b = " + a.add(b));
        System.out.println("b - a = " + b.subtract(a));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("1 / 3 = " + BigDecimal.ONE.divide(BigDecimal.valueOf(3), 5, RoundingMode.HALF_UP));
    }
}
