package com.menga.jvm;

/**
 * Created by Marvel on 2019/7/1.
 */
public class GCDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        System.gc();
    }
}
