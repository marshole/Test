/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:23
 */
public class TestInstant {
	public static void main(String[] args) {
		// 时间戳 Instant
		Instant ins1 = Instant.now();
		// 默认获取UTC时间，协调世界时
		System.out.println(ins1);
		OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		System.out.println(ins1.toEpochMilli());
		Instant ins2 = Instant.ofEpochSecond(60);
		System.out.println(ins2);
	}
}
