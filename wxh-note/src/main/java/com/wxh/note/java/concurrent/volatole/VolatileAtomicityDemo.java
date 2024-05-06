/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.volatole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile 不支持原子性的例子
 * <p>
 * 正常情况下，运行下面的代码理应输出 5000。但你真正运行了上面的代码之后，你会发现每次输出结果都小于 5000。
 * 为什么会出现这种情况呢？不是说好了，volatile 可以保证变量的可见性嘛！
 * 也就是说，如果 volatile 能保证 inc++ 操作的原子性的话。每个线程中对 inc 变量自增完之后，其他线程可以立即看到修改后的值。5 个线程分别进行了 1000 次操作，那么最终 inc 的值应该是 5*1000=5000。
 * <p>
 * 很多人会误认为自增操作 inc++ 是原子性的，实际上，inc++ 其实是一个复合操作，包括三步：
 * 1、读取 inc 的值。
 * 2、对 inc 加 1。
 * 3、将 inc 的值写回内存。
 * <p>
 * volatile 是无法保证这三个操作是具有原子性的，有可能导致下面这种情况出现：
 * 线程 1 对 inc 进行读取操作之后，还未对其进行修改。线程 2 又读取了 inc的值并对其进行修改（+1），再将inc 的值写回内存。
 * 线程 2 操作完毕后，线程 1 对 inc的值进行修改（+1），再将inc 的值写回内存。
 * 这也就导致两个线程分别对 inc 进行了一次自增操作后，inc 实际上只增加了 1。
 * <p>
 * 其实，如果想要保证上面的代码运行正确也非常简单，利用 synchronized、Lock或者AtomicInteger都可以。
 *
 * @author weixuhui Date: 2023/10/16 Time: 20:04
 */
public class VolatileAtomicityDemo {

    public volatile static int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待，保证上面程序执行完成
        Thread.sleep(3000);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
