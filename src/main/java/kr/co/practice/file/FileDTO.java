package kr.co.practice.file;

public class FileDTO {
	// 여러 군데에 사용될 수 있으므로 공통 속성으로 만들고 다른 클래스에서 상속받도록
	private Long fileNum;
	private String fileName;
	private String oriName;
	
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
}
