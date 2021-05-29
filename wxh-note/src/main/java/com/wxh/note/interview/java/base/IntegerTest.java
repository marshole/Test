/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.interview.java.base;

/**
 * @author weixuhui Date: 2021/4/20 Time: 2:35 下午
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i = new Integer(1);

        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(1);


        System.out.println(a);
        System.out.println(b);

        b ++;

        System.out.println(a);
        System.out.println(b);



        System.out.println(i == a);
        System.out.println(a == b);
    }
}
