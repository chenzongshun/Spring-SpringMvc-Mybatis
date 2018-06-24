package com.shun.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shun.dao.ItemsMapper;
import com.shun.pojo.Items;
import com.shun.pojo.ItemsExample;
import com.shun.pojo.ItemsExample.Criteria;

/**
* @author czs
* @version 创建时间：2018年3月14日 下午6:46:10
* 查询商品信息 
*/
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	// 查询商品列表
	public List<Items> selectItemList(){
		List<Items> selectByExample = itemsMapper.selectByExampleWithBLOBs(null);
		return selectByExample;
	}
	
	// 查询商品
	public Items selectItemsById(Integer id){
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

//	@Override
//	// mybatis修改商品
//	public void updateitem(QueryVo items) {
//		// 如果没有提交的字段将不会进行set
//		ItemsExample example = new ItemsExample();
//		Criteria  criteria = example.createCriteria();
//		criteria.andIdEqualTo(items.getItems().getId());
//		itemsMapper.updateByExampleSelective(items.getItems(), example);
//		
//		// 下面两个中对于表单上面没有提交的字段放到下面修改会出错
//		// itemsMapper.updateByPrimaryKey(items);
//		// itemsMapper.updateByPrimaryKeyWithBLOBs(items);
//	}

	@Override
	public void updateitem(Items items) {
		// 如果没有提交的字段将不会进行set
		ItemsExample example = new ItemsExample();
		Criteria  criteria = example.createCriteria();
		criteria.andIdEqualTo(items.getId());
		itemsMapper.updateByExampleSelective(items, example);
		
		// 下面两个中对于表单上面没有提交的字段放到下面修改会出错
		// itemsMapper.updateByPrimaryKey(items);
		// itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
}
