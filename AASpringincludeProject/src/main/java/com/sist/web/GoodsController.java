package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.*;
import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.commons.*;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService service;
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model)
	{
		GoodsVO vo = service.goodsDetailData(no);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../goods/detail.jsp");
		return "main/main";
	}
	
	@RequestMapping("goods/find.do")
	public String goods_find(String page,String gd, Model model)
	{
		Map map=CommonsPagination.pageConfig(page, 12);
		if(gd==null)
			gd="가";
		map.put("gd", gd);
		map.put("pagecount", 12);
		List<GoodsVO> list = service.goodsFindListData(map);
		System.out.println("=====상품리스트=====");
		System.out.println(list.size());
		int totalpage=service.goodsFindTotalPage(map);
		int curpage=(int)map.get("curpage");
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		model.addAttribute("main_jsp", "../goods/find.jsp");
		return "main/main";
	}
}
