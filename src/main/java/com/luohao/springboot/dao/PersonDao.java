package com.luohao.springboot.dao;

import com.luohao.springboot.bean.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
     Person getPersonInfo();

}
