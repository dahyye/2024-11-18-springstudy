package com.sist.web;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//vue / ajax / react => c출력에 필요한 데이터 전송
@RestController
public class SeoulRestController {
	//필요한 객체 => 데이터베이스 연동 => ~DAO
	@Autowired //private 를 해제하고 값을 넣어준다 -> private를 노출하는 문제가 있다
	private SeoulDAO dao;
	//가급적이면 @Autowired보다는 생성자를 통해서 값을 넣어주는게 좋다.
	
	/*
	public SeoulRestController(SeoulDAO dao)
	{
		this.dao=dao;
	} 
	 */
	private String[] tables= {
			"","seoul_location","seoul_nature","seoul_shop","seoul_food"
	};
	
	private String[] titles= {
			"","서울 명소","서울 자연","서울 쇼핑","서울 음식"
	};
	
	@GetMapping(value="seoul/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String seoul_list_vue(int page, int type) throws Exception
	{
		
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end = (rowSize*page);
		
		Map map=new HashedMap();
		map.put("table_name", tables[type]);
		map.put("start", start);
		map.put("end", end);
		List<SeoulVO> list = dao.seoulListData(map);
		int totalpage=dao.seoulTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("title", titles[type]);
		
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="seoul/detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String seoul_detail(int no,int type) throws Exception
	{
		Map map =new HashMap();
		map.put("no", no);
		map.put("table_name", tables[type]);
		SeoulVO vo = dao.seoulDetailData(map);
		
		String address=vo.getAddress();
		address=address.substring(address.indexOf(" ")+1);
		map=new HashedMap();
		map.put("vo", vo);
		map.put("address", address.trim());
		
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
