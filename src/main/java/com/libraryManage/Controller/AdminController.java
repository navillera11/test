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
@RequestMapping(value = "/admin/*")
public class AdminController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	// 도서 추가 페이지 이동
	@RequestMapping(value = "/book/add", method = RequestMethod.GET)
	public String admin_book_add(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_add";
	}

	// 도서 추가 처리
	@PostMapping(value = "/book/add")
	public void admin_book_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookGenre = request.getParameter("inputBookGenre");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookAuthor = request.getParameter("inputBookAuthor");
			String inputBookPublisher = request.getParameter("inputBookPublisher");
			String inputBookCountString = request.getParameter("inputBookCount");

			int inputBookCount;

			if (inputBookCountString.equals(""))
				inputBookCount = 1;
			else
				inputBookCount = Integer.parseInt(inputBookCountString);

			Blob inputBookImage = null;
			// request.getParameter("inputBookImage");

			BookDTO bookDTO = new BookDTO(inputBookISBN, inputBookTitle, inputBookAuthor, inputBookGenre,
					inputBookPublisher, inputBookImage, inputBookCount);

			bookDTO = bookService.addBook(bookDTO);

			if (bookDTO == null) {
				throw new AlreadyExistingBookException("이미 존재하는 도서입니다.");
			} else {
				System.out.println(bookDTO.toString());

				response.sendRedirect("/admin/book/add");
			}
		} catch (AlreadyExistingBookException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('이미 존재하는 도서입니다.'); location.href='/admin/book/add';</script>");

			out.flush();
		}
	}

	// 도서 삭제 페이지 이동
	@RequestMapping(value = "/book/delete", method = RequestMethod.GET)
	public String admin_book_delete(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_delete";
	}

	// 도서 삭제 처리
	@PostMapping(value = "/book/delete")
	public void admin_book_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookTitleConfirm = request.getParameter("inputBookTitleConfirm");

			BookDTO bookDTO = bookDAO.selectByISBN(inputBookISBN);

			if (bookDTO == null)
				throw new BookNotExistingException("존재하지 않는 도서입니다.");
			else {
				if (bookDTO.getBookTitle().equals(inputBookTitle)) {
					if (inputBookTitle.equals(inputBookTitleConfirm)) {
						bookService.deleteBook(bookDTO);
						response.sendRedirect("/admin/book/delete");
					} else
						throw new BookTitleNotMatchingException("확인 제목과 맞지 않습니다.");
				} else
					throw new BookTitleNotExistingException("책의 제목이 맞지 않습니다.");
			}
		} catch (BookTitleNotMatchingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('확인 제목과 맞지 않습니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		} catch (BookNotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('존재하지 않는 도서입니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		} catch (BookTitleNotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('책의 제목이 맞지 않습니다.'); location.href='/admin/book/delete';</script>");

			out.flush();
		}
	}

	// 도서 수정
	@GetMapping("/book/update")
	public String admin_book_update() {
		return "admin_book_update";
	}

	// 공지사항 추가용
	@GetMapping("/alarm/notice/notice_add")
	public String admin_alarm_notice_add() {
		return "admin_alarm_notice_add";
	}
	
	// 공지사항 삭제용
	@GetMapping("/alarm/notice/notice_delete")
	public String admin_alarm_notice_delete() {
		return "admin_alarm_notice_delete";
	}
	
	// 추천도서 추가용
	@GetMapping("/alarm/notice/good_add")
	public String admin_alarm_good_add() {
		return "admin_alarm_good_add";
	}
	
	// 추천도서 삭제용
	@GetMapping("/alarm/notice/good_delete")
	public String admin_alarm_good_delete() {
		return "admin_alarm_good_delete";
	}
	

	// 회원 목록
	@GetMapping("/member/show")
	public String admin_member_show() {
		return "admin_member_show";
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
