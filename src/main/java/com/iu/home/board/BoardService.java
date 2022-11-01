package com.iu.home.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	
	
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
}
