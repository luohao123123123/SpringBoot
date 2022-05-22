package com.luohao.springboot.config.webConfig;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 创建自定义web原生组件：Listener
 */
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       log.info("MyListener 监听到 ServletContext 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       log.info("MyListener 监听到 ServletContext 销毁");
    }
}
