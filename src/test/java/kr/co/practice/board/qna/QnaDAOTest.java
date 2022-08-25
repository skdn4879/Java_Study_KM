package kr.co.practice.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.practice.MyAbstractTest;
import kr.co.practice.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void setAddTest() throws Exception {
		for(int i = 0; i < 70; i++) {
			 QnaDTO qnaDTO = new QnaDTO();
			 qnaDTO.setTitle("Title" + i);
			 qnaDTO.setWriter("lemon");
			 qnaDTO.setContents("Contents" + i);
			 
			 int result = qnaDAO.setAdd(qnaDTO);
			 
			 if(i % 10 == 0) {
				 Thread.sleep(500);
			 }
		 }
	}
	
	/*@Test
	public void getListTest() throws Exception{
		List<BoardDTO> ar = qnaDAO.getList();
		assertNotEquals(0, ar.size());
	}*/
	
	/*@Test
	public void getDetailTest() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(21L);
		boardDTO = qnaDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO);
	}*/
	
	/*
	 * @Test public void setAddTest() throws Exception{ BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setTitle("Junit Test Qna Title");
	 * boardDTO.setContents("Junit Test Qna Contents"); boardDTO.setWriter("lemon");
	 * 
	 * int result = qnaDAO.setAdd(boardDTO); assertEquals(1, result); }
	 */
	
	/*
	 * @Test public void setUpdateTest() throws Exception { BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setNum(41L);
	 * boardDTO.setTitle("Junit Test Qna Title Updated");
	 * boardDTO.setContents("Junit Test Qna Contents Updated");
	 * 
	 * int result = qnaDAO.setUpdate(boardDTO); assertEquals(1, result); }
	 */
	
	/*
	 * @Test public void setDeleteTest() throws Exception { BoardDTO boardDTO = new
	 * BoardDTO(); boardDTO.setNum(41L);
	 * 
	 * int result = qnaDAO.setDelete(boardDTO); assertEquals(1, result); }
	 */
	
}
