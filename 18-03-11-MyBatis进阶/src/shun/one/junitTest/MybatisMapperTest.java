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
 * 测试mapper接口
 * @author 疙瘩陈
 */
public class MybatisMapperTest {
	@Test
	// 测试mapper.xml文件，使用接口
	public void testMapper() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession帮我生成一个实现类（所以我要给sqlSession一个接口类）
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = userMapper.findUserById(29);
		System.out.println(user);
	}
	
	@Test
	// 使用包装类查询
	public void testQueryVo() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession帮我生成一个实现类（所以我要给sqlSession一个接口类）
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("顺");
		vo.setUser(user);
		List<User> users = userMapper.findUserByQueryVo(vo);
		for (User user2 : users) {
			System.out.println(user2);
		}
	}
	
	@Test
	// 查询数据库记录的条数
	public void testCountUser() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession帮我生成一个实现类（所以我要给sqlSession一个接口类）
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		Integer countUser = userMapper.countUser();
		System.out.println("数据库中共有\""+countUser+"\"个用户");
	}
	
	@Test
	// 查询数据库所有订单
	public void QueryOrders() throws Exception {
		SqlSession sqlSession = getSqlSession();
		OrdersMapperInt mapper = sqlSession.getMapper(OrdersMapperInt.class);
		List<Orders> selectOrdersList = mapper.selectOrdersList();
		for (Orders orders : selectOrdersList) {
			System.out.println(orders); 
		}
	}
	
	@Test
	// 根据性别和名字查询用户
	public void findUserBySexAndUserName() throws Exception {
		SqlSession sqlSession = getSqlSession();
		UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = new User();
		user.setSex("男");
		user.setUsername("顺顺"); 
		List<User> selectUserBySexAndUsername = mapper.selectUserBySexAndUsername(user);
		for (User user2 : selectUserBySexAndUsername) {
			System.out.println(user2);
		}
	}
	
	@Test
	// 多个id查询用户
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
