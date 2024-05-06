/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy.dynamicProxy;


import com.wxh.note.java.patterns.proxy.SmsService;
import com.wxh.note.java.patterns.proxy.SmsServiceImpl;

/**
 * @author weixuhui Date: 2023/10/15 Time: 14:21
 */
public class Test {

    public static void main(String[] args) {
        testJdkProxy();
    }

    private static void testJdkProxy() {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("testJdkProxy");
        System.out.println("testJdkProxy end ...");

    }
}
