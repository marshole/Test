/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author weixuhui Date: 19/9/2 Time: 下午8:55
 */
public class Test5 {

	private static void merge(int[] arrayA, int m, int[] arrayB, int n) {

		int i = m - 1, j = n - 1;
		int offerSet = m + n - 1;

		while (i >= 0 || j >= 0) {
			if (i < 0) {
				arrayA[offerSet--] = arrayB[j--];
			} else if (j < 0) {
				arrayA[offerSet--] = arrayA[i--];
			} else if (arrayA[i] > arrayB[j]) {
				arrayA[offerSet--] = arrayA[i--];
			} else {
				arrayA[offerSet--] = arrayB[j--];
			}
		}
		System.out.println(Arrays.stream(arrayA).mapToObj(String::valueOf).collect(Collectors.joining(",")));
	}

	public static void main(String[] args) {
		int[] arrayA = new int[]{1, 2, 3, 0, 0, 0};
		int[] arrayB = new int[]{2, 5, 6};
		merge(arrayA, 3, arrayB, 3);
	}

}
