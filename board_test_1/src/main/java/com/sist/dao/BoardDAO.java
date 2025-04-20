package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	/*
	 public List<BoardVO> boardListData(int groupno);
	 */
	public List<BoardVO> boardListData(int group_no)
	{
		return mapper.boardListData(group_no);
	}
	
	public void boardInsertData(BoardVO vo)
	{
		mapper.boardInsertData(vo);
	}
}
