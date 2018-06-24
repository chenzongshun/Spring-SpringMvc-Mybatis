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
* @version 创建时间：2018年3月13日 下午10:45:31
* 商品管理 
*/

@Controller 
// @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
// action这个后缀可以不用写
public class ItemController {
	// 入门程序-----访问注解的内容将会跳转到下面的mav指向的页面
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList(){
		// 创建页面需要显示的商品数据，假装是从数据库中取到的数据
		List<Items> list = new ArrayList<>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		
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
}
