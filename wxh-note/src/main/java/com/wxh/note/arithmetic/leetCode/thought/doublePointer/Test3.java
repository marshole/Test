/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 反转字符串中的元音字符
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author weixuhui Date: 19/8/23 Time: 下午5:46
 */
public class Test3 {

	private static final List<Character> vowelArray = Lists.newArrayList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

	private static boolean isVowel(char c) {
		return vowelArray.contains(c);
	}

	private static String invertVowel(String str) {

		int i = 0, j = str.length() - 1;

		char[] result = new char[str.length()];

		while (i <= j) {
			char ci = str.charAt(i);
			char cj = str.charAt(j);
			if (!isVowel(ci)) {
				result[i++] = ci;
			} else if (!isVowel(cj)) {
				result[j--] = cj;
			} else {
				result[i++] = cj;
				result[j--] = ci;
			}
		}

		return new String(result);
	}

	public static void main(String[] args) {
		System.out.println("start ...");
		String str = invertVowel("helol");
		System.out.println(str);

	}

}
