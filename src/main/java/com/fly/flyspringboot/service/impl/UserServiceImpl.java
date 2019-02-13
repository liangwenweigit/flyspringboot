package com.fly.flyspringboot.service.impl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fly.flyspringboot.domain.User;
import com.fly.flyspringboot.mapper.UserMapper;
import com.fly.flyspringboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	 private UserMapper userMapper;
	 
	@Override
	public Long add(User user) {
		userMapper.insert(user);
		Long id = user.getId();
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)//读写型
	//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型
	public Long addAccount() {
		User user = new User();
		user.setAge(88);
		user.setCreateTime(new Date());
		user.setName("测试事务啦加入事务");
		user.setPhone("10010101010");
		userMapper.insert(user);
		//手动抛出异常，出异常上面的插入就不会被提交，要是没开启事务，上面插入了，后面抛异常，不会回滚
		int i = 19/0;
		return 0L;
	}
	
	
	

	
	
}
