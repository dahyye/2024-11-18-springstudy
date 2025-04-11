package com.sist.mapper;

import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface CalendarMapper {

	@Select("SELECT * FROM calendar")
	public List<CalendarVO> calendarList();
	
}
