package com.wxh.note.structure.sort;

import java.util.Stack;

/**
 * @author weixuhui
 * @Description 快排
 * @Date 18/11/19 下午4:41
 **/
@SuppressWarnings("all")
public class QuickSort {

    public static void recursiveQuickSort(int[] nums, int head, int tail) {
        int i = head, j = tail;
        int pivot = nums[head];
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
        if (i - 1 - head > 0) {
            recursiveQuickSort(nums, head, i - 1);
        }
        if (tail - i - 1 > 0) {
            recursiveQuickSort(nums, i + 1, tail);
        }
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
        int[] a = {49,38,65,97,76,13,27,49};
        new QuickSort().nonRecursiveQuickSort(a);
        for (int i:a) System.out.println(i);
    }
}
