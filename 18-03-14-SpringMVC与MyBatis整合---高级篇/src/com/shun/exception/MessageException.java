package com.shun.exception;
/**
* @author czs
* @version ����ʱ�䣺2018��3��18�� ����5:39:24 
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

	// ���췽��
	public MessageException(String msg){
		this.msg = msg;
	}
}
