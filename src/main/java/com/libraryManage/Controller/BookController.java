package com.libraryManage.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	// 도서 전체 검색
	@RequestMapping(value = "/book_detail", method = RequestMethod.GET)
	public String book_detail(Model model, @RequestParam String bookISBN) {
		BookDTO bookDTO = bookDAO.selectByISBN(bookISBN); 
		
		model.addAttribute("bookDTO", bookDTO);

		return "book_detail";
	}
//
//	// 도서 상세 페이지
//	@GetMapping("/book_detail")
//	public String book_detail(HttpServletRequest request) {
//		
//	}

	// 도서 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String book_unified_search(Model model) {
		List<BookDTO> bookList = bookDAO.showAll();

		model.addAttribute("bookList", bookList);

		return "book_unified_search";
	}
}
