/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.structure.consistenthash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 模拟机器节点
 *
 * @author weixuhui Date: 2021/5/1 Time: 5:56 下午
 */
@Getter
@Setter
@AllArgsConstructor
public class Node<T> {

    private String ip;
    private String name;

    /**
     * 使用IP当做hash的Key
     *
     * @return String
     */
    @Override
    public String toString() {
        return ip;
    }
}
