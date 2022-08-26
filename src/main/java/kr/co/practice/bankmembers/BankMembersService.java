package kr.co.practice.bankmembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.practice.bankaccount.BankAccountDAO;
import kr.co.practice.bankaccount.BankAccountDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Autowired
	private ServletContext servletContext;
	// application 내장객체는 Tomcat이 실행될 때 만들어지므로
	// Service 객체보다 먼저 생성되므로 가져올 수 있다.
	
	//bankMembers 테이블 회원가입
	public int setJoin(BankMembersDTO bankMembersDto, MultipartFile photo) throws Exception {
		
		// 외래키 제약 때문에 먼저 member가 등록되어야함
		int result = bankMembersDAO.setJoin(bankMembersDto);
		
		// 1. HDD에 파일을 저장
		// 파일 저장시에 경로는 Tomcat 기준이 아닌 OS의 기준으로 생각(c드라이브에서 시작)
		// 1) 파일저장 위치 (webapp 아래임)
		//		/resources/upload/member
		// 저장 요청은 OS에게 부탁해야함
		
		// 2) 저장할 폴더의 실제 경로 반환(OS 기준)
		// Tomcat/webapp 아래에 resources/upload/member라는 경로가 있을텐데
		// OS기준 드라이버에서 해당 경로까지의 real 경로를 알려달라
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("RealPath : " + realPath);
		
		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		
		// *** File 첨부가 없을 때 구분
		//if(photo.getSize() != 0) {}
		if(!photo.isEmpty()) {
		
			// 실제 폴더가 존재하지 않으면
			if(!file.exists()) {
				file.mkdirs();
			}
			
			// 4) 중복되지 않는 파일명 생성
			//		-- 시간, java api, ....
			String fileName = UUID.randomUUID().toString();	// java api
			System.out.println(fileName);
			
			//Long time = Calendar.getInstance().getTimeInMillis();	// 시간
			
			// 확장자 처리(.의 인덱스를 찾아서 substring으로 잘라도된다.)
			// ex) fileName_title1.jpg
			fileName = fileName + "_" + photo.getOriginalFilename();
			
			// 5) HDD에 파일 저장
			//	어느 폴더에 어떤 이름으로 저장할 File 객체 생성
			file = new File(file, fileName);
			
			//	1) MultipartFile 클래스의 transferTo 메서드 사용
			photo.transferTo(file);
			
			// 	2) FileCopyUtils 클래스의 copy 메서드 사용
			
			// 2. 저장된 파일 정보를 DB에 저장
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDto.getUserName());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
			
			
		}	// isEmpty 끝
		
		return result;
	}
			
	//검색어를 입력해 아이디(username)를 찾기(검색어를 포함된 애들) abc순으로 정렬
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
		return bankMembersDAO.getSearchById(search);
	}
			
	public BankMembersDTO login(BankMembersDTO bankMembersDto) throws Exception {
		return bankMembersDAO.login(bankMembersDto);
	}
	
	public BankMembersDTO getDetail(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getDetail(bankMembersDTO);
	}
	
	/*public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BankAccountDTO> ar = bankAccountDAO.getUserAccountDetailJoin(bankMembersDTO);
		bankMembersDTO = bankMembersDAO.getDetail(bankMembersDTO);
		map.put("list", ar);
		map.put("dto", bankMembersDTO);
		
		return map;
	}*/
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
}
