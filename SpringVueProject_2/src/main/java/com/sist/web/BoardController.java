package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class BoardController {
	@GetMapping("/board/list")
	public String board_list()
	{
		System.out.println("controller");
		return "board/list";
	}
	
	@GetMapping("/board/insert")
	public String board_insert()
	{
		return "board/insert";
	}
	
	@GetMapping("/board/detail")
	public String board_detail()
	{
		return "board/detail";
	}
	
	@GetMapping("/board/update")
	public String board_update()
	{
		return "board/update";
	}
	
	
	@GetMapping("/board/delete")
	public String board_delete()
	{
		return "board/delete";
	}
	
	
}
