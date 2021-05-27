package com.libraryManage.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.libraryManage.DAO.*;

@Service
public class BookService {
	private BookDAO bookDAO;

	@Autowired
	public BookService(BookDAO _bookDAO) {
		this.bookDAO = _bookDAO;
	}

	public void addBook() { // 책 추가
//		BookDTO book = bookDAO.selectById(inputBookId);
//
//		if (book != null) { // 일련번호가 존재한다.
//			System.out.println("\n같은 일련번호를 가진 책이 있습니다.\n");
//		} else {
//			BookDTO newBook = new BookDTO(inputBookId, inputBookTitle, inputBookAuthor, inputBookPublisher);
//			bookDAO.insertBook(newBook);
//			System.out.println("\n책 추가 성공\n");
//		}
//
//		bookDAO.showAll();
	}

	public void deleteBook() { // 책 삭제
//		System.out.print("책의 일련번호 : ");
//		String inputBookId = sc.nextLine();
//
//		BookDTO book = bookDAO.selectById(inputBookId);
//
//		if (book == null) {
//			System.out.println("\n삭제할 책이 존재하지 않습니다.\n");
//		} else {
//			bookDAO.deleteBook(book);
//			System.out.println("\n책 삭제 성공\n");
//		}
//
//		bookDAO.showAll();
	}

	public void updateBook() { // 책 수정

	}
}
