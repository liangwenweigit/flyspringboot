package com.fly.flyspringboot.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener//请求监听器
public class RequestListener implements ServletRequestListener{
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("======处理完请求再调用========");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("======请求到达首先调用========");
	}
}
	
