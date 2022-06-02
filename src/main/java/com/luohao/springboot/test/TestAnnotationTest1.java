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
        Class<Student> studentClass = Student.class;
        if(studentClass.isAnnotationPresent(TestAnnotation.class)) {
            TestAnnotation annotation = studentClass.getAnnotation(TestAnnotation.class);
            student.setId(annotation.id());
            student.setName(annotation.name());
            student.setAddr(annotation.addr());
        }

        System.out.println(student);
    }
}
