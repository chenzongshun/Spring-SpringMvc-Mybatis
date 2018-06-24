package com.shun.service;

import java.util.List;
import com.shun.pojo.Items;

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
}
