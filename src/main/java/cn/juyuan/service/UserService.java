package cn.juyuan.service;

import cn.juyuan.entity.User;
import cn.juyuan.util.Result;

public interface UserService{
	public Result<User> checkLogin(String username,String pwd);
	public Result<User> saveUser(String name,String pwd,String nick);
}
