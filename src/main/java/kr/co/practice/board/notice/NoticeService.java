package kr.co.practice.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardService;
import kr.co.practice.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	//Service는 DAO에 넣어줄 값에 대한 전처리 작업을 한다.
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount = noticeDAO.getCount();
		pager.getNum(totalCount);
		
//		System.out.println("page : " + page);
//		
//		// 페이지에 10개 lastRow - 9	page * 10
//		//page		startRow		lastRow
//		//1			1				10
//		//2			11				20
//		//3			21				30
//		
//		Long perPage = 10L;	//한 페이지당 보여줄 개수
//		
//		Long lastRow = page * perPage;
//		Long startRow = lastRow - (perPage - 1);
//		// 굳이 앞에 startRow를 계산한다면 (page - 1) * perPage + 1 정도?
//		
//		System.out.println("startRow : " + startRow);
//		System.out.println("lastRow  : " + lastRow);
//		
//		// Map은 인터페이스 직접 생성 불가, Map을 implements한 구현 클래스를 생성
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		// jsp에 페이지번호를 출력 1 - ?
//		// 1. 글의 총 개수
//		// 2. 글의 총 개수를 이용해서 총 페이지 수 구하기
//		Long totalCount = noticeDAO.getCount();
//		Long totalPage = totalCount / perPage;
//		if(totalCount % perPage > 0) {
//			totalPage++;
//		}
//		
//		//3. 글의 총 페이지 수
//		// totalBlock	: 총 블록의 수
//		// perBlock : 한 페이지에 출력할 페이지 번호의 수
//		Long perBlock = 5L;
//		Long totalBlock = totalPage / perBlock;
//		if(totalPage % perBlock > 0) {
//			totalBlock++;
//		}
//		/*
//		 * perPage = 10
//		 * perBlock = 5
//		 * 
//		 * totalCount = 102
//		 * totalPage = 11
//		 * totalBlock = 3
//		 */
//		
//		/**
//		 * 4. page로 현재 Block번호 찾기
//		 * 
//		 * page		curBlock
//		 * 1		1
//		 * 2		1
//		 * 3		1
//		 * 4		1
//		 * 5		1
//		 * 6		2
//		 * 7		2
//		 * ...
//		 * 10		2
//		 * 11		3
//		 * */
//		Long curBlock = (page / perBlock);
//		if(curBlock % perBlock > 0) {
//			curBlock++;
//		}
//		
//		/**
//		 * 5.curBlock으로 시작번호와 끝번호 알아오기
//		 * 
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10
//		 * 3			11			15
//		 * */
//		Long startNum = (curBlock - 1) * perBlock + 1;
//		Long lastNum = curBlock * perBlock;
		
		return noticeDAO.getList(pager);
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
