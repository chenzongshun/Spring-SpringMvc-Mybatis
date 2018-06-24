package com.shun.exception;
/**
* @author czs
* @version 创建时间：2018年3月18日 下午5:39:24 
*/
public class MessageException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// 构造方法
	public MessageException(String msg){
		this.msg = msg;
	}
}
