package dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
* @author czs
* @version ����ʱ�䣺2018��3��11�� ����3:55:41
* ԭʼdao���� 
*/
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	// ��������
	public void insertUser(){
		this.getSqlSession().insert("", "");
	}
}
