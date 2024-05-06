/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.n1;

import java.util.*;

/**
 * @author weixuhui Date: 2023/10/31 Time: 20:31
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = violence(nums, target);
        System.out.println("解：");
        for (int i : result) {
            System.out.println(i);
        }

        Stack st = new Stack();

    }


    /**
     * 暴力循环
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] violence(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i];
                int b = nums[j];
                if (a + b == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] hash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }


    /**
     * 双指针
     * 前提nums是有序数组！！
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] doublePointer(int[] nums, int target) {

        int i = 0, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }
}
