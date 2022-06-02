package com.luohao.springboot.imp;

import com.luohao.springboot.bean.Mybatis_Student;
import com.luohao.springboot.dao.Mybatis_Student_TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class Mybatis_Student_Teacher_Imp implements Mybatis_Student_TeacherDao {
    @Qualifier("mybatis_Student_TeacherDao")  //用来区分
    @Autowired
    Mybatis_Student_TeacherDao mybatisStudentTeacherDao;


    @Override
    public List<Mybatis_Student> getStudentsByTid(int tid) {
        return mybatisStudentTeacherDao.getStudentsByTid(tid);
    }

    @Override
    public List<Mybatis_Student> getStudentsByTids(List<Integer> tid) {
        return mybatisStudentTeacherDao.getStudentsByTids(tid);
    }

    @Override
    public List<Mybatis_Student> getStudentsByLikeTeacherName(String name) {
        return mybatisStudentTeacherDao.getStudentsByLikeTeacherName(name);
    }

    @Override
    public List<Mybatis_Student> getAllStudents() {
        return mybatisStudentTeacherDao.getAllStudents();
    }
}
