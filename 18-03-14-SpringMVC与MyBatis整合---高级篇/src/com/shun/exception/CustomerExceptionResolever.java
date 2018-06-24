package com.shun.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
* @author czs
* @version ����ʱ�䣺2018��3��18�� ����5:16:42
* �쳣�������Զ����ʵ���� 
*/
public class CustomerExceptionResolever implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,Exception e) {
		// objΪ�����쳣�ĵط�,�����쳣������Service��,����  ����+����+������(�β�)�ַ���
		ModelAndView mav = new ModelAndView();
		// �ж��쳣����
		String exceptionAddress = "�����쳣�ĵط�Ϊ:" + obj;
		if (e instanceof MessageException) {// ���һ������Ԥ���쳣
			String msg = ((MessageException) e).getMsg();
			mav.addObject("error",exceptionAddress+"<br/>Ԥ�ڵĴ���Ϊ:"+msg);
		}else { // ����ʱ�Ҳ�֪�����쳣
			// ���������ʱ�쳣����ȡ�����ջ���Ӷ�ջ�л�ȡ�쳣��Ϣ
			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			e.printStackTrace(s);
			String msg = out.toString();
			mav.addObject("error","δ֪����!" + exceptionAddress+"<br/>������ʾ��Ϣ��"+e.getMessage()+"<br/>"+msg);
		}
		mav.setViewName("error");
		return mav;
	}
}
