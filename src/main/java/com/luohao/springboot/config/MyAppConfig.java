package com.luohao.springboot.config;


import com.luohao.springboot.config.webConfig.MyFilter;
import com.luohao.springboot.config.webConfig.MyListener;
import com.luohao.springboot.config.webConfig.MyServlet;
import com.luohao.springboot.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
/**
 * 将各种组件添加到ioc容器中
 */
//todo:SpringBoot导入spring配置方法2：
/**
 * @Configuration 注解用于定义一个配置类，相当于 Spring 的配置文件
 * 配置类中包含一个或多个被 @Bean 注解的方法，该方法相当于 Spring 配置文件中的 <bean> 标签定义的组件。
 */
/**
 * 与beans.xml中的 <bean id="personService" class="com.luohao.springboot.imp.PersonServiceImp">等价
 * 该方法返回值以组件的形式添加到容器中
 * 方法名是组件 id（相当于 <bean> 标签的属性 id)
 */
@Slf4j
@Configuration
public class MyAppConfig {

    //  将personService添加到容器中
    @Bean
    public PersonService personService(){
       log.info("在容器中添加了一个组件：personSevice");
        return new PersonService();
    }

    //    将localeResolver添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
       log.info("在容器中添加了一个组件：localeResolver");
        return new MyLocaleResolverConfig();
    }


    //添加一个web原生组件：MyServlet
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        log.info("在容器中添加了一个web原生组件：MyServlet");
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean<>(myServlet, "/myServlet");
    }


   //添加一个web原生组件：MyFilter
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        log.info("在容器中添加了一个web原生组件：MyFilter");
        MyFilter myFiler = new MyFilter();
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>(myFiler);
        //注册该过滤器需要过滤的 url
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
        return filterRegistrationBean;
    }

    //添加一个web原生组件:MyListener
    @Bean
    public ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean() {
        log.info("在容器中添加了一个web原生组件：MyListener");
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean<>(myListener);
    }

}
