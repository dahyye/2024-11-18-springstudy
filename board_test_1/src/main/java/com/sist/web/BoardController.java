package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;

@Controller
public class BoardController {
	
	@GetMapping("board/list.do")
	public String board_list()
	{
		System.out.println("list.jsp접근");
		return "board/list";
	}
	
	@GetMapping("board/reddit.do")
	public String board_reddit()
	{
		System.out.println("reddit.jsp접근");
		return "board/reddit";
	}
	
}
