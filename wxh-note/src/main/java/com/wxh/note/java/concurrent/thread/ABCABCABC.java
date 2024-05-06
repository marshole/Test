/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.thread;

/**
 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
 *
 * @author weixuhui Date: 2021/5/22 Time: 10:29 下午
 */
public class ABCABCABC {


    public static void main(String[] args) {

        Printer printer = new Printer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printA();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printB();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printC();
            }
        }).start();


    }


    public static class Printer {

        int countA = 0;
        int countB = 0;
        int countC = 0;

        int flag;

        public synchronized void printA() {

            while (countA < 5) {

                if (flag != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("A");
                    countA++;
                    flag = 1;
                    notifyAll();
                }

            }
        }

        public synchronized void printB() {

            while (countB < 5) {
                if (flag != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("B");
                    countB++;
                    flag = 2;
                    notifyAll();
                }
            }
        }

        public synchronized void printC() {

            while (countC < 5) {
                if (flag != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("C");
                    countC++;
                    flag = 0;
                    notifyAll();
                }
            }
        }

    }


}
