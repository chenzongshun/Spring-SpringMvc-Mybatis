package shun.one.junitTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import shun.one.mapper.OrdersMapperInt;
import shun.one.mapper.UserMapperInterface;
import shun.one.pojo.Orders;
import shun.one.pojo.QueryVo;
import shun.one.pojo.User;
 
/**
 * ����mapper�ӿ�
 * @author ����
 */
public class MybatisMapperTest {
	@Test
	// ����mapper.xml�ļ���ʹ�ýӿ�
	public void testMapper() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession��������һ��ʵ���ࣨ������Ҫ��sqlSessionһ���ӿ��ࣩ
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = userMapper.findUserById(29);
		System.out.println(user);
	}
	
	@Test
	// ʹ�ð�װ���ѯ
	public void testQueryVo() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession��������һ��ʵ���ࣨ������Ҫ��sqlSessionһ���ӿ��ࣩ
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("˳");
		vo.setUser(user);
		List<User> users = userMapper.findUserByQueryVo(vo);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
	
	@Test
	// ��ѯ���ݿ��¼������
	public void testCountUser() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession��������һ��ʵ���ࣨ������Ҫ��sqlSessionһ���ӿ��ࣩ
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		Integer countUser = userMapper.countUser();
		System.out.println("���ݿ��й���\""+countUser+"\"���û�");
	}
	
	@Test
	// ��ѯ���ݿ����ж���
	public void QueryOrders() throws Exception {
		SqlSession sqlSession = getSqlSession();
		OrdersMapperInt mapper = sqlSession.getMapper(OrdersMapperInt.class);
		List<Orders> selectOrdersList = mapper.selectOrdersList();
		for (Orders orders : selectOrdersList) {
			System.out.println(orders); 
		}
	}
	
	@Test
	// �����Ա�����ֲ�ѯ�û�
	public void findUserBySexAndUserName() throws Exception {
		SqlSession sqlSession = getSqlSession();
		UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = new User();
		user.setSex("��");
		user.setUsername("˳˳"); 
		List<User> selectUserBySexAndUsername = mapper.selectUserBySexAndUsername(user);
		for (User user2 : selectUserBySexAndUsername) {
			System.out.println(user2);
		}
	}
	
	@Test
	// ���id��ѯ�û�
	public void findUserByIdS() throws Exception {
		SqlSession sqlSession = getSqlSession();
		UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
		QueryVo vo = new QueryVo();
		List<Integer> integer = new ArrayList<Integer>();
		integer.add(24);
		integer.add(25);
		integer.add(26);
		vo.setIdsList(integer);
//		List<User> users = mapper.selectUserByIds(vo);
//		Integer[] arrayId = {23,24,25};
//		List<User> users = mapper.selectUserByIds(arrayId);
		List<User> users = mapper.selectUserByIds(integer);
		for (User user : users) {
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
