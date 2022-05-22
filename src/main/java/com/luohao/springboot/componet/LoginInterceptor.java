package com.luohao.springboot.componet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws ServletException, IOException {
        Object loginUserName = request.getSession().getAttribute("loginUserName");
       log.info("loginUseName:{}",loginUserName);
        if(loginUserName==null){
            request.setAttribute("msg","您没有权限操作！请先登陆");
            return true;
        }
        else {
            return true;
        }
    }

    /**
     *目标方法执行后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("login方法执行后{}", modelAndView);
    }

    /**
     *页面渲染后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("login页面渲染后",ex);
    }
}
