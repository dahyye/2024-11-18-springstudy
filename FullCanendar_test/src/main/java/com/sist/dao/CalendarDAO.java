package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class CalendarDAO {
	@Autowired
	private CalendarMapper mapper;
	
	public List<CalendarVO> calendarList()
	{
		return mapper.calendarList();
	}
	
	public void calendarInsert(CalendarVO vo)
	{
		mapper.calendarInsert(vo);
	}
}
