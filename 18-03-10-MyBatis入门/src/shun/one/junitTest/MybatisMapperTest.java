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
 * 测试mapper接口
 * @author 疙瘩陈
 *
 */
public class MybatisMapperTest {
	@Test
	public void testMapper() throws Exception {
		SqlSession sqlSession = getSqlSession();
		// sqlSession帮我生成一个实现类（所以我要给sqlSession一个接口类）
		UserMapperInterface userMapper = sqlSession.getMapper(UserMapperInterface.class);
		User user = userMapper.findUserById(29);
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
