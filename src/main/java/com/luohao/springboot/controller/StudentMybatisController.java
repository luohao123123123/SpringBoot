package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.bean.Student;

import com.luohao.springboot.service.StudentService;
import com.luohao.springboot.utils.RUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentMybatisController {
    @Autowired
    StudentService studentService;

    @ResponseBody
        @GetMapping(value = "select")
    public R<Object> getStudentInfo(){
        return RUtils.success(studentService.getStudent());
    }

    @ResponseBody
        @DeleteMapping(value = "delete")
    public R<Object> deleteStudentWtihId(){
        studentService.deleteStudentWtihId(65);
        return RUtils.success("delete 完成");
    }

    @ResponseBody
    @PostMapping(value = "insert")
    public R<Object> insertStudent(){
        Student student=new Student(67,"小军","湖南");
        studentService.insertStudent(student);
        return RUtils.success("insert 完成");
    }

    @ResponseBody
    @PutMapping(value = "update")
    public R<Object> updataById(){
        studentService.updataById(65,"小红","长沙");
        return RUtils.success("update 完成");
    }



}

