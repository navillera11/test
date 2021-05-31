package com.libraryManage.Controller;

import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.http.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.Service.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Exception.*;
import com.libraryManage.DAO.*;

@Controller
@RequestMapping(value = "/admin/")
public class AdminController {
//	@Autowired
//	BookService bookService;
//	@Autowired
//	BookDAO bookDAO;

//	// 회원 목록
//	@GetMapping("/member/show")
//	public String admin_member_show() {
//		return "admin_member_show";
//	}
	
	// 희망 도서
	@GetMapping("/member/hope")
	public String admin_member_hope() {
		return "admin_member_hope";
	}
	
	@GetMapping("/book/overdue")
	public String admin_book_overdue() {
		return "admin_book_overdue";
	}

	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("auth") != null)
			session.removeAttribute("auth");

		if (session.getAttribute("memberId") != null)
			session.removeAttribute("memberId");

		return "index";
	}
}
