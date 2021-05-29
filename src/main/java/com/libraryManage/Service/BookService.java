package com.libraryManage.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;

@Service
public class BookService {
	private BookDAO bookDAO;

	@Autowired
	public BookService(BookDAO _bookDAO) {
		this.bookDAO = _bookDAO;
	}

	public BookDTO addBook(BookDTO _bookDTO) { // 도서 추가
		BookDTO bookDTO = bookDAO.selectByISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) { // 도서 존재하지 않음 --> 추가 진행
			bookDAO.insertBook(_bookDTO);

			return _bookDTO; // 추가한 도서 반환
		} else {
			System.out.println("이미 존재하는 도서입니다.");

			return null;
		}
	}

	public void deleteBook(BookDTO _bookDTO) { // 책 삭제
		BookDTO bookDTO = bookDAO.selectByISBN(_bookDTO.getBookISBN());

		if (bookDTO == null) {
			System.out.println("존재하지 않는 도서입니다.");
		} else {
			bookDAO.deleteBook(bookDTO);
		}
	}

	public void updateBook() { // 책 수정

	}
}
