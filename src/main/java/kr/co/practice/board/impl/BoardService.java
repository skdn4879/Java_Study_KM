package kr.co.practice.board.impl;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import kr.co.practice.util.Pager;

public interface BoardService {

	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글조회
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//file delete
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception;
	
}
