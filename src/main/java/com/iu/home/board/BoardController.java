package com.iu.home.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.Pager;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		
		
		mv.addObject("list",ar);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardVO = boardService.getDetail(boardVO);
		
		
		mv.addObject("list",boardVO);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@GetMapping("add")
	public void addBoard() throws Exception{
		
	
	}
	
	@PostMapping("add")
	public String addBoard(BoardVO boardVO,MultipartFile [] file) throws Exception{
		
		int result = boardService.addBoard(boardVO,file);
		
		
		
		return "redirect:/board/list";
	}
	
}
