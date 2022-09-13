package kr.co.practice.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.practice.bankmembers.BankMembersDTO;
import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
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
	
	//글 목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		// Pager 클래스가 멤버로 page라는 이름의 변수를 가지므로 page라는 이름의 파라미터가 전달되면
		// dispatcher가 Pager의 setter를 이용해 Pager에 담아서 보내준다.
		
		System.out.println(pager.getPage());
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<BoardDTO> ar = noticeService.getList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//글 조회
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		// Model은 직접 생성 불가, dispatcher servlet에게 요구
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "board/detail";
	}
	
	//글 작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(Model model, HttpSession session) throws Exception {
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		if(bankMembersDTO != null) {
			return "board/add";
		} else {
			return "redirect:../members/login";
		}
		
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		ModelAndView mv = new ModelAndView();
		
		String message = "실패";
		String url = "./list.iu";
		if(result == 1) {
			message = "성공";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		//mv.setViewName("redirect:./list.iu");
		//ModelAndView로도 redirect 가능, 근데 굳이;;;;
		
		return mv;
	}
	
	//글 수정
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./detail.iu?num=" + boardDTO.getNum();
	}	//수정된 detail로 redirect
	
	//글 삭제
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list.iu";
	}

}
