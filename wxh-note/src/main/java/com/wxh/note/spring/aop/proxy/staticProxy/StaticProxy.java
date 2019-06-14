/*
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.wxh.note.spring.aop.proxy.staticProxy;

/**
 * 静态代理
 *
 * @author weixuhui Date: 19/4/28 Time: 下午3:13
 */
public class StaticProxy {
	public static void main(String[] args) {

		Actor actor = new Actor("peter");

		Agent agent = new Agent(actor);

		agent.speak();

	}
}
