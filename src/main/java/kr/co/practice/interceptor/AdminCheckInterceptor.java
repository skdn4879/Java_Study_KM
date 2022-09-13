package kr.co.practice.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.practice.bankmembers.BankMembersDTO;
import kr.co.practice.bankmembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 1. 
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		List<RoleDTO> roleDTOs = bankMembersDTO.getRoleDTOs();
		boolean result = false;
		
		for(RoleDTO roleDTO : roleDTOs) {
			if(roleDTO.getRoleName().equals("admin")) {
				result = true;
				break;
			}
		}
		
		// admin이 아닐 때
		if(!result) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "/");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
	
}
