package kr.co.practice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return이 true면 Controller로 진행
		// return이 false면 Controller로 진행 안 됨
		System.out.println("controller 진입 전");
		//return super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller에서 dispatcher로 나가기 전
		// Controller에서 dispatcher로 return하는 ModelAndView를 매개로 받음
		System.out.println("controller에서 DS 나가기 전");
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
