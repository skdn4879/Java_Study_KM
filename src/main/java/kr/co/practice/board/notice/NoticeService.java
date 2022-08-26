package kr.co.practice.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardService;
import kr.co.practice.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	//Service는 DAO에 넣어줄 값에 대한 전처리 작업을 한다.
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum(); // 순서 바뀌면 마지막 페이지에서 다음 누르면 결과 이상해짐
		//Pager에 처리하거나 아니면 순서를 중요시하거나
		
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
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		for(MultipartFile mf : files) { // 전달 받은 파일에 접근
			if(mf.getSize() != 0) {	// 파일 객체 안에 값이 존재하면
				// 파일 경로 /resources/upload/notice
				
				// OS 기준 파일 경로
				String realPath = servletContext.getRealPath("resources/upload/notice");
				
				// 경로를 담을 File 객체
				File file = new File(realPath);
				
				if(!file.exists()) {
					file.mkdirs();
				} // 경로 미존재 시 생성
				
				// 중복되지 않는 파일명 처리 및 확장자 처리
				String fileName = UUID.randomUUID().toString();
				fileName = fileName + "_" + mf.getOriginalFilename();
				
				// 실제 저장할 파일 객체
				file = new File(file, fileName);
				
				// 실제 HDD에 저장
				mf.transferTo(file);
				
				System.out.println(fileName);
				
				// 실제 DB 저장
				
				/**
				 * 주말 할일 : Notice, Qna 파일 관련 완성 (DB 테이블 포함, sqldeveloper 참고) + 가능하면 BankBook까지
				 * 파일 업로드 할려면 PK를 받아와야 하는데 어떻게 받아서 넣어줄지 (Qna할 때 했음)
				 * Qna 파일 경로는 /resources/upload/qna
				 * BankMembers, Notice, Qna, Bankbook 다 파일 업로드 필요한데 공통 코드를 어떻게 처리할지
				 * */
				
			}
		}
		
		//return noticeDAO.setAdd(boardDTO);
		return 0;
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
