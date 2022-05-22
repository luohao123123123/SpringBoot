package com.luohao.springboot.config;



import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 配置国际化资源
 */
@Slf4j
@Configuration
public class MyLocaleResolverConfig implements LocaleResolver {
    @Override
        public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String language = request.getParameter("lang");


        //打印语言
        log.info("语言：{}",language);
        //如果没有就使用默认的（根据主机的语言环境生成一个 Locale ）。
        if(StringUtils.isEmpty(language)){
            Locale locale=Locale.getDefault();
            return locale;
        }
        //如果请求的链接中携带了 国际化的参数
        else{
            //zh_CN
            String[] s = language.split("_");
            //国家，地区
           return new Locale(s[0],s[1]);
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
