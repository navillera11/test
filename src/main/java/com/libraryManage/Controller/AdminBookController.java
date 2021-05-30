package com.libraryManage.Controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Exception.*;
import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/admin/book/*")
public class AdminBookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	// 도서 추가 페이지 이동
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String admin_book_add(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_add";
	}

	// 도서 추가 처리
	@PostMapping(value = "/add")
	public void admin_book_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String inputBookISBN = request.getParameter("inputBookISBN");
			String inputBookGenre = request.getParameter("inputBookGenre");
			String inputBookTitle = request.getParameter("inputBookTitle");
			String inputBookAuthor = request.getParameter("inputBookAuthor");
			String inputBookPublisher = request.getParameter("inputBookPublisher");
			String inputBookCountString = request.getParameter("inputBookCount");

			int inputBookCount;

			if (inputBookISBN.equals("") || inputBookGenre.equals("") || inputBookTitle.equals("")
					|| inputBookAuthor.equals("") || inputBookPublisher.equals(""))
				throw new FillOutInformationException("모든 정보를 입력해주세요.");

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
		} catch (FillOutInformationException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('모든 정보를 입력해주세요.'); location.href='/admin/book/add';</script>");

			out.flush();
		}
	}

	// 도서 삭제 페이지 이동
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String admin_book_delete(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_delete";
	}

	// 도서 삭제 처리
	@PostMapping(value = "/delete")
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

	// 도서 수정 페이지 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String admin_book_update(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "admin_book_update";
	}

	// 도서 수정 처리
	@PostMapping(value = "/update")
	public void admin_book_update(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

			if (inputBookISBN.equals("") || inputBookGenre.equals("") || inputBookTitle.equals("")
					|| inputBookAuthor.equals("") || inputBookPublisher.equals("") || inputBookCountString.equals(""))
				throw new FillOutInformationException("모든 정보를 입력해주세요.");
			else {
				bookDTO = bookService.updateBook(bookDTO);

				if (bookDTO == null)
					throw new BookNotExistingException("수정할 도서가 없습니다.");
				else
					response.sendRedirect("/admin/book/update");
			}
		} catch (FillOutInformationException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('모든 정보를 입력해주세요.'); location.href='/admin/book/update';</script>");

			out.flush();
		} catch (BookNotExistingException ex) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('수정할 도서가 없습니다.'); location.href='/admin/book/update';</script>");

			out.flush();
		}
	}
}
