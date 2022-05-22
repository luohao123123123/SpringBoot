package com.luohao.springboot.config.webConfig;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * 创建自定义web原生组件：Filter
 */
@Slf4j
public class MyFilter extends HttpFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFiler 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFiler doFilter");
        super.doFilter(request, response, chain);

    }

    @Override
    public void destroy() {
        log.info("MyFiler 销毁");
    }
}
