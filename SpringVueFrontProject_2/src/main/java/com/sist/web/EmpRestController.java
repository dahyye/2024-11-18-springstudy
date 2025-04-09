package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class EmpRestController {
	@Autowired
	private EmpDAO dao;
	
	@GetMapping(value="emp/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String emp_list_vue() throws Exception //jsp로 값을 전송하는 방식 2가지! HttpServletRequest, Model 
	{
		//model => JSP로 데이터 전송 객체
		List<EmpVO> elist = dao.empListData();
		List<deptVO> dlist = dao.deptListData();
		Map map = new HashedMap();
		map.put("emp", elist);
		map.put("dept", dlist);
		//[] 형태로 변경해줘야함 -> JSON
		ObjectMapper mapper  = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
