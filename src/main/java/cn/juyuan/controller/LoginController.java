package cn.juyuan.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.juyuan.entity.User;
import cn.juyuan.service.UserService;
import cn.juyuan.util.Result;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService service;
	@RequestMapping("/login.do")
	@ResponseBody
	public Result<User> checkLogin(String username,String pwd){
		System.out.println(username+pwd);
		Result<User> result=service.checkLogin(username, pwd);
		return result;
		
	}
	@RequestMapping("/regist.do")
	@ResponseBody
	public Result<User> regist(String name,String pwd,String nick){
		
		Result<User> result=service.saveUser(name, pwd, nick);
		return result;
		
	}
	
	
	
}
