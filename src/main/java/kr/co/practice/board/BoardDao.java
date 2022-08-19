package kr.co.practice.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardInterface {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.practice.board.BoardDao.";
	
	@Override
	public List<BoardDto> getList(Integer start) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getList", start);
		
	}

	@Override
	public BoardDto getDetail(Integer boardNum) throws Exception {
		sqlSession.update(NAMESPACE + "getDetailPre", boardNum);
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardNum);
	}

	@Override
	public int addBoard(BoardDto boardDto) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "addBoard", boardDto);
	}

	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		
		return sqlSession.update(NAMESPACE + "updateBoard", boardDto);
	}

	@Override
	public int deleteBoard(Integer boardNum) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "deleteBoard", boardNum);
	}

	@Override
	public int getLength() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getLength");
	}

}
