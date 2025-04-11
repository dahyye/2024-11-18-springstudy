package com.sist.web;

import com.sist.dao.FoodDAO;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodRestController {
	/*
	 
	@PostMapping("food/vue_check2_vue.do")
	public Map vue_check(String ss,String[] f)
	{
		Map map = new HashMap();
		map.put("f", f);
		
		return map;
	}
	*/
	@Autowired
	private FoodDAO dao;
	
	@PostMapping("food/list_vue.do")
	public List<FoodVO> food_list(int page,String fd,String[] ss)
	{
		Map map = new HashMap();
		map.put("fdArr", ss);
		map.put("ss", fd);
		map.put("start", (page*12)-11);
		map.put("end", page*12);
		
		List<FoodVO> list = dao.foodFindData(map);
		return list;
	}
}
