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
@RequestMapping(value = "/member/*")
public class MemberController {
	@Autowired
	MemberService memService;
	
	@GetMapping("/login")
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
	
	@GetMapping("/register")
	public String member_register() {
		return "member_register";
	}
	
	//@GetMapping("/register_process")
	
	@GetMapping("/forgotPwd")
	public String member_forgotPwd() {
		return "member_forgotPwd";
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
