package com.shun.pojo;

import java.io.Serializable;
import java.util.List;

/**
* @author czs
* @version ����ʱ�䣺2018��3��16�� ����6:06:15 
*/
public class QueryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ��Ʒ
	private Items items;
	
	// �����Ʒ
	List<Items> itemsList;

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
