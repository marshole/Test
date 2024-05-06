package com.wxh.note.java.concurrent.jmm;

/**
 * @author weixuhui
 * @Description final域的内存语义
 * @Date 19/2/12 下午5:52
 **/
public class FinalJMM {


    int i;

    final int j;

    static FinalJMM obj;

    public FinalJMM() {
        i = 1;
        j = 2;
    }

    public static void writer() {
        obj = new FinalJMM();
    }

    public static void reader() {
        FinalJMM object = obj;
        int a = object.i;
        System.out.println(Thread.currentThread().getName());
        System.out.println(a);
        int b = object.j;
        System.out.println(b);
    }

    public static void main(String[] args) {

        Thread treadA = new Thread(new Runnable() {
            @Override
            public void run() {
                FinalJMM.writer();
            }
        });

        treadA.setName("treadA");

        Thread treadB = new Thread(new Runnable() {
            @Override
            public void run() {
                FinalJMM.reader();
            }
        });

        treadB.setName("treadB");

        treadA.run();
        treadB.run();
    }
}
