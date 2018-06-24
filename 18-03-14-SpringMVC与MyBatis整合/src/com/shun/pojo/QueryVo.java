package com.shun.pojo;

import java.io.Serializable;

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

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
