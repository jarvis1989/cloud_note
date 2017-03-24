package cn.juyuan.dao;

import cn.juyuan.entity.User;

public interface UserDao {
	User findByName(String username);
	boolean addUser(User user);
}
