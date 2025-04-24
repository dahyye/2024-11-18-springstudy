package com.sist.web;

import java.io.File;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.vo.*;
import com.sist.dao.*;

@RestController
public class BoardRestController {
	@Autowired 
	private BoardDAO dao;
	
	@GetMapping("board/group_vue.do")
	public ResponseEntity<Map> group_list_vue()
	{
		System.out.println("group_vue");
		Map map = new HashedMap();
		try {
			List<GroupVO> list = dao.groupListData();
			map.put("list", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("======== error ========");
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("group_vue 완료");
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("board/feed_vue.do")
	public ResponseEntity<Map> board_list_vue(int group_no)
	{
		System.out.println("feed_vue");
		Map map = new HashedMap();
		try {
			List<BoardVO> list = dao.boardListData(group_no);
			System.out.println(group_no);
			map.put("list", list);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("======== error ========");
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("feed_vue 완료");
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("board/feed_insert.do")
	public ResponseEntity<String> Board_list_vue(@RequestBody BoardVO vo)
	{
		String result="";
		try {
			System.out.println(vo);
			List<MultipartFile> list = vo.getFiles();
			System.out.println("전송된 파일 수: "+list.size());
			System.out.println(list);
			String path="c:\\download\\";
			try {
				if(list.size()==0)
				{
					vo.setFilecount(0);
				}
				else
				{
					vo.setFilecount(list.size());
				}
				int no=dao.boardInsertData(vo);
				System.out.println("입력된 새글의 번호"+no);
				
				FeedFileInfoVO fvo = new FeedFileInfoVO();
				if(list.size()>0)
				{
					for(MultipartFile mf:list)
					{
						String filename=mf.getOriginalFilename();
						File file=new File(path+filename);
						mf.transferTo(file); //업로드
						
						fvo.setFilename(filename);
						fvo.setFilesize(file.length());
						fvo.setNo(no);
						
						dao.boardFileInsert(fvo); 
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			vo.setGroup_no(1);
			vo.setUser_id("hong");
			result="ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	
}
