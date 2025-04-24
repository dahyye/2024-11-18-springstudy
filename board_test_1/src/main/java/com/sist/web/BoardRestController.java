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
import org.springframework.web.bind.annotation.RequestParam;
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
			
			for(BoardVO vo : list)
			{
				List<FeedFileInfoVO> fvo = dao.fileListData(vo.getFeed_no());
				List<String> filenames = new ArrayList<String>();
				for(FeedFileInfoVO ffvo : fvo)
				{
					filenames.add(ffvo.getFilename());
				}
				vo.setImages(filenames);	
				/*
				List<String> filenames = fvo.stream()
					    .map(FeedFileInfoVO::getFilename)
					    .collect(Collectors.toList());
				*/
				//stream으로 하면 코드는 간편한데 아직 공부못한부분
			}
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
	public ResponseEntity<String> Board_list_vue(@RequestParam("title") String title,
		    @RequestParam("content") String content,
		    @RequestParam(value = "files", required = false) List<MultipartFile> files)
	{
		String result = "";
		BoardVO vo = new BoardVO();
		try {
			System.out.println("입력된 title은 ="+title);
			System.out.println("입력된 content은 ="+content);
			System.out.println("입력된 files는 ="+files);
			//System.out.println("vo데이터들은 ="+vo);
			//List<MultipartFile> list = vo.getFiles();
			//System.out.println("전송된 파일 수: "+list.size());
			//System.out.println(list);
			int fileCount = (files == null || files.isEmpty()) ? 0 : files.size();
			vo.setTitle(title);
	        vo.setContent(content);
	        vo.setFilecount(fileCount);
	        vo.setGroup_no(1);         // 추후 그룹번호 값으로 교체
	        vo.setUser_id("hong");     // 추후 로그인 값으로 교체
			String path="c:\\download\\";
			try {
				
				int no=dao.boardInsertData(vo);
				System.out.println("입력된 새글의 번호"+no);
				
				FeedFileInfoVO fvo = new FeedFileInfoVO();
				if(files != null && !files.isEmpty())
				{
					for(MultipartFile mf:files)
					{
						String filename=mf.getOriginalFilename();
						File file=new File(path+filename);
						mf.transferTo(file); //업로드
						
						fvo.setFilename(filename);
						fvo.setFilesize(file.length());
						fvo.setFno(no);
						
						dao.boardFileInsert(fvo); 
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			result="ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	
}
