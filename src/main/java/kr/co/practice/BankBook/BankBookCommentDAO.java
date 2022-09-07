package kr.co.practice.BankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.practice.util.CommentPager;
import kr.co.practice.util.Pager;

@Repository
public class BankBookCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "kr.co.practice.BankBook.BankBookCommentDAO.";
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setCommentDelete", bankBookCommentDTO);
	}
	
	public Long getCommentListTotalCount(CommentPager commentPager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCommentListTotalCount", commentPager);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getCommentList", commentPager);
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setCommentAdd", bankBookCommentDTO);
	}
	
}
