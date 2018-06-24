package mapper; 

import pojo.User;

/**
* @author czs
* @version 创建时间：2018年3月11日 下午4:37:05 
*/
public interface UserMapper {
	/**
	 * 根据id查询用户
	 */
	public User selectUserById(Integer id);
}
