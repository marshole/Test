/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

/**
 * 两个线程轮流打印数字，一直到100
 *
 * @author weixuhui Date: 2021/5/22 Time: 9:20 下午
 */
public class TakeTurnsPrint {


    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer();


//        Thread thread_1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    printer.printer1();
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//
//        Thread thread_2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    printer.printer2();
//                } catch (InterruptedException e) {
//                }
//            }
//        });
//
//        thread_1.start();
//        thread_2.start();

        Callable thread_3 = new Callable<Object>(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };


        Runnable thread_1 = new Runnable() {
            @Override
            public void run() {
                try {
                    printer.printer1();
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable thread_2 = new Runnable() {
            @Override
            public void run() {
                try {
                    printer.printer2();
                } catch (InterruptedException e) {
                }
            }
        };

        thread_1.run();
        thread_2.run();


    }

    public static class Printer {

        private int i;

        public synchronized void printer1() throws InterruptedException {
            while (i <= 100) {
                if (i % 2 == 1) {
                    System.out.println(i);
                    i++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }

        public synchronized void printer2() throws InterruptedException {
            while (i <= 100) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    i++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }


}
