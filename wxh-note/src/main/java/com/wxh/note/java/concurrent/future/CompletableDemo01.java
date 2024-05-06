/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weixuhui Date: 2023/10/17 Time: 18:12
 */
public class CompletableDemo01 {
    public static void main(String[] args) throws Exception {
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 任务执行
        CompletableFuture<String> cft = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Res...OK";
        }, executor);
        // 结果输出
        System.out.println(cft.get());
    }
}
