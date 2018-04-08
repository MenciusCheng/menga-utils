package com.menga.utils;

/**
 * Created by Marvel on 2018/1/16.
 */
public class PrintUtils {

    public static void p(String... args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
        }
        System.out.println(sb);
    }
}
