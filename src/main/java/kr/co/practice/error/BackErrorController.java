package kr.co.practice.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //어떤 곳에서든지 지정된 Exception이 발생하면 처리
public class BackErrorController {

	// ExceptionHandler Method만 모임
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	
}
