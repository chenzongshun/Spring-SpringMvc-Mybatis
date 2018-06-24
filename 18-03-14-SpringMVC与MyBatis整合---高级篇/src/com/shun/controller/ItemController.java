package com.shun.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shun.exception.MessageException;
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
	/**
	 * 返回值类型
	 * 1、ModelAndView		这个对象既可以携带数据  返回视图路径			不建议使用  
	 * 2、String（官方企业推荐）	只能返回视图的路径，但是数据没了，解决方法是可以在形参上添加Model或者ModelMap
	 * 						如：model.addAttribute("itemList",list);
	 * 						为什么推荐？因为它符合了解耦的思想，第一种是把视图和数据都整合到一起了
	 *  					而String是将数据和视图分离开来了    属于MVC
	 * 3、void（ajax专用）		ajax请求最合适了     response.getWriter.writer(json);
	 * 
	 * @return
	 */
	public String itemList(HttpServletRequest request) throws MessageException{
		
// 		int i = 1/0; // 故意触发运行时未知的异常
		
		// 从MySql中查询
		List<Items> list = itemService.selectItemList();
		
		// 预知异常的判断
//		if (null == null) { // 故意触发预期的异常
//			throw new MessageException("商品不能为空");
//		}
		
		request.setAttribute("itemList", list);
		
		return "数组List绑定";
	}
	
 
//	// 入门程序-----访问注解的内容将会跳转到下面的mav指向的页面
//	@RequestMapping(value="/item/itemlist.action")
//	public ModelAndView itemList(){
//		// 从MySql中查询
//		List<Items> list = itemService.selectItemList();
//		
//		// 创建ModelAndView，用来存放数据和视图
//		ModelAndView mav = new ModelAndView();
//		
//		// 设置数据到模型
//		mav.addObject("itemList", list);
//		
//		// 使用视图解释器之前
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
//		// 使用视图解释器并且编辑了prefix和suffix之后
//		mav.setViewName("itemList");
//		mav.setViewName("数组List绑定");//测试数组绑定页
//		return mav;
//	}
	
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
	public String updateitem(QueryVo vo,MultipartFile pictureFile){
		// pictureFile的实现类在springmvc中配置
		
		// 由于怕文件名重复，所以UUID重命名一个名字
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		
		// 获取上传文件的后缀
		String filename = pictureFile.getOriginalFilename();
		String houzhui = filename.substring(filename.lastIndexOf("."));
		
		// 获取windows桌面路径
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String desktop = fsv.getHomeDirectory().getPath()+"\\";//这是读取桌面路径的方法
		
		// 计算最新的文件名
		String newFileName = name+houzhui;
		try {
			pictureFile.transferTo(new File(desktop+newFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 更新图片到数据库----其实就只记住文件的名字而已
		vo.getItems().setPic(newFileName);
		
		// 修改
		itemService.updateitem(vo.getItems());
		
		// ctrl shift i
		
		return "redirect:/itemEdit.action?id=" + vo.getItems().getId();
 
//		// 从MySql中查询
//		List<Items> list = itemService.selectItemList();
//		
//		// 创建ModelAndView，用来存放数据和视图
//		ModelAndView mav = new ModelAndView();
//		
//		// 设置数据到模型
//		mav.addObject("itemList", list);
//
//		mav.setViewName("itemList");
//		return mav;
	}
	
	// 修改多个商品，页面组装到QueryVo的list属性中---实际上是绑定jsp页上面的数组到形参中
	@RequestMapping(value="updates.action")
	public String deletes(QueryVo vo , HttpServletRequest request){
		itemService.updates(vo);
		return "redirect:/item/itemlist.action";// 修改之后重定向到显示页
	}
	
	// 测试浏览器与服务器进行json格式的数据交互
	@RequestMapping(value="/json.action")
	public @ResponseBody Items jsonaction(@RequestBody Items item){
		// 使用@ResponseBody以及@RequestBody注解，自动封装浏览器的json数据到pojo
		return item;
	}
	
	// 测试springmvc拦截器-----此方法由拦截器进入-------服务器提交的肯定是GET方式，这里正好来一个筛选
	@RequestMapping(value = "login.action",method=RequestMethod.GET)
	public String login(){
		return "login";//是否真的写对了，如有bug检查这里
	}
	
	// 测试springmvc拦截器-----此方法由登陆页的action位置进入-------form的提交方式为post提交
	@RequestMapping(value = "login.action", method = RequestMethod.POST)
	public String login(String username, HttpSession session) {
		session.setAttribute("username", username);
		return "redirect:item/itemlist.action";
	}
	
}