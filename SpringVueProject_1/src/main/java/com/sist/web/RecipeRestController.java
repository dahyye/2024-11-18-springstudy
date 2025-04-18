package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;

/*
	ResponseEntity
	결과값 / 상태코드 (200,404,400,500) / 헤더값을 모두 프론트로 전송
	에러코드를 자세하게 전송
	
	=> 프론트에서 서버에서 받아온 데이터를 화면에 표시할 때 사용
	   일반웹에서 사용하는 방식 -> 프로미스
	   
	   장점 : 오류를 쉽게 찾아서 수정

 */
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO rDao;
	
	@GetMapping("recipe/list_vue.do")
	//params와 매개변수가 일치해야한다, 만약에 form데이터로 묶어서 보내면 vo를 사용
	public ResponseEntity<Map> recipe_list(int page) 
	{
		//에러 / 정상(status)   =>   실제 데이터 전송
		Map map = new HashMap();
		try {
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			List<RecipeVO>list = rDao.recipeListData(start, end);
			int count=rDao.recipeTotalPage();
			int totalpage=(int)(Math.ceil(count/12.0));
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			//Vue로 전송
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("count", count);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			//
		}				
		return new ResponseEntity<>(map,HttpStatus.OK); 
		//map을 보내는데 정상수행했을 때 보낸다
	}
	
	@GetMapping("recipe/detail_vue.do")
	public ResponseEntity<Map> recipe_detail_vue(int no)
	{
		Map map = new HashMap();
		try { 
			RecipeDetailVO vo = rDao.recipeDetail(no);
			
			List<String> mlist=new ArrayList<String>();
			List<String> ilist=new ArrayList<String>();
			
			String[] datas=vo.getFoodmake().split("\n");
			for(String s:datas)
			{
				StringTokenizer st= new StringTokenizer(s,"^");
				mlist.add(st.nextToken());
				ilist.add(st.nextToken());
				
			}
			
			map.put("vo", vo);
			map.put("ilist", ilist);
			map.put("mlist", mlist);
			
		} catch (Exception e) {
			// TODO: handle exception
			//500error
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
