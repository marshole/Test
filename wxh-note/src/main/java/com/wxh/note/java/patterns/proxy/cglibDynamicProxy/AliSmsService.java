/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy.cglibDynamicProxy;

/**
 * @author weixuhui Date: 2023/10/15 Time: 14:50
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
