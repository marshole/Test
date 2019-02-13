package com.wxh.note.structure.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author weixuhui
 * @Description 选择排序
 * @Date 18/11/8 下午5:15
 **/
public class SelectSort {


    public static void main(String[] args) {

        int[] nums = {0, 3, 4, 1, 9, 8, 6, 2, 5, 7};

        int[] result = sort(nums);

        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));
    }

    public static int[] sort(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            int select = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[select] > nums[j]) {
                    select = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[select];
            nums[select] = temp;
        }
        return nums;
    }

}
