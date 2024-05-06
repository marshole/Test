/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread;

/**
 * 两线程，一个打印数字从1到52，另一个打印字母从A到Z，输出：12A34B56C...5152Z
 *
 * @author weixuhui Date: 2021/5/22 Time: 9:39 下午
 */
public class TakeTurnsPrint2 {

    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printer.printer1();
                } catch (Exception e) {
                }
            }
        });

        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printer.printer2();
                } catch (Exception e) {
                }
            }
        });

        thread_1.start();
        thread_2.start();

    }

    public static class Printer {

        private int printer1S = 2;

        private int printer2S = -1;

        public synchronized void printer1() throws InterruptedException {

            int i = 1;

            while (i <= 52) {
                if (printer1S > 0) {
                    System.out.println(i);
                    i++;
                    printer1S--;
                    notifyAll();
                } else {
                    printer2S = 1;
                    wait();
                }
            }

            printer2S = 1;
            notifyAll();
        }


        public synchronized void printer2() throws InterruptedException {

            int i = 1;

            while (i <= 26) {
                if (printer2S == 1) {
                    System.out.println((char) (64 + i));
                    i++;
                    printer2S--;
                    notifyAll();
                } else if (printer2S == -1) {
                    notifyAll();
                } else {
                    printer1S = 2;
                    wait();
                }
            }
        }
    }


}

