package kr.co.practice.bankmembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.practice.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void setJoinTest() throws Exception{
		int result = bankMembersDAO.setJoin(new BankMembersDTO("junit", "junit", "Junit", "junit@test.com", "010-1357-2468"));
		//테스트여도 값은 들어간다.
		assertEquals(1, result);
		//희망한다. 실제값인 result가 예상값인 1과 같길 희망한다.
		//assertEquals(expected. actual)
	}
	
	@Test
	public void loginTest() throws Exception{
		BankMembersDTO bankMembersDTO = bankMembersDAO.login(new BankMembersDTO("1234", "1234", null, null, null));
		assertNull(bankMembersDTO); // null이길 희망
	}
	
	@Test
	public void getSearchByIdTest() throws Exception{
		List<BankMembersDTO> ar = bankMembersDAO.getSearchById("ad");
		
		assertNotEquals(0, ar.size());
	}

}
