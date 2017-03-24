package cn.juyuan.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.juyuan.dao.UserDao;
import cn.juyuan.entity.User;
import cn.juyuan.util.NoteUtil;
import cn.juyuan.util.Result;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao dao;
	public Result<User> checkLogin(String username, String pwd) {
		Result<User> result=new Result<User>();
		User user=dao.findByName(username);

		if(user==null){
			result.setMessage("�û�������");
			result.setStatus(2);
			return result;
		}
		String password =user.getCn_user_password();
		String input=NoteUtil.md5(pwd);
		if(password.equals(input)){
			result.setData(user);
			result.setMessage("��֤ͨ��");
			result.setStatus(0);
			return result;
		}
			result.setMessage("�������");
			result.setStatus(1);
			return result;
		
	}
	public Result<User> saveUser(String name, String pwd, String nick) {
		Result<User> result=new Result<User>();
		User userResult= dao.findByName(name);
		if(userResult!=null){
			result.setStatus(1);
			result.setMessage("�û����Ѿ�����");
			return result;
		}
		User user=new User();
		String id=NoteUtil.createId();
		String md5Pwd=NoteUtil.md5(pwd);
		user.setCn_user_id(id);
		user.setCn_user_name(name);
		user.setCn_user_nick(nick);
		user.setCn_user_password(pwd);
		dao.addUser(user);
		result.setMessage("�ɹ����");
		result.setStatus(0);
		return result;
	}

}
