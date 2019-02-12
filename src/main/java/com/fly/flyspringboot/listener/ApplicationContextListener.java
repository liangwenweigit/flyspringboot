package com.fly.flyspringboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.boot.web.servlet.ServletComponentScan;
@WebListener//上下文监听器
public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.err.println("服务器关闭的时候销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.err.println("初始化，容器启动的时候,一般会开一个线程初始化这些要初始化的资源");
	}

}
