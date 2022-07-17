package com.luohao.springboot.config;

import com.luohao.springboot.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *将各种拦截器添加ioc容器中
 */
@Slf4j
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加LoginInterceptor拦截器到ioc容器,并且指定拦截规则
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login.html").addPathPatterns("/login")//addPathPatterns：该方法用于指定拦截路径，例如拦截路径为“/**”，表示拦截所有请求，包括对静态资源的请求。
                //放行登录页，登陆操作，静态资源.excludePathPatterns：该方法用于排除拦截路径，即指定不需要被拦截器拦截的请求。
                .excludePathPatterns();

        log.info("在容器中添加了一个拦截器：LoginInterceptor");
        //其他的拦截器：

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

