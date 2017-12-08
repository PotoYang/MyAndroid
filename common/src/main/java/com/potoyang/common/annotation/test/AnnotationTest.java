package com.potoyang.common.annotation.test;

import java.lang.reflect.Field;

/**
 * Created by potoyang on 2017/11/24.
 */

public class AnnotationTest {

    @TestAnnotation("Hello  Annotation")
    private String helloAnnotation;

    public static void main(String[] args) {
        try {
            //获取要解析的类
            Class clazz = Class.forName("com.potoyang.common.annotation.test.AnnotationTest");
            //拿到所有Field
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                TestAnnotation annotation = field.getAnnotation(TestAnnotation.class);
                if (annotation != null) {
                    String value = annotation.value();
                    System.out.println(value);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
