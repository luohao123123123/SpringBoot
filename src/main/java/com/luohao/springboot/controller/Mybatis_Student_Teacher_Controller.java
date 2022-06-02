package com.luohao.springboot.controller;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.bean.Mybatis_Student;
import com.luohao.springboot.service.Mybatis_Student_TeacherService;
import com.luohao.springboot.utils.RUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.Converter;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class Mybatis_Student_Teacher_Controller {
    @Autowired
    Mybatis_Student_TeacherService mybatis_student_teacher_service;


    @ResponseBody
    @RequestMapping(value = {"/getStudentsByTid/{tid}","/getStudentsByTid"},method = RequestMethod.GET)
    public R<Object> getStudentsByTid(@PathVariable(value = "tid",required = false) int tid) {
        List<Mybatis_Student> studentsByTid = mybatis_student_teacher_service.getStudentsByTid(tid);
        if(studentsByTid.size()>0){
            return RUtils.success(studentsByTid);
        }
        else {
            return RUtils.error(Renum.UnKnow_Error.getCode(), Renum.UnKnow_Error.getMsg());
        }

    }

    @ResponseBody
    @RequestMapping(value = {"/getStudentsByTids/{tid}","/getStudentsByTids"},method = RequestMethod.GET)
    public R<Object> getStudentsByTids(@PathVariable(value = "tid",required = false) List<Integer> tid) {
        tid= Arrays.asList(1,2);
        return RUtils.success(mybatis_student_teacher_service.getStudentsByTids(tid));
    }


    @ResponseBody
    @RequestMapping(value = {"/getStudentsByLikeTeacherName/{name}","/getStudentsByLikeTeacherName"},method = RequestMethod.GET)
    public R<Object> getStudentsByLikeTeacherName(@PathVariable(value = "name",required = false) String name) {
        List<Mybatis_Student> studentsByLikeTeacherName = mybatis_student_teacher_service.getStudentsByLikeTeacherName(name);
        if(studentsByLikeTeacherName.size()>0){
            return RUtils.success(studentsByLikeTeacherName);
        }else {
            return RUtils.error(Renum.UnKnow_Error.getCode(), Renum.UnKnow_Error.getMsg());
        }

    }

    /**
     * 使用Pagehelper分页插件
     * @param pageNum 第几页
     * @param pageSize 一页显示多少条数据
     * @return 返回查找到的数据
     */
    @ResponseBody
    @RequestMapping(value = {"/getAllStudents/{pageNum}/{pageSize}"},method = RequestMethod.GET)
    public R<Object> getAllStudents(@PathVariable(value = "pageNum",required = false) int pageNum, @PathVariable(value = "pageSize",required = false) int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Mybatis_Student> allStudents = mybatis_student_teacher_service.getAllStudents();
        PageInfo<Mybatis_Student> studentPageInfo = new PageInfo<>(allStudents);
        log.info("一共有{}页",studentPageInfo.getNavigateLastPage());
        log.info("这是第{}页",studentPageInfo.getPageNum());
        log.info("上一页是第{}页",studentPageInfo.getPrePage());
        log.info("下一页是第{}页",studentPageInfo.getNextPage());
        log.info("本页有{}条数据",studentPageInfo.getPageSize());
        log.info("从第{}条数据开始",studentPageInfo.getStartRow());
        log.info("到第{}条数据结束",studentPageInfo.getEndRow());
        log.info("一共有{}条数据",studentPageInfo.getTotal());
        return RUtils.success(allStudents);
    }
}
