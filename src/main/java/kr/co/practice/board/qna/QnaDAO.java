package kr.co.practice.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.practice.board.impl.BoardDAO;
import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardFileDTO;
import kr.co.practice.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.practice.board.qna.QnaDAO.";
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setReplyAdd", qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "setStepUpdate", qnaDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE + "setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setDelete", boardDTO);
	}

	@Override
	public Long getCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getCount", pager);
	}

	@Override
	public int setAddFile(BoardFileDTO boardFileDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setAddFile", boardFileDTO);
	}

}
