package com.shun.pojo;

import java.io.Serializable;
import java.util.List;

/**
* @author czs
* @version 创建时间：2018年3月16日 下午6:06:15 
*/
public class QueryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 商品
	private Items items;
	
	// 多个商品
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
