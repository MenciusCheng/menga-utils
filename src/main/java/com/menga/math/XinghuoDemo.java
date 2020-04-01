package com.menga.math;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Marvel on 19/02/13.
 */
public class XinghuoDemo {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 6, 18, 14, 500, 30, 70);

        for (Integer a : arr) {

            boolean specialNum = isSpecialNum(a);
            System.out.println("a=" + a + " ,specialNum=" + specialNum);

        }
    }

    /**
     * 判断给定的数是否为特殊数。
     * 特殊数就是只包含质因数 2, 3, 5 的正整数。
     * 另外，1也是特殊数。
     * 如：6 = 2 * 3，是特殊数
     * 18 = 2 * 3 * 3，是特殊数
     * 14 = 2 * 7，不是特殊数
     */
    public static boolean isSpecialNum(int num) {
        List<Integer> arr = Arrays.asList(2, 3, 5);
        Integer s = num;
        boolean flag = false;
        while (true) {
            if (s.equals(1)) {
                flag = true;
                break;
            } else if (s % arr.get(0) == 0) {
                s = s / arr.get(0);
            } else if (s % arr.get(1) == 0) {
                s = s / arr.get(1);
            } else if (s % arr.get(2) == 0) {
                s = s / arr.get(2);
            } else {
                break;
            }
        }
        return flag;
    }
}
