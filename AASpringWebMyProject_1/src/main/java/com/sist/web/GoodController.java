package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
@RequestMapping("goods/")
public class GoodController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("goods_list.do")
	public String good_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map =new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		
		List<GoodsVO> list=service.goodsListData(map);
		int totalpage=service.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "goods/goods_list";
	}
	
	@GetMapping("goods_detail_before.do")
	public String goods_detail_before(String no, HttpServletResponse response
			,RedirectAttributes ra)//fno값이 널값인 경우가 없으니까 int로 받을 수 있다
	//response는 우리가 생성할 수 없다! 그래서 쿠키저장할 때는 필요함
	//인터페이스라서 값 설정을 할 수 없다 -> 무조건 dispatcherservlet에서 받아와야해
	{
		Cookie cookie=new Cookie("spring_"+no,no); //food_는 전에 만든 프로그램에서 사용하고 있어서
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("no",no);
		//Redirect에서만 사용
		return "redirect:goods_detail.do";
	}
	
	//상세보기
	@GetMapping("goods_detail.do")
	public String goods_detail(int no,Model model)
	{
		
		GoodsVO vo = service.goodsDetailData(no);
		
		return "goods/goods_detail";
	}
	
	
}
