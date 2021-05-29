package com.wxh.note.structure.sort;

import java.util.Stack;

/**
 * @author weixuhui
 * @Description 快排
 * @Date 18/11/19 下午4:41
 **/
@SuppressWarnings("all")
public class QuickSort {


    /**
     * https://www.bilibili.com/video/av39519566/
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] arr, int left, int right) {

        // 进行判断，如果左边索引比右边索引大，不合法，直接return
        if (left > right) {
            return;
        }

        // 定义变量基准数
        int base = arr[left];

        // 初始化左边的游标
        int leftOffset = left;
        // 初始化右边的游标
        int rightOffset = right;

        // 当左右游标不相遇的时候，在循环中进行检索
        while (leftOffset != rightOffset) {

            // 从右往左检索比基准数小的数据，如果检索到就行停下，否则继续检索
            while (arr[rightOffset] >= base && leftOffset < rightOffset) {
                rightOffset--;
            }

            // 从左往右检索比基准数大的数据，如果检索到就行停下，否则继续检索
            while (arr[leftOffset] <= base && leftOffset < rightOffset) {
                leftOffset++;
            }

            //交换
            int temp = arr[rightOffset];
            arr[rightOffset] = arr[leftOffset];
            arr[leftOffset] = temp;
        }

        arr[left] = arr[leftOffset];
        arr[leftOffset] = base;

        quickSort(arr, left, leftOffset - 1);
        quickSort(arr, leftOffset + 1, right);
    }


    private class Region {
        int low;
        int high;

        Region(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    public void nonRecursiveQuickSort(int[] nums) {
        int i, j, pivot;
        Region region;
        Stack<Region> regions = new Stack<>();
        regions.add(new Region(0, nums.length - 1));
        while (!regions.empty()) {
            region = regions.pop();
            i = region.low;
            j = region.high;
            pivot = nums[i];
            while (i < j) {
                while (i < j) {
                    if (pivot >= nums[j]) {
                        nums[i++] = nums[j];
                        break;
                    }
                    j--;
                }
                while (i < j) {
                    if (pivot <= nums[i]) {
                        nums[j--] = nums[i];
                        break;
                    }
                    i++;
                }
            }
            nums[i] = pivot;
            if (i > region.low + 1) regions.add(new Region(region.low, i - 1));
            if (i < region.high - 1) regions.add(new Region(i + 1, region.high));
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
        new QuickSort().nonRecursiveQuickSort(a);
        for (int i : a) System.out.println(i);
    }
}
