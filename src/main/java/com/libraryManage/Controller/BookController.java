package com.libraryManage.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	CheckOutDAO checkOutDAO;

	// 도서 상세 페이지 이동
	@RequestMapping(value = "/book_detail", method = RequestMethod.GET)
	public String book_detail(Model model, @RequestParam String bookISBN) {
		BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);

		model.addAttribute("bookDTO", bookDTO);

		return "book_detail";
	}

	// 도서 대여
	@PostMapping("/book_detail")
	public void book_detail(HttpSession session, @RequestParam String bookISBN, HttpServletResponse response)
			throws Exception {
		try {
			MemberDTO sessionMemberDTO = (MemberDTO) session.getAttribute("loginMemberDTO");

			BookDTO bookDTO = bookDAO.selectByISBN(bookISBN);
			
			if (sessionMemberDTO == null)
				throw new NotLoginException("로그인 먼저 해주세요.");
			else {
				checkOutDAO.insertCheckOut(sessionMemberDTO.getMemberEmail(), bookDTO);

				response.sendRedirect("/member_index");
			}
		} catch (NotLoginException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('로그인 먼저 해주세요.'); location.href='/member/login';</script>");

			out.flush();
		}
	}

	// 도서 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String book_unified_search(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "book_unified_search";
	}
}
