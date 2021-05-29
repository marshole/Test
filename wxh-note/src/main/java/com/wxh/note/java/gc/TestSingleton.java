/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.gc;

/**
 * @author weixuhui Date: 2021/4/20 Time: 1:07 下午
 */
public class TestSingleton {

    private static TestSingleton singleton = new TestSingleton();
    public static int counter1;
    public static int counter2 = 0;

    private TestSingleton() {
        counter1++;
        counter2++;
    }

    public static TestSingleton getSingleton() {
        return singleton;
    }

    static {
        counter1++;
        counter2++;
    }

    public static void main(String args[]){
        TestSingleton singleton = TestSingleton.getSingleton();
        System.out.println("counter1="+singleton.counter1);
        System.out.println("counter2="+singleton.counter2);

    }


}
