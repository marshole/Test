/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.executor;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weixuhui Date: 2021/5/23 Time: 9:22 下午
 */
public class Test {


    public static void main(String[] args) {
        
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 1; i <= 100; i++) {

            MyThread thread = new MyThread(String.valueOf(i));

            executorService.execute(thread);
        }

        executorService.shutdown();
    }


    public static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("thread " + getName() + " is running");
        }
    }


}
