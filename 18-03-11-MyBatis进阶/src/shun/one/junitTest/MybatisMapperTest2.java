package shun.one.junitTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import shun.one.mapper.OrdersMapperInt;
import shun.one.mapper.UserMapperInterface;
import shun.one.pojo.Orders;
import shun.one.pojo.User;

/**
 * 测试mapper接口
 * @author 疙瘩陈
 */
public class MybatisMapperTest2 {
	
	@Test
	// 测试一对一关系，Orders里面有一个用户，查询所有订单，顺便显示所有订单里面的用户
	public void OrderList() throws Exception {
		SqlSession sqlSession = getSqlSession();
		OrdersMapperInt mapper = sqlSession.getMapper(OrdersMapperInt.class);
		List<Orders> selectOrders = mapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	
	@Test
	// 测试一对一关系，Orders里面有一个用户，查询所有订单，顺便显示所有订单里面的用户
	public void selectUserAndOrders() throws Exception {
		SqlSession sqlSession = getSqlSession();
		UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
		List<User> Users = mapper.selectUserAndOrders();
		for (User user : Users) {
			System.out.println(user);
		}
	}

	//  获得sqlSession对象
	private SqlSession getSqlSession() throws IOException {
		// 1 加载核心配置文件 
		String resource = "sqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);// org.apache.ibatis.io.Resources
		// 2 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		// 3 创建sqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
