package com.sist.web;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value="food/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		int totalpage=dao.foodTotalPage();
		List<FoodVO> list = dao.foodListData(start, end);
		
		Map map = new HashedMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@GetMapping(value="food/find_vue.do", produces="text/plain;charset=UTF-8")
	public String food_find_vue(int page,String fd) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		Map map = new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		
		int totalpage=dao.foodFindTotalPage(fd);
		List<FoodVO> list = dao.foodFindListData(map);
		
		map = new HashedMap();
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
		
	}
	
	@GetMapping(value="food/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail_vue(int fno) throws Exception
	{
		FoodVO vo = dao.foodDetailData(fno);
		System.out.println(vo.getName());
		Map map = new HashedMap();
		map.put("vo", vo);
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		System.out.println(json);
		return json;

	}
	
}
