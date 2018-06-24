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
* @version ����ʱ�䣺2018��3��14�� ����6:46:10
* ��ѯ��Ʒ��Ϣ 
*/
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	// ��ѯ��Ʒ�б�
	public List<Items> selectItemList(){
		List<Items> selectByExample = itemsMapper.selectByExampleWithBLOBs(null);
		return selectByExample;
	}
	
	// ��ѯ��Ʒ
	public Items selectItemsById(Integer id){
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

//	@Override
//	// mybatis�޸���Ʒ
//	public void updateitem(QueryVo items) {
//		// ���û���ύ���ֶν��������set
//		ItemsExample example = new ItemsExample();
//		Criteria  criteria = example.createCriteria();
//		criteria.andIdEqualTo(items.getItems().getId());
//		itemsMapper.updateByExampleSelective(items.getItems(), example);
//		
//		// ���������ж��ڱ�����û���ύ���ֶηŵ������޸Ļ����
//		// itemsMapper.updateByPrimaryKey(items);
//		// itemsMapper.updateByPrimaryKeyWithBLOBs(items);
//	}

	@Override
	public void updateitem(Items items) {
		// ���û���ύ���ֶν��������set
		ItemsExample example = new ItemsExample();
		Criteria  criteria = example.createCriteria();
		criteria.andIdEqualTo(items.getId());
		itemsMapper.updateByExampleSelective(items, example);
		
		// ���������ж��ڱ�����û���ύ���ֶηŵ������޸Ļ����
		// itemsMapper.updateByPrimaryKey(items);
		// itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
}
