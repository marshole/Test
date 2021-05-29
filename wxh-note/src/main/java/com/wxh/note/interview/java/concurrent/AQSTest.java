/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.interview.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author weixuhui Date: 2021/4/22 Time: 2:18 下午
 */
public class AQSTest {


    public static void main(String[] args) throws InterruptedException {

        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
