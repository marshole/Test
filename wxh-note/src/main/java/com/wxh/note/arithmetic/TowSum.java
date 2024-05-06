package com.wxh.note.arithmetic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 求两数之和
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author weixuhui
 * @Description
 * @Date 18/7/11 下午4:43
 **/
public class TowSum {




    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = violence(nums, target);
        printResult(result);

    }

    /**
     * @return void
     * @Description 打印结果
     * @Author xuhui.wei
     * @Date 18/7/11 下午6:22
     * @Param [result]
     **/
    private static void printResult(int[] result) {
        System.out.println("解：");
        for (int i : result) {
            System.out.println(i);
        }

    }

    /**
     * @return int[]
     * @Description 暴力遍历发（冒泡法）
     *
     * <p>遍历每个元素 x 并查找是否存在一个值与 target−x 相等的目标元素。</p>
     * @Author xuhui.wei
     * @Date 18/7/11 下午6:02
     * @Param [nums, target]
     **/
    private static int[] violence(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * @return int[]
     * @Description 两遍哈希表
     * @Author xuhui.wei
     * @Date 18/7/11 下午6:34
     * @Param [nums, target]
     **/
    private static int[] twiceHash(int[] nums, int target) {

        Map<Integer, Integer> map = Maps.newHashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * @return int[]
     * @Description 一遍哈希表
     * @Author xuhui.wei
     * @Date 18/7/11 下午8:12
     * @Param [nums, target]
     **/
    private static int[] onceHash(int[] nums, int target) {

        Map<Integer, Integer> map = Maps.newHashMap();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
