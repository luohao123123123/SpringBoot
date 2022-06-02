package com.luohao.springboot.service;

import com.luohao.springboot.bean.Student;
import com.luohao.springboot.dao.StudentDao;
import com.luohao.springboot.imp.StudentImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService implements StudentDao {

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
