package com.iu.home.board;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	@Value("${app.upload.board}")
	private String path;
	@Autowired
	private FileManager fileManger;
	
	
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception{
		
		
		return boardMapper.getFileDetail(boardFileVO);
	}
	
	
	public List<BoardVO> getList(Pager pager) throws Exception{
		
		pager.getRowNum();
		pager.getNum(getCount(pager));
		
		return boardMapper.getList(pager);
	}
	
	public Long getCount(Pager pager) throws Exception{
		
		return boardMapper.getCount(pager);
	}
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception{
		return boardMapper.getDetail(boardVO);
	}
	
	public int addBoard(BoardVO boardVO,MultipartFile [] files) throws Exception{
		
		int result = boardMapper.addBoard(boardVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		log.info("=================");
		log.info("================");
		for(MultipartFile f : files) {
			if(!f.isEmpty()) {
				
				BoardFileVO boardFileVO = new BoardFileVO();
				String filName = fileManger.saveFile(path, f);
				boardFileVO.setBoardNum(boardVO.getNum());
				boardFileVO.setOriName(f.getOriginalFilename());
				boardFileVO.setFileName(filName);
				
				boardMapper.addFile(boardFileVO);
				log.info("=================");
				log.info("================");
			}
			
		}
		
		return result;
	}
}
