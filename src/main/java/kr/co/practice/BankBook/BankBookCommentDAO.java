package kr.co.practice.BankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.practice.util.Pager;

@Repository
public class BankBookCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "kr.co.practice.BankBook.BankBookCommentDAO.";
	
	public List<BankBookCommentDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList");
	}
	
}
