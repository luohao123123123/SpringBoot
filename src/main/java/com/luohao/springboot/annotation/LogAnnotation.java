package com.luohao.springboot.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解打印日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String value() default "";
}
