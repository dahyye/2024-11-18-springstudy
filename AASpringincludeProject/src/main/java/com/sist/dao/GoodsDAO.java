package com.sist.dao;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository 
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper; 
	/*
	 @Select("SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, num "
			+ "FROM (SELECT goods_no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, rownum as num "
			+ "FROM (SELECT goods_no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit "
			+ "FROM goods_all "
			+ "WHERE no BETWEEN #{start} AND #{end} ")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT CEIL(COUNT(*)/#{pagecount}) FROM goods_all")
	public int recipeTotalPage(int pagecount);
	
	 */
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	public int goodsTotalPage(int pagecount)
	{
		return mapper.goodsTotalPage(pagecount);
	}
	
	
}
