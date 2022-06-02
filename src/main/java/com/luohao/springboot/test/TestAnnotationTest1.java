package com.luohao.springboot.test;

import com.luohao.springboot.annotation.TestAnnotation;
import com.luohao.springboot.bean.Student;

/**
 * 通过反射操作类上的注解
 * 把注解的属性value，插入到实体类中
 */
public class TestAnnotationTest1 {
    public static void main(String[] args) {
        Student student=new Student();
        try {
            Class<?> class1 = Class.forName("com.luohao.springboot.bean.Student");
            if(class1.isAnnotationPresent(TestAnnotation.class)) {
                TestAnnotation annotation = class1.getAnnotation(TestAnnotation.class);
                student.setId(annotation.id());
                student.setName(annotation.name());
                student.setAddr(annotation.addr());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(student);
    }
}
