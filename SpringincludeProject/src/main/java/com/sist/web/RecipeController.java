package com.sist.web;
import com.sist.vo.*;
import com.sist.service.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //모델클래스를 알려주는 것
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
		
		model.addAttribute("mlist",mlist);
		model.addAttribute("ilist",ilist);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		return "main/main";
	}
}
