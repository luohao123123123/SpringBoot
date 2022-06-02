package com.luohao.springboot.bean;

import com.luohao.springboot.annotation.IdFormatter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class Mybatis_Student {
    @NotNull
    private int id;
    private String name;
    private String sex;
    private int tid;

    public Mybatis_Student() {
    }

    public Mybatis_Student(String name, String sex, int tid) {
        this.name = name;
        this.sex = sex;
        this.tid = tid;
    }

    public Mybatis_Student(int id, String name, String sex, int tid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.tid = tid;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mybatis_Student that = (Mybatis_Student) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(sex, that.sex) && Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, tid);
    }

    @Override
    public String toString() {
        return "Mybatis_Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", tid=" + tid +
                '}';
    }
}
