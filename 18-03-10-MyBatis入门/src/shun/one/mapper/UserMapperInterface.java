package shun.one.mapper;

import shun.one.pojo.User;

public interface UserMapperInterface {
	// ��ѭ�ĸ�ԭ��
	
	// �ӿڷ����� == User.xml�е�id��
	// ����ֵ����Ҫ��Mapper.xml�ļ��еķ���ֵ����Ҫһ��
	// ���������Ҫ��Mapper.xml����ε�����Ҫһ��
	// �����ռ�󶨴˽ӿ�
	public User findUserById(Integer id);
}

