package com.luohao.springboot.annotation;

import java.lang.annotation.*;

/**
 * ElementType.TYPE：表示这个注解可以标注在类，接口，枚举类上
 * ElementType.METHOD：表示这个注解可以标注在方法上
 * ElementType.FIELD：表示这个注解可以标注在字段属性（全局变量）上
 * RetentionPolicy.RUNTIME：表示当前注解能存在于源码、字节码文件以及运行时状态
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    int id();
    String name();
    String addr() default "中国 湖南";
}
