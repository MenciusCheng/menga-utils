package com.menga.jvm;

/**
 * Created by Marvel on 2019/7/1.
 */
public class AllocationDemo {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        testAllocation();
    }

    /**
     * VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    public static void testAllocation() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        System.out.println("111");
        allocation2 = new byte[2 * _1MB];
        System.out.println("111");
        allocation3 = new byte[2 * _1MB];
        System.out.println("111");
        Thread.sleep(1000);
        allocation4 = new byte[4 * _1MB]; // 出现一次 Minor GC
        System.out.println("111");
    }


}
