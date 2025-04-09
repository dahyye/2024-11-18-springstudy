package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 	요청한 데이터를 JSP로 전송 => EL / JSTL 이용
 	화면 변경이 가능
 	브라우저 연동
 	
 	브라우저 ====================== 오라클
 			연결할 수 있는 프로그램이 없다
 		| NodeJS
 	
 	브라우저 ==== 자바 => 스프링
 					===== 오라클 
 				 |
 				파이썬 => 장고
 				 C# => ASP.Net
 		
 	=> 순수하게 JSP => @Controller
 	=> 자바스크립트 => @RestController
 	   자바 = 자바스크립트 매칭
 	   
 
 */
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class EmpController {
	//DAO를 가지고 온다
	@Autowired
	private EmpDAO dao;
	
	@GetMapping("emp/list.do")
	public String emp_list(Model model)  //jsp로 값을 전송하는 방식 2가지! HttpServletRequest, Model 
	{
		//model => JSP로 데이터 전송 객체
		List<EmpVO> list = dao.empListData();
		
		model.addAttribute("list",list);
		return "emp/list";
	}
	
	@GetMapping("emp/list2.do")
	public String emp_list2()  //jsp로 값을 전송하는 방식 2가지! HttpServletRequest, Model 
	{
		//model => JSP로 데이터 전송 객체
		
		return "emp/list2";
	}
}
