package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
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
	
	public int boardInsertData(BoardVO vo)
	{
		mapper.boardInsertData(vo);
		return mapper.boardCurentNodata();
	}
	
	public List<GroupVO> groupListData()
	{
		return mapper.groupListData();
	}
	
	public void boardFileInsert(FeedFileInfoVO vo)
	{
		mapper.boardFileInsert(vo);
	}
	   
	public List<FeedFileInfoVO> fileListData(int no)
	{
		return mapper.fileListData(no);
	}
}
