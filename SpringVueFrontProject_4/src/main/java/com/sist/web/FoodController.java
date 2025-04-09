package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//화면 변경 => forward => request 전송
//return "폴더 / 파일명"
//sendRedirect => 이미 만들어진 화면으로 다시 이동
//--- request(model) 전송이 불가능 _ok
//return "redirect:list.do"
//리턴형 => void(다운로드), String
/*
 	1. 매칭
 	   사용자 URI 매칭 => 메소드를 찾아서 호출
 	   ------------
 	   @GetMapping(URI)
 	   @PostMapping
 	   -------------- + @RequestMapping
 	  
 	2. 매개변수
 		=> request.getParameter를 처리후에 매개변수에 전송
 		   --------------------
 		   => 사용자 전송한 데이터는 String
 		   => 변환 후 받는 경우
 		   (String page) (int page)
 		   				 ---------- 모든 데이터 값을 가지고 있는 경우
 		   				 
 	
 	1. 사용자 요청값 받기 => 매개변수
 	2. 요청처리 후 JSP로 값 전송
 				------------
 				model.addAttribute()
 		|
 	   DAO
 
 */
@Controller
public class FoodController {
	//스프링에 저장되는 객체를 가지고 온다 => 스프링에서는 지역변수는 제어가 안된다
	//스프링은 전역변수만 제어가 가능하다 => @Autowired
	@GetMapping("food/list.do")
	public String food_list()
	{
		return "food/list";
	}
	
	@GetMapping("food/find.do")
	public String food_find()
	{
		return "food/find";
	}
	

	@GetMapping("food/detail.do")
	public String food_detail()
	{
		return "food/detail";
	}
	
}
