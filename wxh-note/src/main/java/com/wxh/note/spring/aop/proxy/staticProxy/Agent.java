/*
 * Copyright (c) 2019  All Rights Reserved.
 */
package com.wxh.note.spring.aop.proxy.staticProxy;

/**
 * @author weixuhui Date: 19/4/28 Time: 下午3:21
 */
public class Agent implements Person {

	private Actor actor;

	public Agent(Actor actor) {
		this.actor = actor;
	}

	@Override
	public void speak() {

		System.out.println("Before actor speak, Agent say:  hello !");

		actor.speak();

		System.out.println("After actor speak, Agent say:  goodbye !");
	}
}
