package com.sist.mapper;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface GoodsMapper {
	@Select("SELECT no,goods_name, goods_sub, goods_price, goods_poster, num "
			+ "FROM (SELECT no,goods_name, goods_sub, goods_price, goods_poster, rownum as num "
			+ "FROM (SELECT no,goods_name, goods_sub, goods_price, goods_poster FROM goods_all))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Update("UPDATE goods_all SET hit=hit+1 WHERE no=#{no}") //서비스는 출력을 할 때만 들어가
	//update는 바로 dao로 
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
}
