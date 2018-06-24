package junitTest;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shun.mapper.UserMapper;
import shun.pojo.User;
import shun.pojo.UserExample;

/**
* @author czs
* @version 创建时间：2018年3月11日 下午5:01:37 
*/
@SuppressWarnings("resource")
public class JunitTest {
	@Test
	// 测试自动生成的pojo和mapper
	public void testMapepr() throws Exception{
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
			UserExample example = new UserExample();
			example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+"明"+"%").andAddressLike("%"+"河南"+"%");

			// 查询适合条件的条数
			int countByExample = userMapper.countByExample(example);
			System.out.println("总共有记录："+countByExample);
			
			// 查询id为10的
			User selectByPrimaryKey = userMapper.selectByPrimaryKey(10);
			System.out.println(selectByPrimaryKey);
			
			// 查询所有的用户
			example.setOrderByClause("id desc");// 设置倒叙--源代码里面有
			List<User> users = userMapper.selectByExample(example);    
			for (User user : users) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
