/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

import java.util.Arrays;

/**
 * 两数平方和
 *
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 示例：
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p/>
 *
 * @author weixuhui Date: 19/8/23 Time: 下午5:19
 */
public class Test2 {

	public static int[] getSolution(int c) {

		int i = 1;
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
		}else{
			Arrays.stream(solution).forEach(System.out::println);
		}
	}
}
