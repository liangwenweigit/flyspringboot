package com.fly.flyspringboot.service;

import com.fly.flyspringboot.domain.User;

public interface UserService {

	public Long add(User user);

	/**
	 * 功能描述：测试事务
	 * @return
	 */
	public Long addAccount();
	
}
