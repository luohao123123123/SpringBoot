package com.luohao.springboot.service;

import com.luohao.springboot.bean.Student;
import com.luohao.springboot.imp.StudentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentService implements StudentImp {
    @Autowired
    StudentImp studentImp;

    @Override
    public Student getStudent() {
        return studentImp.getStudent();
    }

    @Override
    public void deleteStudentWtihId(int id) {
        studentImp.deleteStudentWtihId(id);
    }

    @Override
    public void insertStudent(Student student) {
        studentImp.insertStudent(student);
    }

    @Override
    public void updataById(int id, String name, String addr) {
        studentImp.updataById(id,name,addr);
    }

}
