package com.luohao.springboot.test;

import com.luohao.springboot.R.R;
import com.luohao.springboot.annotation.TestAnnotation;
import com.luohao.springboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 操作注解
 */

@TestAnnotation(id=1,name="zhangsan")  //注解在类上
public class TestAnnotationTest {
    @TestAnnotation(id=3,name = "wangwu",addr = "中国 邵东")   //注解在字段属性上
    public int id;
    /**
     * 操作类上的注解
     */
    public void ClassAnnotation(Student student){
        try {
            Class<?> class1 = Class.forName("com.luohao.springboot.test.TestAnnotationTest");
            TestAnnotation annotation = class1.getAnnotation(TestAnnotation.class);
            if(annotation!=null){
                student.setId(annotation.id());
                student.setName(annotation.name());
                student.setAddr(annotation.addr());
            }
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作方法上的注解
     */
    @TestAnnotation(id=2,name = "lisi",addr = "中国 长沙")   //注解在方法上
    public void VoidAnnotation(Student student){
        try {
            Class<?> class2 = Class.forName("com.luohao.springboot.test.TestAnnotationTest");
            Method[] methods = class2.getMethods();
            for(Method method:methods){
                TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
                if(annotation!=null){
                    student.setId(annotation.id());
                    student.setName(annotation.name());
                    student.setAddr(annotation.addr());
                }
            }
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *操作字段属性上的注解
     */
    public void FieldAnnotation(){
        try {
            Class<?> class3 = Class.forName("com.luohao.springboot.test.TestAnnotationTest");
            Field[] fields = class3.getFields();
            for(Field field:fields){
                TestAnnotation annotation = field.getAnnotation(TestAnnotation.class);
                if(annotation!=null) {
                    id = annotation.id();  //给字段赋值
                }
            }
            System.out.println(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestAnnotationTest testAnnotationTest=new TestAnnotationTest();
        Student student1=new Student();
        Student student2=new Student();

        //类
        testAnnotationTest.ClassAnnotation(student1);
        //方法
        testAnnotationTest.VoidAnnotation(student2);
        //属性
        testAnnotationTest.FieldAnnotation();
    }
}
