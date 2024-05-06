/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.volatole;


/**
 * volatile 防重排序的例子
 *
 * @author weixuhui Date: 2023/10/16 Time: 19:49
 */
public class Singleton {

    /**
     * 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
     * 1、为uniqueInstance 分配内存空间
     * 2、初始化uniqueInstance
     * 3、将 uniqueInstance 指向分配的内存地址
     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
     * 例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
     * ------
     * 著作权归JavaGuide(javaguide.cn)所有
     * 基于MIT协议
     * 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-02.html
     */
    private static volatile Singleton uniqueInstance;

    private Singleton() {

    }

    public static Singleton getInstance() {

        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                    return uniqueInstance;
                }
            }
        }

        return uniqueInstance;
    }
}
