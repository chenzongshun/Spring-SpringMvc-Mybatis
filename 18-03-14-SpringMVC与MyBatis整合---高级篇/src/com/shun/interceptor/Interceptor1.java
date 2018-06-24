package com.shun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author czs
 * @version ����ʱ�䣺2018��3��19�� ����3:32:43
 */
public class Interceptor1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// System.out.println("1���ط���ǰ");

		// ����ύ·���а�����ǰ����½ҳ��ĵ�ַ����ô��ֱ�ӷ��У������У���Ƿ��Ѿ���½��
		if (request.getRequestURI().contains("login.action") != true) {
			HttpSession session = request.getSession();
			if (session.getAttribute("username") == null) {// ���û�е�½
				// �ض��򵽵�½ҳ��
				response.sendRedirect(request.getContextPath() + "/login.action");
				return false;
			}
		}
		return true;// ������ϵĴ���ִ�ж�û������Ļ����Ϳ��Է�����
		// �Ų�����ȡ����������� Ĭ��Ϊfalse
	}

	@Override 
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// System.out.println("1���ط�����");
	}

	@Override
	// Completion�����
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// System.out.println("1������Ⱦ��");
	}

}
