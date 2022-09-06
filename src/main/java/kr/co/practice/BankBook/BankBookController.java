package kr.co.practice.BankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.practice.util.CommentPager;
import kr.co.practice.util.Pager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//----------------------------------------------------------------------
	
	// 1. JSP에 출력하고 결과물을 응답으로 전송
	// 2. JSON을 응답으로 전송(jackson-databind 라이브러리 사용)
	@GetMapping("commentList")
	@ResponseBody
	public List<BankBookCommentDTO> commentList(CommentPager commentPager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BankBookCommentDTO> list = bankBookService.getCommentList(commentPager);
		
		/*mv.addObject("commentList", list);
		mv.setViewName("common/commentList");*/
		
		// json
		// DTO = {}
		// num = 1, {"num" : "1", "bookNum" : "123", "writer" : "lemon"}
		// [{}]
		
		return list;
	}
	
	@PostMapping("commentAdd")
	@ResponseBody	// return되는 데이터를 view로 보내지않고 바로 응답으로 보내는 annotation
	public String commentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		//{"key" : "value"}
		String jsonResult = "{\"result\" : \"" + result + "\"}";
		return jsonResult;
	}
	
	//----------------------------------------------------------------------
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bankbookList", bankBookService.getList());
		mv.setViewName("bankbook/list");
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setBankBook(bankBookDTO);
		
		if(result == 1) {
			System.out.println("통장 등록 완료");
		}
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("bookDetail", bankBookService.getDetail(bankBookDTO));
		mv.setViewName("bankbook/detail");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(Long bookNum) throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(bookNum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("bankBookDTO", bankBookService.getDetail(bankBookDTO));
		mv.setViewName("bankbook/update");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setUpdate(bankBookDTO);
		
		if(result == 1) {
			System.out.println("통장 정보 수정 완료");
		}
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setDelete(bankBookDTO);
		
		if(result == 1) {
			System.out.println("통장 삭제 완료");
		}
		
		return "redirect:./list";
	}

}
