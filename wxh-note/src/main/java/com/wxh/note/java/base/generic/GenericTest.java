package com.wxh.note.java.base.generic;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型测试
 *
 * @author weixuhui
 *
 */
public class GenericTest {
	
	public static void main(String[] args) {
		
	}
	
	
	static class Reader<T>{
		T readExact(List<T> list) {
			return list.get(0);
		}
	}
	
	static void f1() {
		List<Apple> apples = Arrays.asList(new Apple());
	    List<Fruit> fruits = Arrays.asList(new Fruit());
		Reader fruitReader = new Reader<Fruit>();
		
	}

}
