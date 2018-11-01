package com.wxh.note.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author weixuhui
 * @Description
 * @Date 18/8/9 下午5:11
 **/
public class AnnotationTest {
    public static void main(String[] args) throws Exception {

        // 新建Person
        Person person = new Person();

        Class<Person> c = Person.class;

        Method mSomebody = c.getMethod("somebody", String.class, int.class);

        mSomebody.invoke(person, "lily", 18);

        iteratorAnnotations(mSomebody);

        Method mEmpty = c.getMethod("empty");

        mEmpty.invoke(person);

        iteratorAnnotations(mEmpty);

    }

    public static void iteratorAnnotations(Method method) {

        // 判断  方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str : values){
                System.out.printf(str + ", ");
            }
            System.out.println();
        }

        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }
}
