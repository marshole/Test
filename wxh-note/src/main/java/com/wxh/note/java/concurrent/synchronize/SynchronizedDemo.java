/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.concurrent.synchronize;

/**
 * @author weixuhui Date: 2023/10/16 Time: 20:51
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
