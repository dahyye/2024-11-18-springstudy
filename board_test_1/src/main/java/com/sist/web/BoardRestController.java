package com.sist.web;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;

@RestController
public class BoardRestController {
	@Autowired 
	private BoardDAO dao;
	
	@GetMapping("board/list_vue.do")
	public ResponseEntity<Map> board_list_vue(int groupid)
	{
		Map map = new HashedMap();
		try {
			List<BoardVO> list = dao.boardListData(groupid);
			map.put("list", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
