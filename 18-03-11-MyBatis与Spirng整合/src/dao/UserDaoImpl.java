package dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
* @author czs
* @version 创建时间：2018年3月11日 下午3:55:41
* 原始dao开发 
*/
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	// 声明工厂
	public void insertUser(){
		this.getSqlSession().insert("", "");
	}
}
