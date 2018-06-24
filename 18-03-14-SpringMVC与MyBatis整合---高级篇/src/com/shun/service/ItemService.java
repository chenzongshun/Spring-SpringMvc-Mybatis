package com.shun.service;

import java.util.List;
import com.shun.pojo.Items;
import com.shun.pojo.QueryVo;

/**
* @author czs
* @version 创建时间：2018年3月14日 下午6:45:42 
*/
public interface ItemService {
	
	// 查询所有的商品
	List<Items> selectItemList();
	
	// 查询商品
	public Items selectItemsById(Integer id);

	void updateitem(Items items);

	// 删除一组商品
	void deletes(Integer[] ids);

	// 修改多个商品，页面组装到QueryVo的list属性中---实际上是绑定jsp页上面的数组到形参中
	void updates(QueryVo vo);
}
