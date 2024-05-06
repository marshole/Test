/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread.threadstate;

/**
 * @author weixuhui Date: 2023/10/16 Time: 14:15
 */
public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (SynchronizedDemo.class) {
                System.out.println("t1开始执行");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        synchronized (SynchronizedDemo.class) {
            t1.start();
            System.out.println("t1的状态：" + t1.getState());
            Thread.sleep(1000L);
            System.out.println("t1的状态：" + t1.getState());

        }

        System.out.println("o t1的状态：" + t1.getState());

        Thread.sleep(1000L);
        System.out.println("o t1的状态：" + t1.getState());

    }
}
