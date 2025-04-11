package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {
	@Autowired
	private CalendarDAO dao;
	
	@GetMapping("calendar/calendar.do")
	public String getCalendarList(Model model)
	{
		List<CalendarVO> list = dao.calendarList();
		model.addAttribute("list",list);
		return "calendar/calendar";
	}
}
