package junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;

/**
* @author czs
* @version 创建时间：2018年3月11日 下午5:01:37 
*/
@SuppressWarnings("resource")
public class JunitTest {
	@Test
	// 测试动态代理手动制定版
	public void testMapepr() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class); // 也行
		// UserMapper userMapper = (UserMapper) ac.getBean("userMapper");// 也行
		User selectUserById = userMapper.selectUserById(29);
		System.out.println(selectUserById);
	}

	@Test
	// 测试动态代理自动扫描版
	public void testMapeprScanner() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");// 自动扫描动态代理只能够写成接口的小写字母开头！
		User selectUserById = userMapper.selectUserById(29);
		System.out.println(selectUserById);
	}
}
