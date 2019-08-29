/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.date;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:26
 */
public class TestPeriod {
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2015, 2, 2);
		LocalDate ld2 = LocalDate.now();
		Period period = Period.between(ld1, ld2);
		System.out.println(period);
		System.out.println("相差" + period.getYears() + "年"
				+ period.getMonths() + "月"
				+ period.getDays() + "天");
	}
}
