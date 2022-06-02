package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.bean.Student;
import com.luohao.springboot.utils.RUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * Converter和Formatter两种数据类型转换器的测试，以及自定义注解格式化属性字段
 */
@Controller
public class MyFormatterController {

    /**
     *测试mvc内置转换器
     * 请求url：http://localhost:8081/luohao/MyConverterAddStudent?student=1,zhangsan,china
     */
    @ResponseBody
    @GetMapping( value = "/MyConverterAddStudent")
    public R<Object> addStudent(@RequestParam(value = "student") Student student){

        return RUtils.success(student);
    }

    /**
     * 测试自定义数据格式转换器
     * 请求url：http://localhost:8081/luohao/MyFormatter?date=20220530
     */
    @ResponseBody
    @GetMapping("/MyFormatter")
    public R<Object> MyFormatter(@RequestParam(value = "date") Date date){
        System.out.println(date);
        return RUtils.success(date.toString());
    }

    /**
     * 测试自定义注解格式化属性字段，id必须为int
     * 请求url：http://localhost:8081/luohao/MyIdFormatter?id=815s&name=zhangsan&addr=hunan
     * @param student
     * @return
     */
    @ResponseBody
    @GetMapping("/MyIdFormatter")
    public R<Object> MyIdFormatter(@Validated Student student){
        if (student.getId()==-1){
            return RUtils.error(Renum.UnKnow_Error.getCode(),"id字段错误");
        }
        return RUtils.success(student);
    }
}
