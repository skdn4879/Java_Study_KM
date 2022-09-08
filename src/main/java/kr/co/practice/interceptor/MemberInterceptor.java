package kr.co.practice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member"); //로그인 여부 확인
		
		if(obj != null) {
			System.out.println("로그인 했음");
			return true;
		} else {
			System.out.println("로그인 안했음");
			response.sendRedirect("/members/login"); //로그인 창으로 리다이렉트
			return false;
		}
		
		//return super.preHandle(request, response, handler);
	}
	
}
