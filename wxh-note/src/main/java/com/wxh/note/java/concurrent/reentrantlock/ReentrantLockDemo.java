/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weixuhui Date: 2023/10/24 Time: 20:35
 */
public class ReentrantLockDemo {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);

        Runnable runnable = () -> {

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + ":拿到lock");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                System.out.println(Thread.currentThread().getName() + ":解lock");
                lock.unlock();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();
    }
}


