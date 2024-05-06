/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.patterns.proxy.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author weixuhui Date: 2023/10/15 Time: 15:03
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
