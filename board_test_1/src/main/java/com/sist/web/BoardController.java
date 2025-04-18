package com.sist.web;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;

public class BoardController {
	
	@GetMapping("board/list.do")
	public String board_list(int groupid)
	{
		return "board/list";
	}
}
