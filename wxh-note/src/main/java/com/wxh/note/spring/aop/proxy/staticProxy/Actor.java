/*
 * Copyright (c) 2019  All Rights Reserved.
 */
package com.wxh.note.spring.aop.proxy.staticProxy;

/**
 * @author weixuhui Date: 19/4/28 Time: 下午3:18
 */
public class Actor implements Person {

	private String name;

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void speak() {
		System.out.println("I am an actor, my name is ".concat(name));
	}
}
