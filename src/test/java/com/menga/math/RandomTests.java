package com.menga.math;

import org.junit.Test;

/**
 * Created by Marvel on 18/12/11.
 */
public class RandomTests {

    @Test
    public void test1() {
        int[] arr = new int[11];
        for (int i = 0; i < 1000000; i ++) {
            int value = (int) (2 + Math.random() * (10 - 2 + 1));
            arr[value] += 1;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(j + "=" + arr[j] + "; ");
        }
    }
}
