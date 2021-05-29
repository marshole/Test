/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.thread;

/**
 * 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加
 *
 * @author weixuhui Date: 2021/5/22 Time: 10:46 下午
 */
public class TenThreadSum {


    public static void main(String[] args) {

        Adder adder = new Adder();


        for (int i = 0; i < 10; i++) {
            AddThread thread = new AddThread(i, adder);
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(adder.getR());
    }

    public static class AddThread extends Thread {

        private int start;

        private Adder adder;

        public AddThread(int start, Adder adder) {
            this.start = start;
            this.adder = adder;
        }

        @Override
        public void run() {
            adder.add(start * 10 + 1, start * 10 + 10);
        }
    }


    public static class Adder {

        public int r;

        public int getR() {
            return r;
        }

        public void add(int start, int end) {

            int result = 0;

            for (int i = start; i <= end; i++) {
                result = result + i;
            }


            addResult(result);
        }

        public synchronized void addResult(int result) {
            r = r + result;
        }
    }

}
