package kr.co.practice.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.practice.bankmembers.BankMembersDTO;

@Repository
public class BankAccountDAO implements AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.practice.bankaccount.BankAccountDAO.";
	@Override
	public List<BankAccountDTO> getUserAccountDetail(BankAccountDTO bankAccountDTO) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getUserAccountDetail", bankAccountDTO);
	}
	@Override
	public List<BankAccountDTO> getUserAccountDetailJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getUserAccountDetailJoin", bankMembersDTO);
	}
	
}
