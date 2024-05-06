/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread;

/**
 * 要求线程a执行完才开始线程b, 线程b执行完才开始线程
 * <p>
 * https://blog.csdn.net/qq_18505715/article/details/79795728
 *
 * @author weixuhui Date: 2021/5/22 Time: 8:48 下午
 */
public class T1T2T3 {

    public static void main(String[] args) throws Exception {

        testJoin();


    }

    public static void testJoin() throws InterruptedException {

        Thread thread_1 = new MyThread("thread_1");
        Thread thread_2 = new MyThread("thread_2");
        Thread thread_3 = new MyThread("thread_3");

        thread_1.start();
        thread_1.join();

        thread_2.start();
        thread_2.join();

        thread_3.start();
        thread_3.join();
    }

    /**
     * @author weixuhui Date: 2021/5/22 Time: 9:20 下午
     */
    public static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName());
        }
    }
}
