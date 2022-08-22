package kr.co.practice.bankaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.practice.bankmembers.BankMembersDTO;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public List<BankAccountDTO> getUserAccountDetail(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.getUserAccountDetail(bankAccountDTO);
	}
	
	public List<BankAccountDTO> getUserAccountDetailJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankAccountDAO.getUserAccountDetailJoin(bankMembersDTO);
	}
	
}
