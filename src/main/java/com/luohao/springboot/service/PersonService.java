package com.luohao.springboot.service;

import com.luohao.springboot.bean.Person;
import com.luohao.springboot.imp.PersonImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public class PersonService implements PersonImp {
    @Autowired
    Person person;
    @Override
    public Person getPersonInfo() {
        return person;
    }
}
