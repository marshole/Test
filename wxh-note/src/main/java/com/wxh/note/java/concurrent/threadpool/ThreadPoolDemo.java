/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weixuhui Date: 2023/10/17 Time: 15:09
 */
public class ThreadPoolDemo {

    /**
     * 创建线程池，以及线程池的关键参数
     */

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(200));
}
