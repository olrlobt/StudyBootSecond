package com.iu.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.home.board.BoardFileVO;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class FileManager extends AbstractView {

	@Value("${app.download.base}")
	private String base;
	
	
	public String saveFile(String path,MultipartFile multipartFile) throws Exception{
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
		
		file = new File(file,fileName);
		multipartFile.transferTo(file);
		
		
		return fileName;
			
		
		
	}
	
	//delete
    public boolean deleteFile(String fileName,ServletContext servletContext,String path) throws Exception{
       String realPath = servletContext.getRealPath(path);
       System.out.println(realPath);
       
       File file = new File(realPath, fileName);
       
       return file.delete();
    }

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		log.info("--------------------------------");
		 BoardFileVO boardFileVO = (BoardFileVO)model.get("fileVO");
		 String path = (String)model.get("path");
		 
		 log.info("FILEVO {} ", boardFileVO);
		 
		 File file = new File(base+path, boardFileVO.getFileName());
		 
		 //한글 처리
		 response.setCharacterEncoding("UTF-8");
		 
		 //총 파일의 크기
		 response.setContentLengthLong(file.length());
		 
		 //다운로드시 파일의 이름을 인코딩
		 String oriName = URLEncoder.encode(boardFileVO.getOriName(), "UTF-8");
		 
		 //header 설정
		 response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		 response.setHeader("Content-Transfer-Encoding", "binary");
		 
		 //HDD에서 파일을 읽고
		 FileInputStream fi = new FileInputStream(file);
		 //Client 로 전송 준비
		 OutputStream os = response.getOutputStream();
		 
		 //전송
		 FileCopyUtils.copy(fi, os);
		 
		 //자원 해제
		 os.close();
		 fi.close();
			
		
	}
	
	
	
	
}
