package com.wxh.note.java.gc;

import org.apache.commons.lang3.text.StrBuilder;

public class Test {
	
	public static void main(String[] args) {


		String str1 = new StrBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str3 = new StrBuilder("计算机").append("软件").toString();
		System.out.println(str3.intern() == str3);

		String str2 = new StrBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}
