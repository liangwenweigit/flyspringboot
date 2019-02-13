package com.fly.flyspringboot.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 * @author liang
 * 2019年2月14日上午12:32:21
 */
@Component//定时任务类也必须有这个注解 注入spring
public class TestTask {
	@Scheduled(fixedRate=2000)//方法上必须有这个注解，括号表示每2秒执行一次这个方法
	public void sum(){
		System.err.println("当前时间："+new Date());
	}

}
