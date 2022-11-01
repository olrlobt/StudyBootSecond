package com.iu.home.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void insertBoardTest() throws Exception {
		
		for(int i=30; i<60; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title "+i);
			boardVO.setWriter("writer "+i);
			boardVO.setContents("contents "+i);
			
			boardMapper.addBoard(boardVO);
		}
	}
}
