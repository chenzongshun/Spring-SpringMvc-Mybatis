package shun.one.mapper;

import shun.one.pojo.User;

public interface UserMapperInterface {
	// 遵循四个原则
	
	// 接口方法名 == User.xml中的id名
	// 返回值类型要与Mapper.xml文件中的返回值类型要一致
	// 方法的入参要与Mapper.xml中入参的类型要一致
	// 命名空间绑定此接口
	public User findUserById(Integer id);
}

