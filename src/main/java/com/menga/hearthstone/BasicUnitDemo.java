package com.menga.hearthstone;

/**
 * Created by Marvel on 18/11/26.
 */
public class BasicUnitDemo {

    public static void main(String[] args) {
        for (double i = 0.0; i <= 10; i += 0.5) {
            System.out.println("i=" + i);
            long ab = Math.round(i * 2 + 2);
            for (int attack = 0; attack <= ab - 1; attack++) {
                System.out.print(Math.round(i) + "-" + attack + "-" + (ab - attack) + " ");
            }
            System.out.println("");
        }
    }
}
