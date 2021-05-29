package com.wxh.note.structure.sort;

/**
 * @author weixuhui
 * @Description 插入排序
 * @Date 18/11/8 下午5:45
 **/
public class InsertSort {

    public static int[] sort(int[] nums) {
        int temp, length = nums.length;
        for (int i = 1; i < length; i++) {
            temp = nums[i];
            int j = i;
            for (; j >= 1 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
        return nums;
    }


    /**
     * 易于理解的代码
     *
     * @param nums
     * @return
     */
    public static int[] sortM(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int lastLocal = i;
            for (int j = i - 1; j >= 0; j--) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    lastLocal = j;
                } else {
                    break;
                }
            }
            nums[lastLocal] = temp;
        }
        return nums;
    }

    public static int[] test(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }


        for (int i = 1; i < nums.length; i++) {

            int insertKey = i;
            int insertValue = nums[insertKey];

            for (int j = i - 1; j >= 0; j--) {

                int compareKey = j;
                int compareValue = nums[compareKey];

                if(insertValue >= compareValue){
                    break;
                }

                // 插到前面
                nums[insertKey] = compareValue;
                nums[compareKey] = insertValue;
                insertKey = compareKey;
            }

        }
        return nums;
    }
}
