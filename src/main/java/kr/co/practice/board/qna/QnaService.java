package kr.co.practice.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardService;
import kr.co.practice.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//공통적인 것이 아니라 QNA의 고유한 메서드이므로 부모에서 선언하지말고 별도로 선언
	public int setReply(QnaDTO qnaDTO) throws Exception {
		
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);	//반환은 QnaDTO이나 그냥 부모타입에 담음
		QnaDTO parent = (QnaDTO)boardDTO;
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		qnaDAO.setStepUpdate(parent);
		qnaDAO.setReplyAdd(qnaDTO);
		
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		System.out.println("Insert 전 : " + boardDTO.getNum());
		int result = qnaDAO.setAdd(boardDTO);
		System.out.println("Insert 후 : " + boardDTO.getNum());
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.setDelete(boardDTO);
	}

}
