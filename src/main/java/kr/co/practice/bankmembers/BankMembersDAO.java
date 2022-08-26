package kr.co.practice.bankmembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.practice.bankmembers.BankMembersDAO.";
	
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setAddFile", bankMembersFileDTO);
	}
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDto) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "setJoin", bankMembersDto);
	}
	@Override
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getSearchById", search);
	}
	@Override
	public BankMembersDTO login(BankMembersDTO bankMembersDto) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "login", bankMembersDto);
	}
	@Override
	public BankMembersDTO getDetail(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", bankMembersDTO);
	}
	@Override
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getMyPage", bankMembersDTO);
	}
	
}
