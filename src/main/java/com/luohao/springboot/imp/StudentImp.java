package com.luohao.springboot.imp;

import com.luohao.springboot.bean.Student;
import org.apache.ibatis.annotations.*;


@Mapper
public interface StudentImp {
//    @Select("select * from table1 limit 1")
    Student getStudent();

//    @Delete("delete from table1 where id=#{id,jdbcType=INTEGER}")
    void deleteStudentWtihId(int id);

//    @Insert("insert into table1 (id,name,addr) values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{addr,jdbcType=VARCHAR})")
    void insertStudent(Student student);

//    @Update(" update table1" +
//            "  set name = #{name,jdbcType=VARCHAR}," +
//            "addr = #{addr,jdbcType=VARCHAR}" +
//            "where id = #{id,jdbcType=INTEGER}")
    void updataById(int id,String name,String addr);

}
