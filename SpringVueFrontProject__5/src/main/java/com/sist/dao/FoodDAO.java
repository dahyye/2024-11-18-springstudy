package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	/*
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM project_food WHERE TYPE LIKE '%'||#{type}||'%'))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM project_food "
			+ "WHERE TYPE LIKE '%'||#{type}||'%'")
	public int foodTotalPage(Map map);
	 */
	public List<FoodVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	public int foodTotalPage(Map map)
	{
		return mapper.foodTotalPage(map);
	}
	
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
	
}
