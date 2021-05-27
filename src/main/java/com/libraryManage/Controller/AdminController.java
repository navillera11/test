package com.libraryManage.Controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	@Autowired
	MemberService memService;
	
//	@GetMapping("/register")
//	public String member_register() {
//		return "member_register";
//	}
//	
//	@GetMapping("/forgotPwd")
//	public String member_forgotPwd() {
//		return "member_forgotPwd";
//	}
	
	//테스트용
	@GetMapping("/book/add")
	public String admin_book_add() {
		return "admin_book_add";
	}
	
	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if(session.getAttribute("auth") != null)
			session.removeAttribute("auth");
		
		if(session.getAttribute("memberId") != null)
			session.removeAttribute("memberId");
		
		return "index";
	}
}
