package mapper; 

import pojo.User;

/**
* @author czs
* @version ����ʱ�䣺2018��3��11�� ����4:37:05 
*/
public interface UserMapper {
	/**
	 * ����id��ѯ�û�
	 */
	public User selectUserById(Integer id);
}
