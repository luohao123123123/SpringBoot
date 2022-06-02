package com.luohao.springboot.imp;

import com.luohao.springboot.bean.Person;
import com.luohao.springboot.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonImp implements PersonDao {
    /**
     *  @Resource(type = Person.class) 按照bean的类型装配
     *  @Resource(name = "person") 按照bean的名字装配
     *  @Autowired 默认按照bean的类型，结合@Qualifier可以使用bean的名字进行装配
     */
    @Autowired
    Person person;
    @Override
    public Person getPersonInfo() {
        return person;
    }
}
