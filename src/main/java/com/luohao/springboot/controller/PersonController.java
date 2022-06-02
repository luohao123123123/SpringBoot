package com.luohao.springboot.controller;

import com.luohao.springboot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//将 beans.xml 加载到项目中
//@ImportResource(locations = {"classpath:/beans.xml"})   //todo:SpringBoot导入spring配置方法1

@Slf4j
@Controller
public class PersonController {
    @Autowired
    Person person;
//    Logger logger = LoggerFactory.getLogger(PersonController.class);


    @ResponseBody
    @RequestMapping("/Person")   //这里如果直接返回Person，会报错，自己引用了自己， ProcessDefinition属性里面有一些属性会导致循环引用，可以先把所有的属性取出来，装进Map，最后返回一个Map
    public Map<Object,Object> hello(){
        log.info("{}",person); //输出重要信息
        log.warn("{}",person); //输出警告信息
        log.error("{}",person); //输出错误信息
        Map<Object,Object> PersonMap=new HashMap<>();
        PersonMap.put("LastName",person.getLastName());
        PersonMap.put("Age",person.getAge());
        PersonMap.put("Birth",person.getBirth());
        PersonMap.put("Maps",person.getMaps());
        PersonMap.put("Boss",person.getBoss());
        PersonMap.put("Lists",person.getLists());
        PersonMap.put("Dog",person.getDog());
        return PersonMap;
    }


    @RequestMapping("/loginInfo")
    public String logoInfo(Map<Object,Object> map){
        log.info("{}",person); //输出重要信息
        log.warn("{}",person); //输出警告信息
        log.error("{}",person); //输出错误信息
        map.put("person",person);
        return "login";
    }


}
