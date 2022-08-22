package kr.co.practice.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.practice.bankaccount.BankAccountDAO;
import kr.co.practice.bankaccount.BankAccountDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	//bankMembers 테이블 회원가입
	public int setJoin(BankMembersDTO bankMembersDto) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDto);
	}
			
	//검색어를 입력해 아이디(username)를 찾기(검색어를 포함된 애들) abc순으로 정렬
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
		return bankMembersDAO.getSearchById(search);
	}
			
	public BankMembersDTO login(BankMembersDTO bankMembersDto) throws Exception {
		return bankMembersDAO.login(bankMembersDto);
	}
	
	public BankMembersDTO getDetail(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getDetail(bankMembersDTO);
	}
	
	/*public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BankAccountDTO> ar = bankAccountDAO.getUserAccountDetailJoin(bankMembersDTO);
		bankMembersDTO = bankMembersDAO.getDetail(bankMembersDTO);
		map.put("list", ar);
		map.put("dto", bankMembersDTO);
		
		return map;
	}*/
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
}
