package com.wxh.note.structure.sort;

/**
 * @author weixuhui
 * @Description 冒泡排序
 * @Date 18/11/9 下午4:58
 **/
public class BubbleSort {

    /**
     * 最好 O(n^2)
     * 最差 O(n^2)
     * 平均 O(n^2)
     *
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 最好 O(n)
     * 最差 O(n^2)
     * 平均 O(n^2)
     *
     * @param nums
     * @return
     */
    public static int[] sortOptimize(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            Boolean flag = false;
            for (int j = length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }

    public static int[] test(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {


            for (int j = 0; j < length - 1; j++) {

                int bubbleValue = nums[j];

                int compareValue = nums[j + 1];

                if (bubbleValue > compareValue) {

                    // 交换
                    nums[j + 1] = bubbleValue;
                    nums[j] = compareValue;
                }

            }

        }


        return nums;


    }


}
