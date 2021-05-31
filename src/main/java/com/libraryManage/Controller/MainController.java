package com.libraryManage.Controller;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.libraryManage.Service.*;

@Controller
public class MainController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	// 관리자 페이지 테스트용
	@GetMapping("/admin_index")
	public String admin_index() {
		return "admin_index";
	}

	// 회원 페이지 테스트용
	@GetMapping("/member_index")
	public String user_index() {
		return "member_index";
	}
	
	// 도서 상세 페이지 테스트용
	@GetMapping("/book_detail")
	public String book_detail() {
		return "book_detail";
	}
	
	// 도서 상세 페이지 테스트용
	@GetMapping("/library_unifiedSearch")
	public String library_unifiedSearch() {
		return "library_unifiedSearch";
	}
}