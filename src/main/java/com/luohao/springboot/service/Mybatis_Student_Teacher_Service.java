package com.luohao.springboot.service;

import com.luohao.springboot.bean.Mybatis_Student;
import com.luohao.springboot.imp.Mybatis_Student_Teacher_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mybatis_Student_Teacher_Service implements Mybatis_Student_Teacher_Imp{
    @Qualifier("mybatis_Student_Teacher_Imp")  //用来区分
    @Autowired
    Mybatis_Student_Teacher_Imp mybatis_student_teacher_imp;


    @Override
    public List<Mybatis_Student> getStudentsByTid(int tid) {
        return mybatis_student_teacher_imp.getStudentsByTid(tid);
    }

    @Override
    public List<Mybatis_Student> getStudentsByTids(List<Integer> tid) {
        return mybatis_student_teacher_imp.getStudentsByTids(tid);
    }

    @Override
    public List<Mybatis_Student> getStudentsByLikeTeacherName(String name) {
        return mybatis_student_teacher_imp.getStudentsByLikeTeacherName(name);
    }

    @Override
    public List<Mybatis_Student> getAllStudents() {
        return mybatis_student_teacher_imp.getAllStudents();
    }
}
