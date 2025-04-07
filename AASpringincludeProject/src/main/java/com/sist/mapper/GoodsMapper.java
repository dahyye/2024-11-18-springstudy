package com.sist.mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import java.util.*;
public interface GoodsMapper {
	@Select("SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, num "
			+ "FROM (SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, rownum as num "
			+ "FROM (SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit "
			+ "FROM goods_all))"
			+ "WHERE no BETWEEN #{start} AND #{end} ")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT CEIL(COUNT(*)/#{pagecount}) FROM goods_all")
	public int goodsTotalPage(int pagecount);
	
	@Select("SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, num "
			+ "FROM (SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit, rownum as num "
			+ "FROM (SELECT no, goods_name, goods_sub, goods_price, goods_discount, goods_first_price, goods_delivery, goods_poster, hit "
			+ "FROM goods_all WHERE goods_name LIKE '%'||#{gd}||'%')) "
			+ "WHERE no BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/#{pagecount}) FROM goods_all WHERE goods_name LIKE '%'||#{gd}||'%'")
	public int goodsFindTotalPage(Map map);
	
}
