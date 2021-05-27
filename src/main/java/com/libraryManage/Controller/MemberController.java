package com.libraryManage.Controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	@Autowired
	MemberService memberService;

	// 회원가입 페이지 이동
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String member_register() {
		return "member_register";
	}

	// 회원가입 처리
	@PostMapping(value = "/register")
	public String member_register(HttpServletRequest request) {
		try {
			String inputName = request.getParameter("inputName");
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");
			String confirmPassword = request.getParameter("inputPasswordConfirm");

			MemberDTO memberDTO = null;

			if (inputPassword.equals(confirmPassword)) {
				memberDTO = new MemberDTO(inputName, inputEmail, inputPassword);

				String hashedPwd = BCrypt.hashpw(memberDTO.getMemberPassword(), BCrypt.gensalt());
				memberDTO.setMemberPassword(hashedPwd);
			}

			System.out.println(memberDTO.toString());

			memberService.registMember(memberDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "redirect:/member/login";
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String member_login(Model model) {
		return "member_login";
	}
	
	// 로그인 처리
	@PostMapping(value = "/login")
	public String member_login(HttpServletRequest request) {
		try {
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");
			
			MemberDTO memberDTO = memberService.loginMember(inputEmail, inputPassword);
			
			if(memberDTO == null) {
				System.out.println("로그인 에러 in Controller");
			} else if(memberDTO.getMemberEmail().equals("admin")) {
				return "admin_index";
			} else {
				return "user_index";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "redirect:/";
	}

//	@GetMapping("/login")
//	public String member_login(Model model, @CookieValue(value = "storedId", required = false) Cookie storedIdCookie) {
//		String storedId = "";
//		boolean checked = false;
//
//		if (storedIdCookie != null) {
//			storedId = storedIdCookie.getValue();
//			checked = true;
//		}
//
//		model.addAttribute("storedId", storedId);
//		model.addAttribute("checked", checked);
//
//		return "member_login";
//	}

	@GetMapping("/forgotPwd")
	public String member_forgotPwd() {
		return "member_forgotPwd";
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
