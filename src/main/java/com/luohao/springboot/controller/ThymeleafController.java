package com.luohao.springboot.controller;

import com.luohao.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

@Controller
public class ThymeleafController {
    @Autowired
    Person person;

    @RequestMapping("/Thymeleaf")
    public String setThymeleaf(Map<Object,Object> map){
        map.put("name",person.getLastName());
        return "Thymeleaf";
    }
}
