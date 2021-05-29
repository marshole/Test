/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.jmm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weixuhui Date: 2021/3/6 Time: 3:00 下午
 */
public class ReentrantLockModel {

    int a = 0;

    ReentrantLock lock = new ReentrantLock();

    public void writer() {

        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }

    }


    public void reader() {

        lock.lock();

        try {
            int i = a;

            System.out.println(i);
        } finally {
            lock.unlock();
        }

    }
}
