package kr.co.practice.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.co.practice.file.FileDTO;

@Component
public class FileManager {

	//delete
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO) throws Exception {
		String realPath = servletContext.getRealPath(path);
		
		File file = new File(realPath, fileDTO.getFileName());
		
		return file.delete();
	}
	
	
	//add
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartFile) throws Exception{
		
		String realPath = servletContext.getRealPath(path);
		
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + multipartFile.getOriginalFilename();
		
		file = new File(file, fileName);
		
		multipartFile.transferTo(file);
		
		System.out.println(fileName);
		
		return fileName;
		
	}
	
}
