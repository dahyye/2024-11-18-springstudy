package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsDAO;
import com.sist.vo.*;

public interface GoodsService {
	
	public List<GoodsVO> goodsListData(Map map);
	public GoodsVO goodsDetailData(int no);
	public int goodsTotalPage(int pagecount);
	
}
