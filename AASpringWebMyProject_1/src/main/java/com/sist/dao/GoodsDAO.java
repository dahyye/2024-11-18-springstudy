package com.sist.dao;

import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
import com.sist.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	public GoodsVO goodsDetailData(int no)
	{
		 mapper.hitIncrement(no);
		 return mapper.goodsDetailData(no);
	}

}
