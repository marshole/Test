/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.base.clonetest;

import org.springframework.beans.BeanUtils;

import java.io.*;

/**
 * @author weixuhui Date: 2021/4/20 Time: 3:53 下午
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        CloneTestObj obj1 = new CloneTestObj("a", "b", new CloneObj());

        CloneTestObj obj2 = CloneTestObj.class.newInstance();
        BeanUtils.copyProperties(obj1, obj2);

        CloneTestObj obj3 = deepColon(obj1);

        System.out.println(11);

    }


    public static CloneTestObj deepColon(CloneTestObj obj) {
        CloneTestObj copy = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            //将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            copy = (CloneTestObj) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return copy;
    }
}
