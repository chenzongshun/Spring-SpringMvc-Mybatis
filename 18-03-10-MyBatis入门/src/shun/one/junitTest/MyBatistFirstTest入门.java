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

public class MyBatistFirstTest���� {
	@Test
	// ����idɾ���û� 
	public void deleteUserById() throws Exception{
		SqlSession sqlSession = getSqlSession();
		sqlSession.delete("user.deleteUserById", 28);
		sqlSession.commit();
	}
	@Test
	// ����id�޸��û� 
	public void updateUserById() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = new User(); user.setId(29); user.setUsername("˳˳"); user.setBirthday(new Date()); user.setAddress("����¦��"); user.setSex("��");
		sqlSession.update("user.updateUserById", user);
		sqlSession.commit();
	}
	@Test
	 //  ����û�
	public void insertUser() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = new User(); user.setUsername("˳"); user.setBirthday(new Date()); user.setAddress("������̶"); user.setSex("��");
		sqlSession.insert("user.insertUser", user);
		sqlSession.commit();
		System.err.println("��������idֵ�����ݿ���Ϊ��"+user.getId());
	}
	@Test
	//  �����û���ģ����ѯ�û��б�
	public void findByUserName() throws Exception{
		SqlSession sqlSession = getSqlSession();
		List<User> users = sqlSession.selectList("user.findByUserName", "��");
		for (User user : users) {
			System.out.println(user);
		}
	}
	//  ����id��ѯ����
	public void findByUserId() throws Exception{
		SqlSession sqlSession = getSqlSession();
		User user = sqlSession.selectOne("user.findUserById", 1);
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
