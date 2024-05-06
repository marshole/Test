/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.gc.classload;

/**
 * @author weixuhui Date: 2021/4/20 Time: 2:10 下午
 */
public class Init {


    private static String tag = "Init";

    /*静态变量*/
    private static int staticVarA = initVar("staticVarA");
    private static TestA nB = new TestA();

    /*普通变量*/
    private int normalA = initVar("normalA");
    private TestA nb2 = new TestA();

    //静态代码块
    static {
        initVar("static init block ");
    }

    // 普通代码块
    {
        initVar("normal init block");
    }


    public Init() {
        System.out.println(initVar("constructor"));
    }

    static int initVar(String str) {

        System.out.println(tag + " " + str);

        return 2020;
    }

    public static void main(String[] args) {
        System.out.println("-------main method-------");
        System.out.println("do nothing");

    }
}
