package com.libraryManage.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute(session.getId());

		if (userId != null) {
			if(userId.equals("admin"))
				return "admin_index";
			else
				return "user_index";
		}

		return "index";
	}
	
	// 관리자 페이지 테스트용
	@GetMapping("/admin_index")
	public String admin_index() {
		return "admin_index";
	}
}