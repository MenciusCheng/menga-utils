package com.menga.thread;

/**
 * Created by Marvel on 18/12/29.
 */
public class TaskDemo implements Runnable {

    private int taskNum;

    public TaskDemo(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
