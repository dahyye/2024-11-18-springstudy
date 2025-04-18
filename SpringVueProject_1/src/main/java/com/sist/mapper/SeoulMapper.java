package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface SeoulMapper {
	@Select("SELECT no, title, poster, num "
			+ "FROM (SELECT no, title, poster, rownum as num "
			+ "FROM (SELECT no, title, poster "
			+ "FROM ${table_name} ORDER BY no ASC)) "
			+ "WHERE no BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);
	
	//인근 맛집
	@Select("SELECT fno,poster,name,rownum "
			+ "FROM (SELECT fno,poster,name "
			+ "FROM project_food "
			+ "WHERE address LIKE '%'||#{address}||'%' "
			+ "ORDER BY hit DESC) "
			+ "WHERE rownum<=8")
	public List<FoodVO> foodRecommandData(String address);
	
	@Select("SELECT * FROM seoul_location WHERE no=#{no}")
	public SeoulVO seoulLocationDetailData(int no);
	
	@Select("SELECT * FROM seoul_shop WHERE no=#{no}")
	public SeoulVO seoulShopDetailData(int no);
}
