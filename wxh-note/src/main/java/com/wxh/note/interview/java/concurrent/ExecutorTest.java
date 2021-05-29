/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.interview.java.concurrent;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author weixuhui Date: 2021/4/21 Time: 7:45 下午
 */
public class ExecutorTest {


    public static void main(String[] args) {


        String str = new String("");


        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
    }
}
