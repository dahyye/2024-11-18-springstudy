package com.sist.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sist.vo.*;

@Controller
public class BoardController {
	
	@GetMapping("board/list.do")
	public String board_list()
	{
		System.out.println("list.jsp접근");
		return "board/list";
	}
	
	@GetMapping("board/reddit.do")
	public String board_reddit()
	{
		System.out.println("reddit.jsp접근");
		return "board/reddit";
	}
	
	@GetMapping("/images/{filename}")
	public void serveImage(@PathVariable String filename, HttpServletResponse response) throws IOException {
	    File file = new File("c:/download/" + filename);
	    if (file.exists()) {
	        response.setContentType(Files.probeContentType(file.toPath()));
	        StreamUtils.copy(new FileInputStream(file), response.getOutputStream());
	    } else {
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    }
	}
}
