/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.gc;

/**
 * @author weixuhui Date: 2021/4/16 Time: 3:17 下午
 */
public class Test_1 {

    static int i = 1;

    static {

        i = 0;
    }

    public static void main(String[] args) {
        System.out.println(Test_1.i);
    }
}
