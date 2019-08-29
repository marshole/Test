/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:27
 */
public class TestTemporalAdjuster {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println(ldt3);
	}
}
