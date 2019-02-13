package com.wxh.note.structure.sort;

/**
 * @author weixuhui
 * @Description 希尔排序
 * @Date 18/11/9 下午2:46
 **/
public class ShellSort {

    public static int[] sort(int[] nums){
        int temp, length = nums.length;
        for (int gap = length/2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap ; i++) {
                for (int j = i + gap; j < length; j += gap) {
                    temp = nums[j];
                    int k = j;
                    for (; k >= gap&&temp < nums[k - gap]; k -= gap) {
                        nums[k] = nums[k - gap];
                    }
                    nums[k] = temp;
                }
            }
        }
        return nums;
    }

}
