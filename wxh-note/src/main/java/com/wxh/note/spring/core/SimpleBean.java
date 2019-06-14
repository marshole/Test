/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author weixuhui Date: 19/4/29 Time: 下午3:53
 */
public class SimpleBean {
	public void send() {
		System.out.println("I am SimpleBean, I am work !");
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf/config.xml");
		SimpleBean bean = context.getBean(SimpleBean.class);
		bean.send();
		context.close();
	}
}
