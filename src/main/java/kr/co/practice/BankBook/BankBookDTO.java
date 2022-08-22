package kr.co.practice.BankBook;

import java.util.Calendar;
import java.util.List;

import kr.co.practice.bankaccount.BankAccountDTO;

public class BankBookDTO {
	private Long bookNum = Calendar.getInstance().getTimeInMillis();
	private String bookName;
	private Double bookRate;
	private Integer bookSale = 1;
	private String bookContents;
	private List<BankAccountDTO> bankAccountDTOs;	// BankAccount 1개는 BankBook 1개와 대응, BankBook 1개는 BankAccount n개와 대응
	// BankBook 입장에서는 BankAccount 1대n관계이므로 List 멤버로 표현 가능
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	
}
