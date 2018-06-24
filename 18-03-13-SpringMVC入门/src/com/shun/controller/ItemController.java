package com.shun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

import com.shun.pojo.Items;

/**
* @author czs
* @version ����ʱ�䣺2018��3��13�� ����10:45:31
* ��Ʒ���� 
*/

@Controller 
// @RequestMapping������ŵ��������url�����û������url����ƥ��
// action�����׺���Բ���д
public class ItemController {
	// ���ų���-----����ע������ݽ�����ת�������mavָ���ҳ��
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		// ����ҳ����Ҫ��ʾ����Ʒ���ݣ���װ�Ǵ����ݿ���ȡ��������
		List<Items> list = new ArrayList<>();
		list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1"));
		list.add(new Items(2, "2��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�2"));
		list.add(new Items(3, "3��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�3"));
		list.add(new Items(4, "4��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�4"));
		list.add(new Items(5, "5��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�5"));
		list.add(new Items(6, "6��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�6"));
		
		// ����ModelAndView������������ݺ���ͼ
		ModelAndView mav = new ModelAndView();
		
		// �������ݵ�ģ��
		mav.addObject("itemList", list);
		
		// ʹ����ͼ������֮ǰ
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		// ʹ����ͼ���������ұ༭��prefix��suffix֮��
		mav.setViewName("itemList");
		return mav;
	}
}
