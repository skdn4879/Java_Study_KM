package kr.co.practice.BankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.practice.BankBook.BankBookDAO.";

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "setDelete", bankBookDTO);
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE + "setUpdate", bankBookDTO);
	}

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setBankBook", bankBookDTO);
	}

	@Override
	public List<BankBookDTO> getList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList");
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", bankBookDTO);
	}
	
}
