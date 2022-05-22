package com.luohao.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置静态资源虚拟路径
 *添加或修改静态资源（例如图片，js，css 等）映射；
 * Spring Boot 默认设置的静态资源文件夹就是通过重写该方法设置的。
 */

@Configuration
public class StaticFilePathsConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("luohao/static/imgs/**").addResourceLocations("classpath:/static/imgs/");
        //addResourceHandler是指定的虚拟路径，addResourceLocations是自己的物理路径，
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    //http://localhost:8081/luohao/static/imgs/touxiang.jpg
    //http://localhost:8081/static/imgs/touxiang.jpg

}


