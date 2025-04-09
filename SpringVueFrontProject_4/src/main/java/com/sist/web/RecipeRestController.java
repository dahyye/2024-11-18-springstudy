package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 
 	Rest API
 	= GET => @GetMapping => select
  	= POST => @PostMapping => insert
 	----------- web 
 	= PUT => @PutMapping => update
 	= DELETE => @DeleteMapping => delete
 
 	restcontroller의 단점 : 화면이동이 어렵다
 					역할 : javascript연동 -> 처리 결과값을 전송
 						  ========== JSON 전송
 						  
 	일반 문자열 => 그냥 전송
 	VO => {} => 자바스크립트의 객체 표현
 	List => []
 	----------------------------- 자동 처리 jackson
 	=> @ResponseBody => @RestController
 	   -------------	---------------
 	   메소드에서 처리		클래스 단위 처리
 	   
 	   스프링 : web파일을 관리하지 않는다 => 서버의 역할만 수행
 	   								  -------------
 	   								  Back-End / Front-End
 	   								  	|			|
 	   								  자바:스프링	  jquery
 	   								  c#:ASP.net	vue
 	   								  파이썬:장고		react
 	   								  NodeJS=php
 						  
 */
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping(value="recipe/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String list_vue(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		
		List<RecipeVO> list = dao.recipeListData(start, end);
		int totalpage=dao.recipeTotalPage();
		
		Map map=new HashedMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		//JSON 변환 => 자바스크립트에서 인식
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@GetMapping(value="recipe/find_vue.do",  produces = "text/plain;charset=UTF-8")
	public String find_vue(int page, String fd) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end = (rowSize*page);

		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		List<RecipeVO> list = dao.recipeFindData(map);
		int totalpage=dao.recipeFindTotalPage(fd);
		
		map=new HashedMap();
		map.put("list", list);
		map.put("fd", fd);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	
	@GetMapping(value="recipe/detail_vue.do",  produces = "text/plain;charset=UTF-8")
	public String recipe_detail_vue(int no) throws Exception
	{
		RecipeDetailVO vo = dao.recipeDetailData(no);
		
		List<String> mlist = new ArrayList<String>();
		List<String> ilist = new ArrayList<String>();
		
		//문장^이미지\n문장^이미지\n문장^이미지\n문장^이미지\n문장^이미지\n
		String[] makes=vo.getFoodmake().split("\n");
		for(String m:makes)
		{
			StringTokenizer st= new StringTokenizer(m,"^");
			mlist.add(st.nextToken());
			ilist.add(st.nextToken());
		}
		
		Map map = new HashedMap();
		map.put("vo", vo);
		map.put("ilist", ilist);
		map.put("mlist", mlist);
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	
}
