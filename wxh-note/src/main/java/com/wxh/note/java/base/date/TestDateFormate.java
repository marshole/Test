/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.base.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:29
 */
public class TestDateFormate {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now();
		String strDate = ldt.format(dtf);
		System.out.println(strDate);
		System.out.println("----------------------------");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2 = dtf2.format(ldt);
		System.out.println(strDate2);
		System.out.println("-----------------------------");
		LocalDateTime newDate = LocalDateTime.parse(strDate2, dtf2);
		System.out.println(newDate);
	}
}
