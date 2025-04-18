package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO fDao;
	
	@GetMapping("food/list_vue.do")
	//params와 매개변수가 일치해야한다, 만약에 form데이터로 묶어서 보내면 vo를 사용
	public ResponseEntity<Map> food_list(int page) 
	{
		System.out.println("list_vue");
		Map map = new HashMap();
		try {
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			List<FoodVO>list = fDao.foodListData(start, end);
			
			int count=fDao.foodTotalPage();
			System.out.println("count"+count);
			int totalpage=(int)(Math.ceil(count/12.0));
			System.out.println("totalpage"+totalpage);
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
			map.put("totalpage", totalpage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("####error####");
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			//
		}				
		return new ResponseEntity<>(map,HttpStatus.OK); 
		//map을 보내는데 정상수행했을 때 보낸다
	}
	
	@GetMapping("food/detail_vue.do")
	public ResponseEntity<FoodVO> food_detail_vue(int fno)
	{
		FoodVO vo = new FoodVO();
		try {
			vo=fDao.foodDetail(fno);
			System.out.println(vo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("####error####");
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FoodVO>(vo,HttpStatus.OK);
	}
}
