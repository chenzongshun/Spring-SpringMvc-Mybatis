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
* @version 创建时间：2018年3月13日 下午10:45:31
* 商品管理 
*/

@Controller 
// @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
// action这个后缀可以不用写
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// 入门程序-----访问注解的内容将会跳转到下面的mav指向的页面
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		// 从MySql中查询
		List<Items> list = itemService.selectItemList();
		
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView mav = new ModelAndView();
		
		// 设置数据到模型
		mav.addObject("itemList", list);
		
		// 使用视图解释器之前
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		// 使用视图解释器并且编辑了prefix和suffix之后
		mav.setViewName("itemList");
		return mav;
	}
	
	// 去修改页面入参id
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		// Servlet开发
		String id = request.getParameter("id");
		
		// 查询这个商品
		Items items = itemService.selectItemsById(new Integer(id));
		
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView mav = new ModelAndView();

		// 设置数据到模型
		mav.addObject("item", items);

		// 使用视图解释器并且编辑了prefix和suffix之后
		mav.setViewName("editItem");
		return mav;
	}
	
	// 提交修改页面入参为Items（pojo）对象
	@RequestMapping("/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public ModelAndView updateitem(QueryVo vo){
		
		// 修改
		itemService.updateitem(vo.getItems());

		// 从MySql中查询
		List<Items> list = itemService.selectItemList();
		
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView mav = new ModelAndView();
		
		// 设置数据到模型
		mav.addObject("itemList", list);

		mav.setViewName("itemList");
		return mav;
	}
}