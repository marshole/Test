package com.wxh.note.structure.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author weixuhui
 * @Description
 * @Date 18/11/8 下午5:45
 **/
public class Test {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};

        int[] result = BubbleSort.sortOptimize(nums);

        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));
    }
}
