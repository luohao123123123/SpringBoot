package com.luohao.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *添加各视图映射
 */
@Configuration
public class UrlViewMappingConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //当访问 “/” 或 “/index.html” 或者“/LOGIN” 时，都直接跳转到登陆页面(login)
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/LOGIN").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");




        //其他：

        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
