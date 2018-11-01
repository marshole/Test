package com.wxh.note.java.thread;

/**
 * @author weixuhui
 * @Description
 * @Date 18/8/30 上午11:51
 **/
public class StartAndRunTest {

    public static void main(String[] args) {

        System.out.println("主线程ID:"+Thread.currentThread().getId());

        MyThread thread1 = new MyThread();

        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
    }

    static class MyThread extends Thread {

        public MyThread() {}

        @Override
        public void run() {
            System.out.println("name:" + this.getName() + "子线程ID:"+Thread.currentThread().getId());
        }
    }
}

