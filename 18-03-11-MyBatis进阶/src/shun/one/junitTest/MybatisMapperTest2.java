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
 * ����mapper�ӿ�
 * @author ����
 */
public class MybatisMapperTest2 {
	
	@Test
	// ����һ��һ��ϵ��Orders������һ���û�����ѯ���ж�����˳����ʾ���ж���������û�
	public void OrderList() throws Exception {
		SqlSession sqlSession = getSqlSession();
		OrdersMapperInt mapper = sqlSession.getMapper(OrdersMapperInt.class);
		List<Orders> selectOrders = mapper.selectOrders();
		for (Orders orders : selectOrders) {
			System.out.println(orders);
		}
	}
	
	@Test
	// ����һ��һ��ϵ��Orders������һ���û�����ѯ���ж�����˳����ʾ���ж���������û�
	public void selectUserAndOrders() throws Exception {
		SqlSession sqlSession = getSqlSession();
		UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
		List<User> Users = mapper.selectUserAndOrders();
		for (User user : Users) {
			System.out.println(user);
		}
	}

	//  ���sqlSession����
	private SqlSession getSqlSession() throws IOException {
		// 1 ���غ��������ļ� 
		String resource = "sqlMapConfig.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);// org.apache.ibatis.io.Resources
		// 2 ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		// 3 ����sqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
