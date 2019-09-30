/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode.thought.doublePointer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * <p>
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * 输出:
 * "apple"
 * 示例 2:
 * <p>
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * 输出:
 * "a"
 * 说明:
 * <p>
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author weixuhui Date: 19/9/3 Time: 下午4:18
 */
public class Test7 {

	private static String match(String str, List<String> matchArray) {

		int i = 0;

		String longest = "";

		for (String matchStr : matchArray) {
			if(matchStr.length() > longest.length() && matchStr.compareTo(longest) > 0){
				continue;
			}

			if (match(str, matchStr)) {
				longest = matchStr;
			}
		}

		return longest;
	}

	private static boolean match(String strA, String strB) {

		int i = 0, j = 0;

		while (i < strA.length()) {

			if (j >= strB.length()) {
				return true;
			}

			char charI = strA.charAt(i);
			char charJ = strB.charAt(j);

			if (charJ == charI) {
				j++;
			}

			i++;
		}

		return false;
	}

	public static void main(String[] args) {
		String str = "abpcplea";
		List<String> matchArray = Lists.newArrayList("ale", "apple", "monkey", "plea");
		System.out.println(match(str, matchArray));
	}
}
