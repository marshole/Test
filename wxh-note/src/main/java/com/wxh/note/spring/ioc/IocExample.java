package com.wxh.note.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class IocExample {
	
	public static void main(String[] args) {
		
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(null);
		
	}

}
