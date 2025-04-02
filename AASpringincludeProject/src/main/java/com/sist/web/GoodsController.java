package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
