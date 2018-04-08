package com.menga.enums;

/**
 * Created by Marvel on 2018/1/22.
 */
public enum E {
    /**
     *
     **/
    AA(1),

    /**
     *
     **/
    A(2),

    /**
     *
     **/
    B(3),

    /**
     *
     **/
    C(4),

    /**
     *
     **/
    D(5),

    /**
     *
     **/
    E(6);


    private final int value;

    private E(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static E findByValue(int value) {
        switch (value) {

            case 1:
                return AA;

            case 2:
                return A;

            case 3:
                return B;

            case 4:
                return C;

            case 5:
                return D;

            case 6:
                return E;

            default:
                return null;
        }
    }
}
