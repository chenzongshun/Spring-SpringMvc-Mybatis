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
* @version 创建时间：2018年3月18日 下午5:16:42
* 异常处理器自定义的实现类 
*/
public class CustomerExceptionResolever implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,Exception e) {
		// obj为发生异常的地方,比如异常产生在Service层,方法  包名+类名+方法名(形参)字符串
		ModelAndView mav = new ModelAndView();
		// 判断异常类型
		String exceptionAddress = "出现异常的地方为:" + obj;
		if (e instanceof MessageException) {// 如果一样就是预期异常
			String msg = ((MessageException) e).getMsg();
			mav.addObject("error",exceptionAddress+"<br/>预期的错误为:"+msg);
		}else { // 运行时我不知道的异常
			// 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			e.printStackTrace(s);
			String msg = out.toString();
			mav.addObject("error","未知错误!" + exceptionAddress+"<br/>错误提示信息："+e.getMessage()+"<br/>"+msg);
		}
		mav.setViewName("error");
		return mav;
	}
}
