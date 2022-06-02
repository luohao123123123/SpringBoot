package com.luohao.springboot.dao;

import com.luohao.springboot.bean.Mybatis_Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Mybatis_Student_TeacherDao {
    List<Mybatis_Student> getStudentsByTid(int tid);   //根据tid查询Student
    List<Mybatis_Student> getStudentsByTids(List<Integer> tid);  //根据一组tid查询Student
    List<Mybatis_Student> getStudentsByLikeTeacherName(String name);  //根据teacher_name进行模糊查询Student
    List<Mybatis_Student> getAllStudents();   //查询所有的Student
}
