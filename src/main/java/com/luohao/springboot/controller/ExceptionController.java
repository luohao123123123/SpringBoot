package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.utils.RUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常处理
 * @ExceptionHandler:当出现指定的异常时进行操作
 * 进行统一处理
 */
@Controller
public class ExceptionController {
    @ResponseBody
    @GetMapping("/testExceptionHandle/{i}")
    public R<Object> testExceptionHandle(@PathVariable("i") int i) {
        int data = 10 / i;
        return RUtils.success(data);
    }

    @ExceptionHandler({ Exception.class })
    public String testArithmeticException(Exception e, Model model) {
      model.addAttribute("msg",e);
        return "error"; //指定error页面
    }
}
