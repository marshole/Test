/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread.threadstate;

/**
 * @author weixuhui Date: 2023/10/16 Time: 14:32
 */
public class WaitDemo {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1：抢到lock");
                try {
                    System.out.println("t1：将wait(1100L)");
                    lock.wait(1100L);
                    System.out.println("t1：将wait(1000L)");
                    lock.wait(1000L);
                    System.out.println("t1：执行完");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(1000L);

        synchronized (lock) {
            System.out.println("主线程：抢到lock");
            System.out.println("主线程：t1状态：" + t1.getState());
            System.out.println("主线程：将wait(1000L)");
            lock.wait(1000L);
            System.out.println("主线程：t1状态：" + t1.getState());
        }

        Thread.sleep(3000L);
        System.out.println("主线程：t1状态：" + t1.getState());

        Thread.sleep(1000L);
        synchronized (lock) {
            lock.notify();
        }

        System.out.println("主线程：t1状态：" + t1.getState());
        Thread.sleep(1000L);
        System.out.println("主线程：t1状态：" + t1.getState());
    }
}
