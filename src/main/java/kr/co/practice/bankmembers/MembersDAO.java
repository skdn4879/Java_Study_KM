package kr.co.practice.bankmembers;

import java.util.List;

public interface MembersDAO {
	
	public BankMembersDTO getJoinIdOverlap(BankMembersDTO bankMembersDto) throws Exception;
	
	//bankMembers 테이블 회원가입
	public int setJoin(BankMembersDTO bankMembersDto) throws Exception;
		
	//검색어를 입력해 아이디(username)를 찾기(검색어를 포함된 애들) abc순으로 정렬
	public List<BankMembersDTO> getSearchById(String search) throws Exception;
		
	public BankMembersDTO login(BankMembersDTO bankMembersDto) throws Exception;
	
	public BankMembersDTO getDetail(BankMembersDTO bankMembersDTO) throws Exception;
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception;

}
