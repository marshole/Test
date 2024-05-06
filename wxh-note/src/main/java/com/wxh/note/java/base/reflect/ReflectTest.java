package com.wxh.note.java.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public static Car initByDefaultConst() throws Throwable{
		
		// 通过类加载器获取Car对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = loader.loadClass("com.wxh.note.java.base.reflect.Car");

		// 获取类的默认构造器对象并通过它实例化Car
		Constructor<?> cons = clazz.getDeclaredConstructor((Class[]) null);
		Car car = (Car) cons.newInstance();
		
		// 通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "奥迪A8");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 360);
		return car;
		
	}
	
	public static void main(String[] args) throws Throwable {
		Car car = initByDefaultConst();
		System.out.println(car.toString());
	}

}
