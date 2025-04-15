package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	/*
	@Insert("INSERT INTO projectMember(userid,username,userpwd, sex,birthday,email,post,addr1,addr2,phone,content) "
			+ "VALUES(#{userid}, #{username},#{userpwd},#{sex},#{birthday},"
			+ "#{email},#{post},#{addr1},#{addr2},#{phone},#{content})")
	public void memberInsert(MemberVO vo);
	
	@Insert("INSERT INTO authority VALUES(#{userid},'ROLE_USER')")
	public void memberAuthorityInsert(String id);
	 */
	
	@Transactional //둘 중 하나가 오류나면 취소
	public void memberInsert(MemberVO vo)
	{
		System.out.println("=====1=======");
		mapper.memberInsert(vo);
		System.out.println("=====2=======");
		mapper.memberAuthorityInsert(vo.getUserid());
		System.out.println("=====3=======");
	}

}
