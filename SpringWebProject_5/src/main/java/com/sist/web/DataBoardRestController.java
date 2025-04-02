package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.sist.dao.DataBoardDAO;
import com.sist.dao.FileInfoDAO;
import com.sist.vo.DataBoardVO;
import com.sist.vo.FileInfoVO;

import java.io.File;
import java.util.*;

@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dDao;
	
	@Autowired
	private FileInfoDAO fDao;
	
	@GetMapping(value="databoard/delete_ok.do", produces="text/plain;charset=UTF-8")
	public String databoard_delete_ok(int no,String pwd)
	{
		String result="no";
		String db_pwd=dDao.databoardGetPassword(no);
		List<FileInfoVO> list = fDao.fileListData(no);
		int count=dDao.databoardFileCount(no);
		
		if(db_pwd.equals(pwd))
		{
			result="yes";
			
			if(count>0)
			{
				fDao.fileInfoDelete(no);
				try {
					for(FileInfoVO vo:list)
					{
						File file=new File("c:\\download\\"+vo.getFilename());
						file.delete();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			dDao.databoardDelete(no);
		}
		
		return result;
		
	}
	
	@PostMapping(value="databoard/update_ok.do", produces="text/html;charset=UTF-8")
	public String databoard_update(DataBoardVO vo)
	{
		String js="";
		String db_pwd=dDao.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			dDao.databoardUpdate(vo);
			js="<script>location.href=\"detail.do?no="+vo.getNo()+"\";</script>";
		}
		else
		{
			js="<script> alert(\"비밀번호가 틀립니다!!\"); history.back(); </script>";
		}
		return js;
	}
}
