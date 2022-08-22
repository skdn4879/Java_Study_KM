package kr.co.practice.bankaccount;

import java.util.Date;

import kr.co.practice.BankBook.BankBookDTO;
import kr.co.practice.bankmembers.BankMembersDTO;

public class BankAccountDTO {
	private Long accountNum;
	private String userName;
	private Long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;	// BankAccount 1개는 BankBook 1개와 대응, BankBook 1개는 BankAccount n개와 대응
	// BankAccount 입장에서는 BankBook이 1대1관계이므로 멤버로 표현 가능
	private BankMembersDTO bankMembersDTO;
	
	public BankAccountDTO() {
		super();
	}
	
	public BankAccountDTO(Long accountNum, String userName, Long bookNum, Date accountDate) {
		super();
		this.accountNum = accountNum;
		this.userName = userName;
		this.bookNum = bookNum;
		this.accountDate = accountDate;
	}

	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}

	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}

	public BankMembersDTO getBankMembersDTO() {
		return bankMembersDTO;
	}

	public void setBankMembersDTO(BankMembersDTO bankMembersDTO) {
		this.bankMembersDTO = bankMembersDTO;
	}
	
}
