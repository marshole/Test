/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.gc.classload;

/**
 * @author weixuhui Date: 2021/4/20 Time: 2:06 下午
 */
public class TestA {


    private  static String tag = "TestA";
    //静态变量
    private static int  staticVarA = initVar("staticVarA");

    //静态代码块
    static{
        initVar("static init block ");
    }
    //普通变量
    private  int normalA = initVar("normalA");

    // 普通代码块
    {
        initVar("normal init block");
    }

    public TestA(){
        System.out.println(initVar("constructor"));
    }
    static int initVar(String str){

        System.out.println(tag +" "+str);

        return 2018;
    }
}
