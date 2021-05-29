package com.libraryManage.Controller;

import javax.servlet.http.*;
import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

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
	public void member_register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputName = request.getParameter("inputName");
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");
			String confirmPassword = request.getParameter("inputPasswordConfirm");

			MemberDTO memberDTO = new MemberDTO(inputEmail, inputPassword, inputName);

			if (inputPassword.equals(confirmPassword))
				memberDTO = memberService.registMember(memberDTO);
			else {
				throw new PasswordNotMatchingException("확인 비밀번호와 맞지 않습니다.");
			}

			if (memberDTO == null) {
				throw new AlreadyExistingMemberException("이미 존재하는 계정입니다.");
			} else {
				System.out.println(memberDTO.toString());
				
				response.sendRedirect("/member/login");
			}
		} catch (PasswordNotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 비밀번호와 맞지 않습니다.'); location.href='/member/register';</script>");

			out.flush();
		} catch (AlreadyExistingMemberException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 계정입니다.'); location.href='/member/register';</script>");
			
			out.flush();
		}
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
			HttpSession session = request.getSession(true);

			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");

			MemberDTO memberDTO = memberService.loginMember(inputEmail, inputPassword);

			if (memberDTO == null) {
				System.out.println("로그인 에러 in Controller");
			} else if (memberDTO.getMemberEmail().equals("admin@admin")) {
				session.setAttribute("loginAdmin", memberDTO);
				return "redirect:/admin_index";
			} else {
				session.setAttribute("loginMember", memberDTO);
				return "redirect:/member_index";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "/";
	}

	@GetMapping("/forgotPwd")
	public String member_forgotPwd() {
		return "member_forgotPwd";
	}

	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("loginAdmin") != null)
			session.removeAttribute("loginAdmin");

		if (session.getAttribute("loginMember") != null)
			session.removeAttribute("loginMember");

		return "index";
	}
}
