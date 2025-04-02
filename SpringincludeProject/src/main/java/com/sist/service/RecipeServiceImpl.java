package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
/*
 				  @Controller
 	요청 			=== Model === Service ==== DAO
 	JSP(.do) 		  |						|
 					ViewResolver		  리펙토링(가독성좋게 변수명이나 메소드를 바꾸는 것)
 					  |
 					 JSP
 
 
 */
@Service // 여러개의 DAO를 통합 사용
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired 
	RecipeDAO rDao;
	@Autowired 
	RecipeDetailDAO dDao;

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.recipeDetailData(no);
	};

}
