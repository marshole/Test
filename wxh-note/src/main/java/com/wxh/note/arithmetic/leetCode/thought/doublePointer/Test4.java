/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

/**
 * 回文字符串
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author weixuhui Date: 19/9/2 Time: 下午8:34
 */
public class Test4 {

	private static boolean validatePalindromic(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return isPalindromic(str, i, j - 1) || isPalindromic(str, i + 1, j);
			}
		}

		return true;
	}

	private static boolean isPalindromic(String str, int i, int j) {

		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(validatePalindromic("abbcda"));
	}
}
