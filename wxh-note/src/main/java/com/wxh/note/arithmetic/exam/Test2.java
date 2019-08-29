/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.exam;

/**
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p/>
 *
 * @author weixuhui Date: 19/6/14 Time: 下午5:31
 */
public class Test2 {

	private String execute(StringBuilder str) {

		StringBuilder newStr = new StringBuilder();

		for (int i = 0; i <str.length() ; i++) {
			char s = str.charAt(i);
			if(s == ' '){
				newStr.append("%20");
			}else{
				newStr.append(s);
			}
		}

		return newStr.toString();
	}
}
