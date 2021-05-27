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
public class MemberController {
	@Autowired
	MemberService memService;
	
	@GetMapping("/member/login")
	public String member_login(Model model, @CookieValue(value = "storedId", required = false) Cookie storedIdCookie) {
		String storedId = "";
		boolean checked = false;
		
		if(storedIdCookie != null) {
			storedId = storedIdCookie.getValue();
			checked = true;
		}
		
		model.addAttribute("storedId", storedId);
		model.addAttribute("checked", checked);
		
		return "member_login";
	}
	
	@GetMapping("/member/register")
	public String member_register() {
		return "member_register";
	}
	
	@GetMapping("/member/forgotPwd")
	public String member_forgotPwd() {
		return "member_forgotPwd";
	}
	
	@GetMapping("/member/logout")
	public String member_logout(final HttpSession session) {
		if(session.getAttribute("auth") != null)
			session.removeAttribute("auth");
		
		if(session.getAttribute("memberId") != null)
			session.removeAttribute("memberId");
		
		return "index";
	}
}
