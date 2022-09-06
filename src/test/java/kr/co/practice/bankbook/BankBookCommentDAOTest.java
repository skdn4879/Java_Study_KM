package kr.co.practice.bankbook;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.practice.MyAbstractTest;
import kr.co.practice.BankBook.BankBookCommentDAO;
import kr.co.practice.BankBook.BankBookCommentDTO;

public class BankBookCommentDAOTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	/*@Test
	public void setCommentAddTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1660898871272L);
		bankBookCommentDTO.setWriter("lemon");
		bankBookCommentDTO.setContents("junit Test");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}*/
	
}
