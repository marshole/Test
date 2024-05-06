/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread.threadstate;

/**
 * @author weixuhui Date: 2023/10/16 Time: 13:49
 */
public class SleepDemo {

    static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (running){
                System.out.println("t1 running is false , t1 将sleep");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("new t1 状态："+ t1.getState());

        t1.start();

        Thread.sleep(2000L);

        running = false;

        Thread.sleep(2000L);

        System.out.println("t1 sleep时的 状态："+ t1.getState());
    }
}
