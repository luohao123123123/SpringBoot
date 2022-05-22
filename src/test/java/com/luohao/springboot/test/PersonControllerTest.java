package com.luohao.springboot.test;

import com.luohao.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


/**
 * 测试beans.xml中的personService是否添加到iop容器中
 */
@SpringBootTest
public class PersonControllerTest {
    @Autowired
    Person person;

    //Ioc容器
    @Autowired
    ApplicationContext ioc;

    @Test
    public void PersonTest(){
        boolean flag = ioc.containsBean("personService");
        if(flag){
            System.out.println("personService 已经添加到iop容器中");
        }
        else {
            System.out.println("personService 没有添加到iop容器中");
        }
    }
    @Test
    public void printPerson(){
        System.out.println(person);
    }

}
