/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.gc;

import java.io.IOException;
import java.io.InputStream;
import java.util.ServiceLoader;

/**
 * @author weixuhui Date: 2021/4/16 Time: 3:35 下午
 */
public class ClassLoaderTest {


    public static void main(String[] args) throws Exception {


        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };

        ClassLoader myLoader_1 = ClassLoader.getSystemClassLoader();

        ClassLoader myLoader_2 = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);

                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);

                    return defineClass(name, b, 0, b.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };


        ServiceLoader<Object> serviceLoader = ServiceLoader.load(Object.class);

        Object obj = myLoader_1.loadClass("com.wxh.note.java.gc.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof ClassLoaderTest);
        System.out.println(new ClassLoaderTest() instanceof ClassLoaderTest);
    }
}
