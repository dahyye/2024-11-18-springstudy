package com.sist.mapper;

import com.sist.dao.CalendarDAO;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
public interface CalendarMapper {

	@Select("SELECT * FROM calendar")
	public List<CalendarVO> calendarList();
		
	@Insert("INSERT INTO calendar values(CALENDAR_NO_SEQ.NEXTVAL, #{calendartitle}, #{calendarmemo}, #{calenderstart}, #{calendarend})")
	public void calendarInsert(CalendarVO vo);

}