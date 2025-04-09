package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface FoodMapper {
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit, num "
			+ "FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit, rownum as num "
			+ "FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit "
			+ "FROM project_food ORDER BY fno ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit, num "
			+ "FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit, rownum as num "
			+ "FROM (SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content,hit "
			+ "FROM project_food  WHERE name LIKE '%'||#{fd}||'%' ORDER BY fno ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food WHERE name LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(String fd);
	
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,images,time,parking,content "
			+ "FROM project_food WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
