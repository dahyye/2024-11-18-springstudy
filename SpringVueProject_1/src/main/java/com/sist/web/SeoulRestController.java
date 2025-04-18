package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class SeoulRestController {
	@Autowired
	private SeoulDAO sDao;
	
	
	
	@GetMapping("seoul/location_vue.do")
	public ResponseEntity<Map> seoul_location(int page)
	{
		Map map = new HashMap();
		try {
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			map.put("start", start);
			map.put("end", end);
			map.put("table_name", "seoul_location");
			
			List<SeoulVO>list = sDao.seoulListData(map);
			
			int totalpage=sDao.seoulTotalPage(map);
			
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
	
	@GetMapping("seoul/shop_vue.do")
	public ResponseEntity<Map> seoul_shop(int page)
	{
		Map map = new HashMap();
		try {
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			map.put("start", start);
			map.put("end", end);
			map.put("table_name", "seoul_shop");
			
			List<SeoulVO>list = sDao.seoulListData(map);
			
			int totalpage=sDao.seoulTotalPage(map);
			
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
	
	@GetMapping("seoul/location_detail_vue.do")
	public ResponseEntity<Map> location_detail_vue(int no)
	{
		Map map = new HashMap();
		try {
			SeoulVO vo = sDao.seoulLocationDetailData(no);
			String address=vo.getAddress();
			String s=address.substring(0,1);
			int index=address.indexOf("서울");
			if(index>=0)
			{
				String addr1=address.substring(index);
				System.out.println("addr1 : "+addr1);
				String addr2=addr1.trim();
				addr2=addr2.substring(addr2.indexOf(" "));
				System.out.println("addr2 : "+addr2);
				String addr3=addr2.trim();
				
				addr3=addr3.substring(0,addr3.indexOf(" "));
				System.out.println("addr3 : "+addr3);
				
				List<FoodVO> list=sDao.foodRecommandData(addr3);
				map.put("list", list);	
				map.put("count", list.size());
				map.put("vo", vo);
				
			}
			else 
			{
				map.put("count", 0);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//서버에서 오류나면 알려줌
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map>(map,HttpStatus.OK);
	}
	
	
}
