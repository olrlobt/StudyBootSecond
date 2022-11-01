package com.iu.home.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.BoardFileVO;
import com.iu.home.board.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/fileDown/{p}")
	public ModelAndView fileDown(@PathVariable(name= "p")String path, BoardFileVO boardFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		//boardService
		boardFileVO.setFileName("02120c38-b3eb-471e-98e8-1bf321162d7f_interSample.jpg");
		boardFileVO.setOriName("interSample.jpg");
		mv.addObject("fileVO",boardFileVO);
		mv.addObject("path",path);
		mv.setViewName("fileManager");
		
		return mv;
	}
	
}
