package kr.co.practice.board.impl;

import java.util.List;
import java.util.Map;

import kr.co.practice.util.Pager;

public interface BoardDAO {
	// Notice와 Qna는 다른 DTO이지만 둘 다 부모인 BoardDTO 타입
	
	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글상세
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//글의 총 개수
	public Long getCount() throws Exception;

}
