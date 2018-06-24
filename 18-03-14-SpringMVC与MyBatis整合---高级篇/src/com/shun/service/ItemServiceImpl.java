package com.shun.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shun.dao.ItemsMapper;
import com.shun.pojo.Items;
import com.shun.pojo.ItemsExample;
import com.shun.pojo.ItemsExample.Criteria;
import com.shun.pojo.QueryVo;

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
 

	@Override
	// mybatis修改商品
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

	@Override
	// 删除一组商品
	public void deletes(Integer[] ids) {
		for (Integer integer : ids) {
			System.out.println(integer);
			itemsMapper.deleteByPrimaryKey(integer);
		}
	}

	@Override
	// 修改很多商品
	public void updates(QueryVo vo) {
		List<Items> itemsList = vo.getItemsList();
		for (Items items : itemsList) {
			ItemsExample example = new ItemsExample();
			Criteria  criteria = example.createCriteria();
			criteria.andIdEqualTo(items.getId());// 居然忘记加条件了，弄的所有的记录修改后都是一个样...
			itemsMapper.updateByExampleSelective(items,example);
		}
	}
}
