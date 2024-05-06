/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.base.string;

/**
 * @author weixuhui Date: 2021/4/20 Time: 2:46 下午
 */
public class StringTest {

    public static void main(String[] args) {

        String a = new String("a");
        String b = String.valueOf("a");
        String c = new String(a);


        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

    }

    public static void change(String a) {
        a = "b";
    }
}
