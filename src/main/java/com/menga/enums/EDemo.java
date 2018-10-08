package com.menga.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvel on 2018/1/22.
 */
public class EDemo {

    private static int j = 0;

    public static void main(String[] args) {
//        E aa = E.findByValue(1);
//        System.out.println(aa.toString());

        List<Integer> ls = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            ls.add(i);
        }

        ls.stream()
                .filter((t) -> {
                    Boolean f = j++ == t;
                    System.out.print("fi:");
                    System.out.print(j);
                    System.out.println(f);
                    return f;

                }).forEach((t) -> {
                    j++;
            System.out.print("fe:");
                    System.out.println(j);
                });


        ls.stream()
                .filter((t)->{System.out.println("fi1"); return true;})
                .filter((t)->{System.out.println("fi2"); return true;})
                .forEach((t)->{System.out.println("fe1");});

        System.out.println(j);
    }
}
