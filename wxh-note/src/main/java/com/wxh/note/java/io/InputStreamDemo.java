/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author weixuhui Date: 2023/10/18 Time: 20:11
 */
public class InputStreamDemo {

    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("/Users/weixuhui/git/Test/wxh-note/src/main/java/com/wxh/note/java/io/test.txt")) {
            System.out.println("Number of remaining bytes:"
                    + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
