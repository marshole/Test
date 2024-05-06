/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.future;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

/**
 * Future 来异步获取线程执行的结果
 *
 * @author weixuhui Date: 2023/10/17 Time: 16:24
 */
public class FutureDemo01 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        LocalDateTime startTime = LocalDateTime.now();

        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> results = Lists.newArrayList();

        // 批量任务
        for (int i = 0; i < 3; i++) {
            ServerTask task = new ServerTask(String.valueOf(i));
            Future<String> future = executor.submit(task);
            results.add(future);
        }

        System.out.println("timer...interval = " + Duration.between(startTime, LocalDateTime.now()).getSeconds());

        results.forEach(p -> {
            try {
                System.out.println(p.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }
}


class ServerTask implements Callable<String> {

    private String input;

    public ServerTask(String input) {
        this.input = input;
    }

    @Override
    public String call() throws Exception {
        System.out.println("execute : " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return input + "-executed";
    }
}
