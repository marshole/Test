/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy;


import com.wxh.note.java.patterns.proxy.dynamicProxy.JdkProxyFactory;
import com.wxh.note.java.patterns.proxy.staticProxy.StaticProxy;

/**
 * @author weixuhui Date: 2023/10/15 Time: 14:21
 */
public class ProxyTest {

    public static void main(String[] args) {
        testStaticProxy();

        testJdkProxy();
    }

    private static void testStaticProxy() {
        SmsService smsService = new StaticProxy(new SmsServiceImpl());
        smsService.send("testStaticProxy");
        System.out.println("testStaticProxy end ...");

    }


    private static void testJdkProxy() {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("testJdkProxy");
        System.out.println("testJdkProxy end ...");

    }
}
