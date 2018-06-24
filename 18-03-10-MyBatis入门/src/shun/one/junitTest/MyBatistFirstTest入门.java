package shun.one.junitTest;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import shun.one.pojo.User;

public class MyBatistFirstTest入门 {
	@Test
	// 根据id删除用户 
	public void deleteUserById() throws Exception{
		SqlSession sqlSession = getSqlSession();
		sqlSession.delete("user.deleteUserById", 28);
		sqlSession.commit();
	}
	@Test
	// 根据id修改用户 
	public void updateUserById() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = new User(); user.setId(29); user.setUsername("顺顺"); user.setBirthday(new Date()); user.setAddress("湖南娄底"); user.setSex("男");
		sqlSession.update("user.updateUserById", user);
		sqlSession.commit();
	}
	@Test
	 //  添加用户
	public void insertUser() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = new User(); user.setUsername("顺"); user.setBirthday(new Date()); user.setAddress("湖南湘潭"); user.setSex("男");
		sqlSession.insert("user.insertUser", user);
		sqlSession.commit();
		System.err.println("这个对象的id值在数据库中为："+user.getId());
	}
	@Test
	//  根据用户名模糊查询用户列表
	public void findByUserName() throws Exception{
		SqlSession sqlSession = getSqlSession();
		List<User> users = sqlSession.selectList("user.findByUserName", "五");
		for (User user : users) {
			System.out.println(user);
		}
	}
	//  根据id查询对象
	public void findByUserId() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = sqlSession.selectOne("user.findUserById", 1);
		System.out.println(user);
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
