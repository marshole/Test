/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:32
 */
public class TestTimeZone {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Dublin"));
		System.out.println(ldt);
		LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Dublin"));
		ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Dublin"));
		System.out.println(zdt);
	}
}
