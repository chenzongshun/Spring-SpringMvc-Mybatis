package junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;

/**
* @author czs
* @version ����ʱ�䣺2018��3��11�� ����5:01:37 
*/
@SuppressWarnings("resource")
public class JunitTest {
	@Test
	// ���Զ�̬�����ֶ��ƶ���
	public void testMapepr() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class); // Ҳ��
		// UserMapper userMapper = (UserMapper) ac.getBean("userMapper");// Ҳ��
		User selectUserById = userMapper.selectUserById(29);
		System.out.println(selectUserById);
	}

	@Test
	// ���Զ�̬�����Զ�ɨ���
	public void testMapeprScanner() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");// �Զ�ɨ�趯̬����ֻ�ܹ�д�ɽӿڵ�Сд��ĸ��ͷ��
		User selectUserById = userMapper.selectUserById(29);
		System.out.println(selectUserById);
	}
}
