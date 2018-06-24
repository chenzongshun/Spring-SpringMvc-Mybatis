package shun.one.mapper;

import java.util.List;
import java.util.Map;

import shun.one.pojo.QueryVo;
import shun.one.pojo.User;

public interface UserMapperInterface {
	// 遵循四个原则
	
	// 接口方法名 == User.xml中的id名
	// 返回值类型要与Mapper.xml文件中的返回值类型要一致
	// 方法的入参要与Mapper.xml中入参的类型要一致
	// 命名空间绑定此接口
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据包装类对象查询用户List
	 * @param vo
	 * @return
	 */
	public List<User> findUserByQueryVo(QueryVo vo);
	
	/**
	 * 根据包装类对象查询用户Map
	 * @param vo
	 * @return
	 */
	public Map<Object, Object> findUserByQueryVoMap(QueryVo vo);
	
	/**
	 * 查询数据条数
	 */
	public Integer countUser();
	
	/** 
	  * 根据性别和名字查询用户
	 */
	public List<User> selectUserBySexAndUsername(User user);
	
	/**
	 * 根据多个id查询用户信息
	 */
	public List<User> selectUserByIds(Integer[] ids);
	
	/**
	 * 根据多个id查询用户信息
	 */
	public List<User> selectUserByIds(List<Integer> ids);

	/**
	 * 根据多个id查询用户信息
	 */
	public List<User> selectUserByIds(QueryVo vo);
	
	/**
	 * 查询所有用户，并且包括对应的订单，用来测试一对多关系表达
	 */
	public List<User> selectUserAndOrders();
}

