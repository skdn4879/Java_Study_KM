package kr.co.practice.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	//모든 리스트 얻어오기
		public List<BoardDto> getList(int start) throws Exception{
			return boardDao.getList(start);
		}
		
		//특정 게시글 보기
		public BoardDto getDetail(Integer boardNum) throws Exception{
			return boardDao.getDetail(boardNum);
		}
		
		//게시글 추가
		public int addBoard(BoardDto boardDto) throws Exception{
			return boardDao.addBoard(boardDto);
		}
		
		//게시글 수정
		public int updateBoard(BoardDto boardDto) throws Exception{
			return boardDao.updateBoard(boardDto);
		}
		
		//게시글 삭제
		public int deleteBoard(Integer boardNum) throws Exception{
			return boardDao.deleteBoard(boardNum);
		}
		
		//전체 게시글 개수
		public int getLength() throws Exception{
			return boardDao.getLength();
		}
	
}
