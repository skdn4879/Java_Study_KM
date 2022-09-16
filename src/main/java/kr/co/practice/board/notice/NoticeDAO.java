package kr.co.practice.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.practice.board.impl.BoardDAO;
import kr.co.practice.board.impl.BoardDTO;
import kr.co.practice.board.impl.BoardFileDTO;
import kr.co.practice.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.practice.board.notice.NoticeDAO.";

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// Pager에 Mapper의 startRow, lastRow에 대응하는 setter가 있으므로 쓸 수 있다.
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
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setFileDelete", boardFileDTO);
	}
	
	@Override
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getFileDetail", boardFileDTO);
	}
	
}
