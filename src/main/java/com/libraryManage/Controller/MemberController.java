package com.libraryManage.Controller;

import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	BookDAO bookDAO;

	@Autowired
	HopeDAO hopeDAO;
	
	@Autowired
	CheckOutDAO checkOutDAO;

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
			else
				throw new NotMatchingException("확인 비밀번호와 맞지 않습니다.");

			if (memberDTO == null) {
				throw new AlreadyExistingException("이미 존재하는 계정입니다.");
			} else {
				System.out.println(memberDTO.toString());

				response.sendRedirect("/member/login");
			}
		} catch (NotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 비밀번호와 맞지 않습니다.'); location.href='/member/register';</script>");

			out.flush();
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 계정입니다.'); location.href='/member/register';</script>");

			out.flush();
		}
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String member_login() {
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
				session.setAttribute("loginMemberName", memberDTO.getMemberName());
				// session.setAttribute("loginMemberDTO", memberDTO);
				return "redirect:/admin_index";
			} else {
				session.setAttribute("loginMemberName", memberDTO.getMemberName());
				session.setAttribute("loginMemberDTO", memberDTO);
				return "redirect:/member_index";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "/";
	}

	@RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
	public String member_forgotPwd() {
		return "member_forgotPwd";
	}

	@PostMapping("/forgotPwd")
	public void member_forgotPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputEmail = request.getParameter("inputEmail");

			MemberDTO memberDTO = memberDAO.selectByEmail(inputEmail);

			if (memberDTO == null) { // 존재하지 않는 계정
				throw new NotExistingException("존재하지 않는 계정입니다.");
			} else { // 계정이 존재한다면 
				StringBuffer newPassword = new StringBuffer();

				Random rand = new Random();

				for (int i = 0; i < 10; i++) {
					int index = rand.nextInt(3);
					switch (index) {
					case 0:
						newPassword.append((char) ((int) (rand.nextInt(26)) + 97));
						break;
					case 1:
						newPassword.append((char) ((int) (rand.nextInt(26)) + 65));
						break;
					case 2:
						newPassword.append((rand.nextInt(10)));
						break;
					}
				}
				memberDTO = memberService.changePassword(memberDTO, newPassword);

				memberService.sendEmail(memberDTO, "forgotPwd");
				
				response.sendRedirect("/member/login");
			}
		} catch (NotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 계정입니다.'); location.href='/member/register';</script>");

			out.flush();
		}
	}

	@GetMapping("/my_page")
	public String member_my_page(Model model){
//		try {
//			MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");
//
//			if (memberDTO == null) {
//				throw new NotExistingException("로그인 먼저 해주세요.");
//			} else {
//
//			}
//			
//			response.sendRedirect("/member/my_page");
//		} catch (NotExistingException ex) {
//			response.setContentType("text/html; charset=UTF-8");
//
//			PrintWriter out = response.getWriter();
//
//			out.println("<script>alert('로그인 먼저 해주세요.'); location.href='/member/login';</script>");
//
//			out.flush();
//		}
		
		List<CheckOutDTO> checkOutList = checkOutDAO.showAll();

		model.addAttribute("checkOutList", checkOutList);
		
		return "member_my_page";
	}
	

	
	@GetMapping("/logout")
	public String member_logout(final HttpSession session) {
		if (session.getAttribute("loginMemberName") != null)
			session.removeAttribute("loginMemberName");

		session.invalidate();

		return "index";
	}

	// 희망 도서 신청 페이지 이동
	@RequestMapping(value = "/member_hope", method = RequestMethod.GET)
	public String member_hope(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "member_hope";
	}

	// 희망 도서 신청 처리
	@PostMapping(value = "/member_hope")
	public void member_hope(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookLink = request.getParameter("inputBookLink");

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			if (bookDTO == null) { // 도서 없을 때
				HopeDTO hopeDTO = hopeDAO.selectByISBN(inputBookISBN);
				if (hopeDTO == null) { // 희망 도서 신청 내역이 없을 때
					hopeDTO = new HopeDTO(inputBookISBN, inputBookTitle, 1, inputBookLink);
					hopeDAO.insertHope(hopeDTO);

					response.sendRedirect("/member/member_hope");
				} else {
					hopeDAO.updateHope(hopeDTO);

					response.sendRedirect("/member/member_hope");
				}
			} else
				throw new AlreadyExistingException("이미 존재하는 도서입니다.");
		} catch (AlreadyExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 도서입니다.'); location.href='/member/member_hope';</script>");

			out.flush();
		}
	}
}
