package kr.co.practice.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.practice.MyAbstractTest;
import kr.co.practice.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception {
		assertNotEquals(0, noticeDAO.getList().size());
	}
	
	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(1L);
		assertNotNull(noticeDAO.getDetail(boardDTO));
	}
	
	/*
	 * @Test public void setAddTest() throws Exception { BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setTitle("JUnit Test Title");
	 * boardDTO.setContents("JUnit Test Contents"); boardDTO.setWriter("lemon");
	 * 
	 * int result = noticeDAO.setAdd(boardDTO); assertEquals(1, result); }
	 */
	
	/*
	 * @Test public void setUpdateTest() throws Exception { BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setNum(2L);
	 * boardDTO.setTitle("JUnit Test Title Updated");
	 * boardDTO.setContents("JUnit Test Contents Updated");
	 * 
	 * int result = noticeDAO.setUpdate(boardDTO); assertEquals(1, result);
	 * 
	 * }
	 */

	/*
	 * @Test public void setDeleteTest() throws Exception{ BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setNum(2L);
	 * 
	 * int result = noticeDAO.setDelete(boardDTO); assertEquals(1, result);
	 * 
	 * }
	 */
	
}
