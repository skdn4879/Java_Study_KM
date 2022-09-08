package kr.co.practice.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.practice.bankmembers.BankMembersDTO;
import kr.co.practice.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			return ;
		}	// POST 요청일 경우 아래 코드 진행 안되게
		
		// 로그인 사용자와 DTO의 작성자가 일치하는가?
		
		// 로그인 사용자 정보
		HttpSession session = request.getSession();
		BankMembersDTO member = (BankMembersDTO)session.getAttribute("member");
		
		//DTO
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		
		if(!member.getUserName().equals(boardDTO.getWriter())) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message", "작성자만 수정 가능");
			modelAndView.addObject("result", 0);
			modelAndView.addObject("url", "./list.iu");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
