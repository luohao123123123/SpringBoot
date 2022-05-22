package com.luohao.springboot.controller;

import com.luohao.springboot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.plugin.dom.html.ns4.HTMLFormCollection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login(HttpSession session, @RequestParam(value="username", required=false) String username, @RequestParam(value="pwd", required=false) String pwd, Map<String, Object> map){
        if(username.isEmpty() || pwd.isEmpty()){
            map.put("msg","请输入账号或密码");
            return "/login.html";
        }
        else if (Objects.equals(username, "张三") && Objects.equals(pwd,"123")) {
            session.setAttribute("loginUserName", username);
            log.info(username + " 登陆成功！");
            return "redirect:/home.html";
        }
        else {
            map.put("msg","用户名或密码错误");
            log.error("登陆失败");
            return "/login.html";
        }
    }

}
