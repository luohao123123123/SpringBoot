package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.annotation.LogAnnotation;
import com.luohao.springboot.bean.Mybatis_Student;
import com.luohao.springboot.service.Mybatis_Student_TeacherService;
import com.luohao.springboot.utils.RUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 自定义注解的使用
 */
@Controller
public class LogAnnotationController {
    @Autowired
    Mybatis_Student_TeacherService mybatis_student_teacher_service;

    @ResponseBody
    @LogAnnotation("这是日志")
    @RequestMapping(value = "/LogAnnoAspect/{tid}",method = RequestMethod.GET)
    public R<Object> getStudentsByTid(@PathVariable(value = "tid",required = false) int tid) {
        List<Mybatis_Student> studentsByTid = mybatis_student_teacher_service.getStudentsByTid(tid);
        if(studentsByTid.size()>0){
            return RUtils.success(studentsByTid);
        }
        else {
            return RUtils.error(Renum.UnKnow_Error.getCode(), Renum.UnKnow_Error.getMsg());
        }
    }
}
