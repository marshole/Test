/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author weixuhui Date: 2021/4/21 Time: 7:22 下午
 */
public class ThreadTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /*实现 Runnable 创建一个线程 */
        Runnable runnableTest = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableTest run");
            }
        };
        Thread runnableT = new Thread(runnableTest);
        runnableT.start();


        /*实现 Callable 创建一个线程 */
        Callable callableTest = new Callable() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callableTest run");
                return 1;
            }
        };
        FutureTask ft = new FutureTask(callableTest);
        Thread callableT = new Thread(ft);
        callableT.start();
        System.out.println(ft.get());



        /*继承 Thread 创建一个线程 */
        Thread threadTest = new Thread() {
            @Override
            public void run() {
                System.out.println("threadTest run");
            }
        };
        threadTest.start();
    }

}
