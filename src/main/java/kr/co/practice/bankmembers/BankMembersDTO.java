package kr.co.practice.bankmembers;

import java.util.List;

import kr.co.practice.bankaccount.BankAccountDTO;

public class BankMembersDTO {
	
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTO;
	
	public BankMembersDTO() {}

	public BankMembersDTO(String userName, String password, String name, String email, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}

	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}

	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}

	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	
}
