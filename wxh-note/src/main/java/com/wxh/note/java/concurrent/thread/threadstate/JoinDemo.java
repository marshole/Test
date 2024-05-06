/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread.threadstate;

/**
 * @author weixuhui Date: 2023/10/16 Time: 14:01
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2执行t1.join(5000L)");
                t1.join(5000L);
                System.out.println("t2执行t1.join()");
                t1.join();
                System.out.println("t2执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000L);

        System.out.println("t2 状态："+ t2.getState());

        Thread.sleep(50000L);

        System.out.println("t2 状态："+ t2.getState());
    }
}
