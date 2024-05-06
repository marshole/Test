/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.test;

/**
 * @author weixuhui Date: 2023/11/5 Time: 21:28
 */
public class ArrayTest {

    public static void main(String[] args) {

        int[][] data;


        int[] nums = new int[]{3,1,1,3};
        System.out.println(massage(nums));
    }

    public static int massage(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            System.out.println(dp[i]);
        }

        return dp[length - 1];
    }
}
