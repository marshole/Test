/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author weixuhui Date: 2023/10/17 Time: 17:53
 */
public class FutureDemo02 {
    public static void main(String[] args) throws Exception {

        // 线程池执行任务
        ExecutorService executor = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "task...OK";
            }
        });
        executor.execute(futureTask);
        // 任务信息获取
        System.out.println("是否完成：" + futureTask.isDone());
        System.out.println("是否取消：" + futureTask.isCancelled());
        System.out.println("获取结果：" + futureTask.get());
        System.out.println("尝试取消：" + futureTask.cancel(Boolean.TRUE));
    }
}
