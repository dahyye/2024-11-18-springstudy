package com.sist.service;
import com.sist.dao.*;
import com.sist.vo.GoodsVO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO gdao;
	@Override
	public List<GoodsVO> goodsListData(Map map) {
		// TODO Auto-generated method stub
		return gdao.goodsListData(map);
	}

	@Override
	public int goodsTotalPage() {
		// TODO Auto-generated method stub
		return gdao.goodsTotalPage();
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		// TODO Auto-generated method stub
		return gdao.goodsDetailData(no);
	}
	
}
