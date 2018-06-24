package com.shun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* @author czs
* @version 创建时间：2018年3月19日 下午3:32:49 
*/
public class Interceptor2 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
//		System.out.println("2拦截方法前");
		return true;
		// 放不放行取决于这个开关		默认为false
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
//		System.out.println("2拦截方法后");
	}

	@Override
	// Completion：完成
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
//		System.out.println("2画面渲染后");
	}

}
