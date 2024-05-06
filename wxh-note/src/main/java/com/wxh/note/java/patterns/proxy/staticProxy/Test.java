/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy.staticProxy;


import com.wxh.note.java.patterns.proxy.SmsService;
import com.wxh.note.java.patterns.proxy.SmsServiceImpl;

/**
 * @author weixuhui Date: 2023/10/15 Time: 14:21
 */
public class Test {

    public static void main(String[] args) {
        testStaticProxy();
    }

    private static void testStaticProxy() {
        SmsService smsService = new StaticProxy(new SmsServiceImpl());
        smsService.send("testStaticProxy");
        System.out.println("testStaticProxy end ...");

    }
}
