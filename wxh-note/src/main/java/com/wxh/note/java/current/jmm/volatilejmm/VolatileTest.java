/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.jmm.volatilejmm;

import com.wxh.note.java.current.jmm.FinalJMM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weixuhui Date: 2021/3/4 Time: 3:00 下午
 */
public class VolatileTest {

    public static void main(String[] args) {


        VolatileTestModel volatileTestModel = new VolatileTestModel();



        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //每一次循环都会创建一个线程，因为在新的线程执行的时候，原有创建的线程都还没有结束
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "==>" + index);
                }
            });
        }


        Thread treadA = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("treadA读到：" + volatileTestModel.getValue());

                System.out.println("treadA把值设置为：" + 1L);

                volatileTestModel.setValue(1L);

                System.out.println("treadA再次读到：" + volatileTestModel.getValue());
            }
        });

        treadA.setName("treadA");

        Thread treadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("treadB读到：" + volatileTestModel.getValue());

                System.out.println("treadB把值设置为：" + 2L);

                volatileTestModel.setValue(2L);

                System.out.println("treadB再次读到：" + volatileTestModel.getValue());
            }
        });

        treadB.setName("treadB");

        treadA.run();
        treadB.run();
    }




}
