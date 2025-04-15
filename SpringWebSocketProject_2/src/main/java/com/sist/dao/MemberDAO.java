package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	/*
	@Select("SELECT COUNT(*) FROM project_member WHERE id=#{id}")
	  public int memberIdCount(String id);
	   
	  @Select("SELECT id,pwd,name,sex FROM project_member WHERE id=#{id}")
	  public MemberVO memberInfoData(String id);
	 */

	
	public MemberVO memberLogin(String id, String pwd)
	{
		MemberVO vo = new MemberVO();
		int count = mapper.memberIdCount(id);
		//아이디가 있을 떄
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		//아이디가 없을 때
		else
		{
			MemberVO dbvo = mapper.memberInfoData(id);
			if(pwd.equals(dbvo.getPwd()))
			{
				vo.setMsg("OK");
				vo.setId(dbvo.getId());
				vo.setName(dbvo.getName());
				vo.setSex(dbvo.getSex());
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
}
