package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;


public interface RecipeMapper {
	@Select("SELECT no,poster,title,num "
			+ "FROM (SELECT no,poster,title, rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) */no,poster,title "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) ")
	public int recipeTotalPage();
	
	/*
	  <select id="recipeFindData" resultType="com.sist.vo.RecipeVO" parameterType="hashmap">
    SELECT no, poster, title, chef, num
    FROM (SELECT no, poster, title, chef, rownum as num 
    FROM (SELECT no, poster, title, chef
    FROM recipe WHERE title LIKE '%'||#{fd}||'%' 
    	 AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)))
    WHERE num BETWEEN #{start} AND #{end}
 </select>
 
 <select id="recipeFindTotalPage" resultType="int" parameterType="hashmap">
  SELECT CEIL(COUNT(*)/12.0) FROM recipe WHERE REGEXP_LIKE(title,#{fd})
    	 AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
 </select>
	 */
	//메소드명을 보고 찾기 때문에 메소드명을 일치시켜줘야한다
	public List<RecipeVO> recipeFindData(Map map);
	
	public int recipeFindTotalPage(Map map);
	
	/*
	 <select id="chefListData" resultType="com.sist.vo.ChefVO" parameterType="hashmap">
	   SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2, num
	   FROM (SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2, rownum as num
	   FROM (SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2
	   FROM chef ORDER BY no)) 
	   WHERE num BETWEEN #{start} AND #{end}
	 </select>
	 */
	public List<ChefVO> chefListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
	public int chefTotalPage();
	
}
