package dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.juyuan.dao.UserDao;
import cn.juyuan.entity.User;
import cn.juyuan.util.NoteUtil;

public class TestDao {
	@Test
	public void testcheck(){
		
			ApplicationContext ctx
				=new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
			UserDao dao
			=ctx.getBean("userDao",UserDao.class);
			
			User user=dao.findByName("zhoujia123");
			
			System.out.println(user);
			
	}
	
	@Test
	public void testregist(){
		ApplicationContext ctx
		=new ClassPathXmlApplicationContext(
				"conf/spring-mybatis.xml");
	UserDao dao=ctx.getBean("userDao",UserDao.class);
	User user=new User();
	user.setCn_user_id("123");
	user.setCn_user_name("huangsan");
	user.setCn_user_nick("zhutou");
	String str=NoteUtil.md5("123456");
	user.setCn_user_password(str);
	boolean success=dao.addUser(user);
	System.out.println(success);
	
	}
}
