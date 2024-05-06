/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy.staticProxy;

import com.wxh.note.java.patterns.proxy.SmsService;

/**
 * @author weixuhui Date: 2023/10/15 Time: 14:34
 */
public class StaticProxy implements SmsService {

    private final SmsService smsService;

    public StaticProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before staticProxy");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after staticProxy");
        return null;
    }
}
