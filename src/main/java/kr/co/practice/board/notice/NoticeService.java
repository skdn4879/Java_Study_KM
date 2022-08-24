package kr.co.practice.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {
	
	//Service는 DAO에 넣어줄 값에 대한 전처리 작업을 한다.
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		System.out.println("page : " + page);
		
		// 페이지에 10개 lastRow - 9	page * 10
		//page		startRow		lastRow
		//1			1				10
		//2			11				20
		//3			21				30
		
		Long perPage = 10L;	//한 페이지당 보여줄 개수
		
		Long lastRow = page * perPage;
		Long startRow = lastRow - (perPage - 1);
		// 굳이 앞에 startRow를 계산한다면 (page - 1) * perPage + 1 정도?
		
		System.out.println("startRow : " + startRow);
		System.out.println("lastRow  : " + lastRow);
		
		// Map은 인터페이스 직접 생성 불가, Map을 implements한 구현 클래스를 생성
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		// 글의 개수가 총 80개
		// 총 8페이지 필요함
		// 글의 개수가 총 43개
		// 총 5페이지가 필요함
		
		return noticeDAO.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setDelete(boardDTO);
	}

}
