/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.structure;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weixuhui Date: 2021/5/19 Time: 2:39 下午
 */
public class Test {


    public static void main(String[] args) {
    }

    public static boolean canRemove(String a,String top){

        if(")".equals(a) && "(".equals(top)){
            return true;
        }

        if("}".equals(a) && "{".equals(top)){
            return true;
        }

        if("]".equals(a) && "[".equals(top)){
            return true;
        }

        return false;
    }


    public static int romanToInt(String s) {

        int length = s.length();

        int sum = 0;

        for (int i = 0; i < length; i++) {

            int value = convert(String.valueOf(s.charAt(i)));

            if (i < length - 1) {
                int nextValue = convert(String.valueOf(s.charAt(i + 1)));

                if (value < nextValue) {
                    value = -value;
                }
            }

            sum = sum + value;
        }

        return sum;
    }

    public static int convert(String roman) {

        switch (roman) {
            case "M":
                return 1000;
            case "D":
                return 500;
            case "C":
                return 100;
            case "L":
                return 50;
            case "X":
                return 10;
            case "V":
                return 5;
            case "I":
                return 1;
            default:
                return 0;
        }
    }


    public static boolean execute(int x) {

        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int i = 1;
        int temp = x;
        while (temp / 10 >= 1) {
            temp = temp / 10;
            i = i * 10;
        }
        ;

        int k = i;


        int value = 0;
        temp = x;

        do {
            int z = temp % 10;
            value = value + z * i;
            temp = temp / 10;
            i = i / 10;
        }
        while (temp >= 1);

        return value == x;

    }

}
