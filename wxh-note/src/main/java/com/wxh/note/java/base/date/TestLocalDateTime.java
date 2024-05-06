/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.base.date;

import java.time.LocalDateTime;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:21
 */
public class TestLocalDateTime {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		// 获取系统当前时间
		System.out.println(ldt);
		LocalDateTime ldt2 = LocalDateTime.of(2019, 01, 01, 12, 12, 12, 888000000);
		// 构建LocalDateTime对象ldt
		System.out.println(ldt2);
		// 获取明年此时的时间
		LocalDateTime ldt3 = ldt.plusYears(1);
		System.out.println(ldt3);
		// 获取去年此刻时间
		LocalDateTime ldt4 = ldt.minusYears(1);
		System.out.println(ldt4);
		// 获取年
		System.out.println(ldt.getYear());
		// 获取月份
		System.out.println(ldt.getMonthValue());
		// 获取本月第某天
		System.out.println(ldt.getDayOfMonth());
		// 获取时
		System.out.println(ldt.getHour());
		// 获取分
		System.out.println(ldt.getMinute());
		// 获取秒
		System.out.println(ldt.getSecond());
		// 获取纳秒
		System.out.println(ldt.getNano());
	}
}
