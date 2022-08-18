package kr.co.practice.BankBook;

import java.util.List;

public interface BookDAO {
	public int setDelete(BankBookDTO bankBookDTO) throws Exception;
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception;
	
	//BankBook 테이블에 insert
	//BookNum: 현재 시간을 밀리세컨즈로 변환해서 입력
	//BookSale: 1로 입력
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;
	
	//모든 데이터를 조회 최신순으로
	public List<BankBookDTO> getList() throws Exception;
	
	//Sale컬럼 수정
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
}
