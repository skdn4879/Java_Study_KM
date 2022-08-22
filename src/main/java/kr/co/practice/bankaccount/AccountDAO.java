package kr.co.practice.bankaccount;

import java.util.List;

import kr.co.practice.bankmembers.BankMembersDTO;

public interface AccountDAO {

	public List<BankAccountDTO> getUserAccountDetail(BankAccountDTO bankAccountDTO) throws Exception;
	
	public List<BankAccountDTO> getUserAccountDetailJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
}
