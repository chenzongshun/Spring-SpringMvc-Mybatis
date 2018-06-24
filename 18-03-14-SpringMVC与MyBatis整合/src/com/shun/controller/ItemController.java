package com.shun.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 
import com.shun.pojo.Items;
import com.shun.pojo.QueryVo;
import com.shun.service.ItemService;

/**
* @author czs
* @version ����ʱ�䣺2018��3��13�� ����10:45:31
* ��Ʒ���� 
*/

@Controller 
// @RequestMapping������ŵ��������url�����û������url����ƥ��
// action�����׺���Բ���д
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// ���ų���-----����ע������ݽ�����ת�������mavָ���ҳ��
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		// ��MySql�в�ѯ
		List<Items> list = itemService.selectItemList();
		
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
	
	// ȥ�޸�ҳ�����id
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		// Servlet����
		String id = request.getParameter("id");
		
		// ��ѯ�����Ʒ
		Items items = itemService.selectItemsById(new Integer(id));
		
		// ����ModelAndView������������ݺ���ͼ
		ModelAndView mav = new ModelAndView();

		// �������ݵ�ģ��
		mav.addObject("item", items);

		// ʹ����ͼ���������ұ༭��prefix��suffix֮��
		mav.setViewName("editItem");
		return mav;
	}
	
	// �ύ�޸�ҳ�����ΪItems��pojo������
	@RequestMapping("/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public ModelAndView updateitem(QueryVo vo){
		
		// �޸�
		itemService.updateitem(vo.getItems());

		// ��MySql�в�ѯ
		List<Items> list = itemService.selectItemList();
		
		// ����ModelAndView������������ݺ���ͼ
		ModelAndView mav = new ModelAndView();
		
		// �������ݵ�ģ��
		mav.addObject("itemList", list);

		mav.setViewName("itemList");
		return mav;
	}
}