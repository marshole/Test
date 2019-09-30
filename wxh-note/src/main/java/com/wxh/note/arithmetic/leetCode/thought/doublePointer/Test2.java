/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

import java.util.Arrays;

/**
 * 平方数之和
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author weixuhui Date: 19/8/23 Time: 下午5:19
 */
public class Test2 {

	public static int[] getSolution(int c) {

		int i = 0;
		int j = (int) Math.sqrt(c);
		while (i < j) {
			int v = i * i + j * j;

			if (v == c) {
				return new int[]{i, j};
			} else if (v < c) {
				i++;
			} else {
				j--;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		int[] solution = getSolution(10);
		if (solution == null) {
			System.out.println("no solution");
		} else {
			Arrays.stream(solution).forEach(System.out::println);
		}
	}
}
