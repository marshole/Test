/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.current.jmm.volatilejmm;

import lombok.Data;

/**
 * @author weixuhui Date: 2021/3/4 Time: 3:01 下午
 */
@Data
public class VolatileTestModel {


    long value = 0L;

    public void getAndIncrement() {
        value++;
    }
}
