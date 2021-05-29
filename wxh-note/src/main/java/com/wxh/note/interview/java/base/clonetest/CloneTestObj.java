/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.interview.java.base.clonetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author weixuhui Date: 2021/4/20 Time: 3:51 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloneTestObj implements Serializable {
    private String a;
    private String b;
    private CloneObj obj;
}
