package com.libraryManage.DAO;

import java.io.*;
import java.util.*;
import com.libraryManage.DTO.*;

import org.springframework.stereotype.*;

@Component
public class BookDAO implements Serializable {
//	public BookDTO selectById(String bookId) { // 일련번호로 데이터 받아오기
//		return map.get(bookId);
//	}

//	public List<BookDTO> selectByTitle(String bookTitle) { // 책 이름으로 검색
//		List<BookDTO> bookSearched = new ArrayList<BookDTO>();
//
//		for (Map.Entry<String, BookDTO> element : map.entrySet()) {
//			String bookTitleFromMap = element.getValue().getBookTitle(); // 책 제목
//			if (bookTitleFromMap.equals(bookTitle)) {
//				bookSearched.add(element.getValue());
//			}
//		}
//
//		return bookSearched;
//	}

	public void insertBook(BookDTO book) {
		
	}

	public void updateBook(BookDTO book) {
		
	}

	public void deleteBook(BookDTO book) {
	}

//	public void showAll() {
//		System.out.println("책 일련번호\t\t책 제목\t\t책 저자\t\t책 출판사\t\t대여 여부\t\t대여한 사람");
//		System.out.println("---------------------------------------------------------------------------------------");
//
//		for (Map.Entry<String, BookDTO> element : map.entrySet()) {
//			// String bookIdFromMap = element.getKey();
//			BookDTO valueFromMap = element.getValue();
//			System.out.println(valueFromMap.toString());
//		}
//	}
}
