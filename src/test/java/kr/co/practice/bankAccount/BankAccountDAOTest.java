package kr.co.practice.bankAccount;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.practice.MyAbstractTest;
import kr.co.practice.bankaccount.BankAccountDAO;
import kr.co.practice.bankaccount.BankAccountDTO;
import kr.co.practice.bankmembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getUserAccountDetailTest() throws Exception {
		BankAccountDTO bankAccountDTO = new BankAccountDTO();
		bankAccountDTO.setUserName("lemon");
		List<BankAccountDTO> ar = bankAccountDAO.getUserAccountDetail(bankAccountDTO);
		
		assertNotEquals(0, ar.size());
		
	}
	
	@Test
	public void getUserAccountDetailJoinTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("lemon");
		List<BankAccountDTO> ar = bankAccountDAO.getUserAccountDetailJoin(bankMembersDTO);
		
		assertNotEquals(0, ar.size());
		
	}

}
