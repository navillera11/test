package com.libraryManage.Controller;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
public class MainController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String member_login(Model model) {
		return "member_login";
	}

	// 로그인 처리
	@PostMapping(value = "/member/login")
	public String member_login(HttpServletRequest request) {
		try {
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");

			MemberDTO memberDTO = memberService.loginMember(inputEmail, inputPassword);

			if (memberDTO == null) {
				System.out.println("로그인 에러 in Controller");
			} else if (memberDTO.getMemberEmail().equals("admin@admin")) {
				return "redirect:/admin_index";
			} else {
				return "redirect:/member_index";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "/";
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
}