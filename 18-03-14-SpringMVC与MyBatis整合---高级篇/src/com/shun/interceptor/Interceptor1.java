package com.shun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author czs
 * @version 创建时间：2018年3月19日 下午3:32:43
 */
public class Interceptor1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// System.out.println("1拦截方法前");

		// 如果提交路径中包含了前往登陆页面的地址，那么就直接放行，否则就校验是否已经登陆了
		if (request.getRequestURI().contains("login.action") != true) {
			HttpSession session = request.getSession();
			if (session.getAttribute("username") == null) {// 如果没有登陆
				// 重定向到登陆页面
				response.sendRedirect(request.getContextPath() + "/login.action");
				return false;
			}
		}
		return true;// 如果以上的代码执行都没有问题的话，就可以放行了
		// 放不放行取决于这个开关 默认为false
	}

	@Override 
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// System.out.println("1拦截方法后");
	}

	@Override
	// Completion：完成
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// System.out.println("1画面渲染后");
	}

}
