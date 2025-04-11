package com.sist.web;

import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	private String[] types= {"","한식","양식","중식","일식"};
	@GetMapping(value="food/list_vue.do", produces ="text/plain;charset=UTF-8")
	public String food_list_vue(int page, int type) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map = new HashMap();
		map.put("type", types[type]);
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list = dao.foodListData(map);
		int totalpage=dao.foodTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map = new HashMap();
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("type", types[type]);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="food/detail_vue.do" , produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int fno) throws Exception
	{
		System.out.println("vue진입");
		FoodVO vo = dao.foodDetailData(fno);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(vo);
		System.out.println("vue완료");
		return json;
	}
	

}
