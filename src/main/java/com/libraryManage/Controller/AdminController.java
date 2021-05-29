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
	MemberService memberService;

	//도서 추가용
	@GetMapping("/book/add")
	public String admin_book_add() {
		return "admin_book_add";
	}
	
	//도서 삭제용
	@GetMapping("/book/delete")
	public String admin_book_delete() {
		return "admin_book_delete";
	}
	
	//도서 수정용
	@GetMapping("/book/update")
	public String admin_book_update() {
		return "admin_book_update";
	}
	
	//공지사항 추가용
	@GetMapping("/alarm/notice/notice_add")
	public String admin_alarm_notice_add() {
		return "admin_alarm_notice_add";
	}
	
	
	//회원 목록
	@GetMapping("/member/show")
	public String admin_member_show() {
		return "admin_member_show";
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
