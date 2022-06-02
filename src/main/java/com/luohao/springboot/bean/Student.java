package com.luohao.springboot.bean;

import com.luohao.springboot.annotation.TestAnnotation;
import com.luohao.springboot.annotation.IdFormatter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;



@Component
@TestAnnotation(id=4,name = "zhaoliu",addr = "中国")  //自定义注解
public class Student {
    @Id
    @IdFormatter //自定义注解：用来保证id必须为int类型
    @NotNull     //JSR303校验 此字段不能为null
    @DecimalMin("1") //JSR303校验 必须大于等于1
    private int id;
    private String name;
    private String addr;

    public Student() {
    }

    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public Student(int id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(addr, student.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addr);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
