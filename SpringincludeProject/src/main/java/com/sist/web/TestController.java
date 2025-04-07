package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeDetailVO;

@Controller
public class TestController {
	@Autowired
	private RecipeService service; //자동 주입 (주소값)
	@GetMapping("recipe/detail3.do")
	public String recipe_detail3(int no, Model model) //모델을 결과값을 전송해줄 때
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
		System.out.println("######################jsp를 안넘겼어#########################");
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		return "main/main";
	}
}
