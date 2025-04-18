package com.sist.dao;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
	1. 메모리관리 (싱글턴)
	2. 객체 생성 ~ 객체 소명
	3. 필요시마다 객체 주소 요청이 가능(@Autowired)
		=> 클래스 관리자
		   ---- 컴포넌트 => 컴포넌트 여러개 관리 (컨테이너) => 스프링 컨테이너
		MVC => 스프링의 라이브러리  
		  

 */
@Repository
public class 



DAO {

	@Autowired
	private SeoulMapper mapper;
	/*
	@Select("SELECT no,title, poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,titl,poster "
			+ "FROM ${table_name} ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}  ")
	public List<SeoulVO> seoulListData();
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);
	*/
	
	public List<SeoulVO> seoulListData(Map map)
	{
		return mapper.seoulListData(map);
	}
	
	public int seoulTotalPage(Map map)
	{
		return mapper.seoulTotalPage(map);
	}

	public SeoulVO seoulDetailData(Map map)
	{
		return mapper.seoulDetailData(map);
	}
}
