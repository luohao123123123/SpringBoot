package com.luohao.springboot.bean;

import com.luohao.springboot.annotation.IdFormatter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class Mybatis_Teacher {
    @NotNull
    private int id;
    private String name;


    public Mybatis_Teacher() {
    }

    public Mybatis_Teacher(String name) {
        this.name = name;

    }

    public Mybatis_Teacher(int id, String name) {
        this.id = id;
        this.name = name;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mybatis_Teacher that = (Mybatis_Teacher) o;
        return id == that.id  && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Mybatis_Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
