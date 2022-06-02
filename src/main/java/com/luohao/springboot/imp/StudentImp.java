package com.luohao.springboot.imp;

import com.luohao.springboot.bean.Student;
import com.luohao.springboot.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class StudentImp implements StudentDao {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student getStudent() {
        return studentDao.getStudent();
    }

    @Override
    public void deleteStudentWtihId(int id) {
        studentDao.deleteStudentWtihId(id);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updataById(int id, String name, String addr) {
        studentDao.updataById(id,name,addr);
    }

}
