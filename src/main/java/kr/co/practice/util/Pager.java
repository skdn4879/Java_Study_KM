package kr.co.practice.util;

public class Pager {
	
	//멤버변수
	/**
	 * 파라미터를 담을 변수
	 * jsp에서 꺼내서 사용할 변수
	 * Mapper에서 꺼내서 사용할 변수
	 * perPage : 한 페이지에 출력할 글의 개수
	 * perBlock : 한 페이지에 출력할 페이지 번호의 개수
	 * */
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	// 아니면 멤버의 초기값으로 넣어주어도된다.
	
	// 이전 블럭의 유무 - 이전 블럭이 있으면 true, 없으면 false
	private boolean pre;
	// 다음 블럭의 유무 - 다음 블럭이 있으면 true, 없으면 false
	private boolean next;
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}	//getter에서 초기화하지 않아도 생성자에서 초기화 가능
	
	// 1. Mapper에서 사용하는 값 계산
	// 안전을 위해 getter를 이용
	public void getRowNum() throws Exception {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	// 2. jsp에서 사용할 값 계산
	// DB테이블마다 개수가 다르므로 하나의 DAO에서만 처리 불가능
	// 따라서 totalCount라는 매개변수를 받는 것으로 처리
	public void getNum(Long totalCount) throws Exception {
		
		// totalCount로 totalPage 구하기
		Long totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() > 0) {
			totalPage++;
		}
		
		//현재 page가 totalPage보다 큰 경우
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		// totalBlock 구하기
		Long totalBlock = totalPage / this.getPerBlock();
		if(totalPage % this.getPerBlock() > 0) {
			totalBlock++;
		}
		
		// curBlock 찾기
		Long curBlock = this.getPage() / this.getPerBlock();
		if(this.getPage() % this.getPerBlock() > 0) {
			curBlock++;
		}
		
		// curBlock을 통해 startNum과 lastNum을 계산
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();
		
		// 현재 블록이 마지막 블록일때 curBlock == totalBlock
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;	// 최종 페이지까지만 하겠다.
		}
		
		// 이전, 다음 블록 유무
		if(curBlock > 1) {
			pre = true;
		}
		
		if(curBlock < totalBlock) {
			next = true;
		}
		
	}
	
	public Long getPage() {
		if(this.page == null || this.page <= 0) {
			this.page = 1L;
		}	//맨 처음엔 파라미터가 넘어오지 않으므로
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}	// 혹시라도 null일 경우를 대비한 안전장치
		
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
