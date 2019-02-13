package com.fly.flyspringboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.flyspringboot.domain.JsonData;
import com.fly.flyspringboot.domain.User;
import com.fly.flyspringboot.mapper.UserMapper;
import com.fly.flyspringboot.service.UserService;

@Controller
@RequestMapping("/user/api")
public class UserController {
	
	/**
	 * 测试redis
	 * @return
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;//redis提供的操作redisKV数据库的模板对象
	//往redis里面插入数据http://localhost:8080/user/api/add_redis
	@GetMapping("/add_redis")
	@ResponseBody
	public Object addResid(){
		stringRedisTemplate.opsForValue().set("name", "飞飞");
		return JsonData.buildSuccess("OK");
	}
	//往redis取数据 http://localhost:8080/user/api/get_redis
	@GetMapping("/get_redis")
	@ResponseBody
	public Object getResid(){
		String value = stringRedisTemplate.opsForValue().get("name");
		return JsonData.buildSuccess(value);
	}
	
	
	
	
	
	
	
	@RequestMapping("/get")
	public String get(){
		return "index";
	}
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
		
	/**
	 * 功能描述: user 保存接口
	 * @return
	 */
	@GetMapping("/add")
	@ResponseBody
	public Object add(){
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("xdclass");
		user.setPhone("10010000");
		Long id = userService.add(user);
        return JsonData.buildSuccess(id);
	}
	

	/**
	 * 功能描述：查找全部用户
	 * @return
	 */
	@GetMapping("/findAll")
	@ResponseBody
	public Object findAll(){
		
       return JsonData.buildSuccess(userMapper.getAll());
	}
	

	//http://localhost:8080/user/api/find_by_id?id=18
	@GetMapping("/find_by_id")
	@ResponseBody
	public Object findById(long id){
       return JsonData.buildSuccess(userMapper.findById(id));
	}
	
	
	@GetMapping("/del_by_id")
	@ResponseBody
	public Object delById(long id){
	userMapper.delete(id);
       return JsonData.buildSuccess();
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Object update(String name,Long id){
		User user = new User();
		user.setName(name);
		user.setId(id);
		userMapper.update(user);
	    return JsonData.buildSuccess();
	}

	//测试事务
	@GetMapping("/add_account")
	@ResponseBody
	public Object addAccount(){
		Long id = userService.addAccount();
	    return JsonData.buildSuccess(id);
	}
	

}
