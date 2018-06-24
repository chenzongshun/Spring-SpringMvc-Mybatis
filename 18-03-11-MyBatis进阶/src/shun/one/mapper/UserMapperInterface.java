package shun.one.mapper;

import java.util.List;
import java.util.Map;

import shun.one.pojo.QueryVo;
import shun.one.pojo.User;

public interface UserMapperInterface {
	// ��ѭ�ĸ�ԭ��
	
	// �ӿڷ����� == User.xml�е�id��
	// ����ֵ����Ҫ��Mapper.xml�ļ��еķ���ֵ����Ҫһ��
	// ���������Ҫ��Mapper.xml����ε�����Ҫһ��
	// �����ռ�󶨴˽ӿ�
	
	/**
	 * ����id��ѯ�û�
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * ���ݰ�װ������ѯ�û�List
	 * @param vo
	 * @return
	 */
	public List<User> findUserByQueryVo(QueryVo vo);
	
	/**
	 * ���ݰ�װ������ѯ�û�Map
	 * @param vo
	 * @return
	 */
	public Map<Object, Object> findUserByQueryVoMap(QueryVo vo);
	
	/**
	 * ��ѯ��������
	 */
	public Integer countUser();
	
	/** 
	  * �����Ա�����ֲ�ѯ�û�
	 */
	public List<User> selectUserBySexAndUsername(User user);
	
	/**
	 * ���ݶ��id��ѯ�û���Ϣ
	 */
	public List<User> selectUserByIds(Integer[] ids);
	
	/**
	 * ���ݶ��id��ѯ�û���Ϣ
	 */
	public List<User> selectUserByIds(List<Integer> ids);

	/**
	 * ���ݶ��id��ѯ�û���Ϣ
	 */
	public List<User> selectUserByIds(QueryVo vo);
	
	/**
	 * ��ѯ�����û������Ұ�����Ӧ�Ķ�������������һ�Զ��ϵ���
	 */
	public List<User> selectUserAndOrders();
}

