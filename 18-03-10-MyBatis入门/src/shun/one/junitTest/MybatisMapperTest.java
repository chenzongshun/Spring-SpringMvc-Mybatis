package shun.one.junitTest;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import shun.one.mapper.UserMapperInterface;
import shun.one.pojo.User;
 
/**
 * ����mapper�ӿ�
 * @author ����
 *
 */
public class MybatisMapperTest {
	@Test
	public void testMapper() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession��������һ��ʵ���ࣨ������Ҫ��sqlSessionһ���ӿ��ࣩ
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = userMapper.findUserById(29);
		System.out.println(user);
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
