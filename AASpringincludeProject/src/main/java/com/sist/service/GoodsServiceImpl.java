package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAO dDao;
	
	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return dDao.goodsListData(map);
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.goodsDetailData(no);
	}

	@Override
	public int goodsTotalPage(int pagecount) {
		// TODO Auto-generated method stub
		return dDao.goodsTotalPage(pagecount);
	}

	@Override
	public List<GoodsVO> goodsFindListData(Map map) {
		// TODO Auto-generated method stub
		return dDao.goodsFindListData(map);
	}

	@Override
	public int goodsFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dDao.goodsFindTotalPage(map);
	}
	

}
