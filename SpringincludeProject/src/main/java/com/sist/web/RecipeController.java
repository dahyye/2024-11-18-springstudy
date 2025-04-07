package com.sist.web;
import com.sist.vo.*;
import com.sist.commons.CommonsPagination;
import com.sist.dao.RecipeDAO;
import com.sist.service.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
	@Autowired
	private RecipeService service; //자동 주입 (주소값)
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no, Model model) //모델을 결과값을 전송해줄 때
	{
		RecipeDetailVO vo = service.recipeDetailData(no);
		
		String data=vo.getFoodmake();
		String[] makes=data.split("\n"); 
		List<String> mlist=new ArrayList<String>();//만드는법
		List<String> ilist=new ArrayList<String>();//이미지
		
		for(String line:makes)
		{
			StringTokenizer st=new StringTokenizer(line,"^");
			mlist.add(st.nextToken());
			ilist.add(st.nextToken());
		}
		
		System.out.println("model을 home으로 변경!!!!!!!!!!!!!!!!!!!!!!!!!");
		model.addAttribute("mlist",mlist);
		model.addAttribute("ilist",ilist);
		
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		//System.out.println("######################jsp를 안넘겼어#########################");
		return "main/main";

	}
	
	@RequestMapping("recipe/find.do")
	public String recipe_find(String page, String fd, Model model)
	{
		Map map = CommonsPagination.pageConfig(page, 12);
		
		int curpage=(int)map.get("curpage");
		if(fd==null)
			fd="감자";
		map.put("fd", fd);
		List<RecipeVO> list = service.recipeFindData(map);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.recipeFindTotalPage(map);
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("fd",fd);
		model.addAttribute("main_jsp","../recipe/find.jsp");
		return "main/main";
	}
	
	@GetMapping("recipe/chef_list.do")
	public String recipe_chef_list(String page, Model model)
	{
		Map map = CommonsPagination.pageConfig(page, 20);
		int curpage=(int)map.get("curpage");
		List<ChefVO> list = service.chefListData(map);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.chefTotalPage();
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("main_jsp","../recipe/chef_list.jsp");
		return "main/main";
	}
	/*
	 
	 보안
	 => 전송된 데이터 : String / 일반 데이터(int, double..)
	 
	 => VO단위
	 => String[] => checkbox
	 => List => name="a[]"
	 => 내장 객체
	 	=HttpServletRequest
	 	=HttpServletResponse
	 	=HttpSession
	 	=RedirectAttributes
	 
	 */
}
