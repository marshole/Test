/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

/**
 * @author weixuhui Date: 19/8/28 Time: 下午4:25
 */
public class TestDuration {
	public static void main(String[] args) {
		Instant ins1 = Instant.now();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant ins2 = Instant.now();
		Duration dura = Duration.between(ins1, ins2);
		System.out.println(dura.toMillis());
		System.out.println("----------------------");
		LocalTime lt1 = LocalTime.now();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalTime lt2 = LocalTime.now();
		Duration dura2 = Duration.between(lt1, lt2);
		System.out.println(dura2.toMillis());
	}
}
