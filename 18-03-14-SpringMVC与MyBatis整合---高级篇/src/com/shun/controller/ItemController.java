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
	/**
	 * ����ֵ����
	 * 1��ModelAndView		�������ȿ���Я������  ������ͼ·��			������ʹ��  
	 * 2��String���ٷ���ҵ�Ƽ���	ֻ�ܷ�����ͼ��·������������û�ˣ���������ǿ������β������Model����ModelMap
	 * 						�磺model.addAttribute("itemList",list);
	 * 						Ϊʲô�Ƽ�����Ϊ�������˽����˼�룬��һ���ǰ���ͼ�����ݶ����ϵ�һ����
	 *  					��String�ǽ����ݺ���ͼ���뿪����    ����MVC
	 * 3��void��ajaxר�ã�		ajax�����������     response.getWriter.writer(json);
	 * 
	 * @return
	 */
	public String itemList(HttpServletRequest request) throws MessageException{
		
// 		int i = 1/0; // ���ⴥ������ʱδ֪���쳣
		
		// ��MySql�в�ѯ
		List<Items> list = itemService.selectItemList();
		
		// Ԥ֪�쳣���ж�
//		if (null == null) { // ���ⴥ��Ԥ�ڵ��쳣
//			throw new MessageException("��Ʒ����Ϊ��");
//		}
		
		request.setAttribute("itemList", list);
		
		return "����List��";
	}
	
 
//	// ���ų���-----����ע������ݽ�����ת�������mavָ���ҳ��
//	@RequestMapping(value="/item/itemlist.action")
//	public ModelAndView itemList(){
//		// ��MySql�в�ѯ
//		List<Items> list = itemService.selectItemList();
//		
//		// ����ModelAndView������������ݺ���ͼ
//		ModelAndView mav = new ModelAndView();
//		
//		// �������ݵ�ģ��
//		mav.addObject("itemList", list);
//		
//		// ʹ����ͼ������֮ǰ
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
//		// ʹ����ͼ���������ұ༭��prefix��suffix֮��
//		mav.setViewName("itemList");
//		mav.setViewName("����List��");//���������ҳ
//		return mav;
//	}
	
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
	public String updateitem(QueryVo vo,MultipartFile pictureFile){
		// pictureFile��ʵ������springmvc������
		
		// �������ļ����ظ�������UUID������һ������
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		
		// ��ȡ�ϴ��ļ��ĺ�׺
		String filename = pictureFile.getOriginalFilename();
		String houzhui = filename.substring(filename.lastIndexOf("."));
		
		// ��ȡwindows����·��
		FileSystemView fsv = FileSystemView.getFileSystemView();
		String desktop = fsv.getHomeDirectory().getPath()+"\\";//���Ƕ�ȡ����·���ķ���
		
		// �������µ��ļ���
		String newFileName = name+houzhui;
		try {
			pictureFile.transferTo(new File(desktop+newFileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ����ͼƬ�����ݿ�----��ʵ��ֻ��ס�ļ������ֶ���
		vo.getItems().setPic(newFileName);
		
		// �޸�
		itemService.updateitem(vo.getItems());
		
		// ctrl shift i
		
		return "redirect:/itemEdit.action?id=" + vo.getItems().getId();
 
//		// ��MySql�в�ѯ
//		List<Items> list = itemService.selectItemList();
//		
//		// ����ModelAndView������������ݺ���ͼ
//		ModelAndView mav = new ModelAndView();
//		
//		// �������ݵ�ģ��
//		mav.addObject("itemList", list);
//
//		mav.setViewName("itemList");
//		return mav;
	}
	
	// �޸Ķ����Ʒ��ҳ����װ��QueryVo��list������---ʵ�����ǰ�jspҳ��������鵽�β���
	@RequestMapping(value="updates.action")
	public String deletes(QueryVo vo , HttpServletRequest request){
		itemService.updates(vo);
		return "redirect:/item/itemlist.action";// �޸�֮���ض�����ʾҳ
	}
	
	// ��������������������json��ʽ�����ݽ���
	@RequestMapping(value="/json.action")
	public @ResponseBody Items jsonaction(@RequestBody Items item){
		// ʹ��@ResponseBody�Լ�@RequestBodyע�⣬�Զ���װ�������json���ݵ�pojo
		return item;
	}
	
	// ����springmvc������-----�˷���������������-------�������ύ�Ŀ϶���GET��ʽ������������һ��ɸѡ
	@RequestMapping(value = "login.action",method=RequestMethod.GET)
	public String login(){
		return "login";//�Ƿ����д���ˣ�����bug�������
	}
	
	// ����springmvc������-----�˷����ɵ�½ҳ��actionλ�ý���-------form���ύ��ʽΪpost�ύ
	@RequestMapping(value = "login.action", method = RequestMethod.POST)
	public String login(String username, HttpSession session) {
		session.setAttribute("username", username);
		return "redirect:item/itemlist.action";
	}
	
}