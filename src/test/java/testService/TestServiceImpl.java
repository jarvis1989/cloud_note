package testService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.juyuan.entity.User;
import cn.juyuan.service.UserService;
import cn.juyuan.util.Result;

public class TestServiceImpl {
	 UserService service;
	@Before
	public void init(){
	String[] conf={"conf/spring-mybatis.xml",
			       "conf/spring-mvc.xml",
			       "conf/spring-transaction.xml"};

	ApplicationContext act=new ClassPathXmlApplicationContext(conf);
	service=act.getBean("userService",UserService.class);
	}
	@Test
	public void testcheckLogin(){
		String name="zhoujia123";
		String pwd="4297f44b13955235245b2497399d7a93";
		Result<User>result= service.checkLogin(name, pwd);
		System.out.println(result);
	}
	@Test
	public void testsaveUser(){
		Result<User> result=service.saveUser("huahua","123456", "xiaohua");
		System.out.println(result);
		
		
	}
	
	
}
