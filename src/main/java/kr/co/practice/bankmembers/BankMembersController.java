package kr.co.practice.bankmembers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.practice.bankaccount.BankAccountDTO;
import kr.co.practice.bankaccount.BankAccountService;

@Controller
@RequestMapping(value = "/members/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO, HttpSession session) throws Exception {
		
		bankMembersDTO = bankMembersService.login(bankMembersDTO);
		
		session.setAttribute("member", bankMembersDTO);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() {
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		bankMembersDTO.setEmail(bankMembersDTO.getEmail() + "@example.com");
		bankMembersService.setJoin(bankMembersDTO);
		
		return "redirect:./login";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public void search() {
		
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search(String search) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("memberList", bankMembersService.getSearchById(search));
		mv.setViewName("members/list");
		
		return mv;
	}
	
	/*
	 * @RequestMapping(value = "myPage", method = RequestMethod.GET) public
	 * ModelAndView myPage(BankMembersDTO bankMembersDTO, BankAccountDTO
	 * bankAccountDTO) throws Exception { ModelAndView mv = new ModelAndView();
	 * 
	 * mv.addObject("memberDetail", bankMembersService.getDetail(bankMembersDTO));
	 * mv.addObject("memberAccountList",
	 * bankAccountService.getUserAccountDetail(bankAccountDTO));
	 * mv.setViewName("members/myPage");
	 * 
	 * return mv;
	 * 
	 * }
	 */
	
	/*@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public ModelAndView myPage(BankMembersDTO bankMembersDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDetail", bankMembersService.getDetail(bankMembersDTO));
		mv.addObject("memberAccountList", bankAccountService.getUserAccountDetailJoin(bankMembersDTO));
		mv.setViewName("members/myPage");
		
		return mv;
	}*/
	
	/*@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public ModelAndView myPage(BankMembersDTO bankMembersDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
		mv.addObject("map", map);
		mv.setViewName("members/myPage");
		
		return mv;
	}*/
	
	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public ModelAndView myPage(BankMembersDTO bankMembersDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDto", bankMembersService.getMyPage(bankMembersDTO));
		
		mv.setViewName("members/myPage");
		
		return mv;
	}
	
}
