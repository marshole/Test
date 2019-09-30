/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author weixuhui Date: 19/9/12 Time: 下午5:14
 */
public class Test1 {

	/**
	 * 找到第k个最大的元素
	 *
	 * @param array
	 * @return
	 */
	private static int findKthLargest(int[] array, int k) {
		return sort(array, k);
	}


	/**
	 * 直接排序
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	private static int sort(int[] array, int k) {
		Arrays.sort(array);
		return array[array.length - k];
	}

	/**
	 * 使用堆
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	private static int heap(int[] array, int k) {
		// 小顶堆
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int val : array) {

			pq.add(val);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	/**
	 * 快排
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	private static int fastSort(int[] array, int k) {
		k = array.length - k;
		int l = 0, h = array.length - 1;
		while (l < h) {
			int j = partition(array, l, h);
			if (j == k) {
				break;
			} else if (j < k) {
				l = j + 1;
			} else {
				h = j - 1;
			}
		}
		return array[k];
	}

	private static int partition(int[] a, int l, int h) {
		int i = l, j = h + 1;
		while (true) {
			while (a[++i] < a[l] && i < h) ;
			while (a[--j] > a[l] && j > l) ;
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, l, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {

		int[] array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7};

		int solution = findKthLargest(array, 4);

		System.out.println(solution);
	}


}
