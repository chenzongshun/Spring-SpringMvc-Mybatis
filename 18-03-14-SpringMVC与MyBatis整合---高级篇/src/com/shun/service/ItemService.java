package com.shun.service;

import java.util.List;
import com.shun.pojo.Items;
import com.shun.pojo.QueryVo;

/**
* @author czs
* @version ����ʱ�䣺2018��3��14�� ����6:45:42 
*/
public interface ItemService {
	
	// ��ѯ���е���Ʒ
	List<Items> selectItemList();
	
	// ��ѯ��Ʒ
	public Items selectItemsById(Integer id);

	void updateitem(Items items);

	// ɾ��һ����Ʒ
	void deletes(Integer[] ids);

	// �޸Ķ����Ʒ��ҳ����װ��QueryVo��list������---ʵ�����ǰ�jspҳ��������鵽�β���
	void updates(QueryVo vo);
}
