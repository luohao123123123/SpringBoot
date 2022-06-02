package com.luohao.springboot.annotation;

import java.lang.annotation.*;

@Documented()
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdFormatter {
    /**
     * id格式化，有些id中包括一些杂质，需要格式化后为int类型
     */
}
