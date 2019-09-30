/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.leetCode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author weixuhui Date: 19/8/30 Time: 下午5:31
 */
public class Test4 {

	public static void main(String[] args) {

		List<String> list = Lists.newArrayList("1","2","3","4");

		System.out.println(list.indexOf("1"));
		System.out.println(list.indexOf(1));

		//getSolution("abcdba");
	}

	private static String getSolution(String str) {

		int length = str.length();

		boolean match = false;

		for (int i = length; i > 1; i--) {

			if(match){
				break;
			}

			for (int j = 0; j < length - 1; j++) {
				if (i + j > length) {
					break;
				}

				String newStr = str.substring(j, i+j);

				if (!isRepeat(newStr)) {
					System.out.println(newStr);
					match = true;
				}

			}
		}

		return null;
	}

	private static boolean isRepeat(String newStr) {
		char[] array = newStr.toCharArray();
		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				char iStr = array[i];
				char jStr = array[j];
				if (iStr == jStr) {
					return true;
				}
			}
		}
		return false;
	}
}
