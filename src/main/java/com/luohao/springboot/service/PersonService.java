package com.luohao.springboot.service;

import com.luohao.springboot.bean.Person;
import com.luohao.springboot.dao.PersonDao;
import com.luohao.springboot.imp.PersonImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonDao {
    @Autowired
    PersonImp personImp;
    @Override
    public Person getPersonInfo() {
        return personImp.getPersonInfo();
    }
}
