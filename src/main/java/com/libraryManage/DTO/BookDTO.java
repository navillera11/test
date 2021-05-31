package com.libraryManage.DTO;

import java.io.*;
import java.sql.*;

public class BookDTO {
	private String bookISBN; // 도서 ISBN -- Primary Key
	private String bookTitle; // 도서 제목
	private String bookAuthor; // 도서 저자
	private String bookGenre; // 도서 장르
	private String bookPublisher; // 도서 출판사
	private Blob bookImage; // 도서 이미지
	private int bookCount; // 도서 재고수
	private String bookSummary; // 도서 한줄 줄거리
	private int bookHit; // 대여당한 횟수
	
	public BookDTO(String _bookISBN, String _bookTitle, String _bookAuthor, String _bookGenre, String _bookPublisher,
			Blob _bookImage, int _bookCount, String _bookSummary, int _bookHit) {
		this.bookISBN = _bookISBN;
		this.bookTitle = _bookTitle;
		this.bookAuthor = _bookAuthor;
		this.bookGenre = _bookGenre;
		this.bookPublisher = _bookPublisher;
		this.bookImage = _bookImage;
		this.bookCount = _bookCount;
		this.bookSummary = _bookSummary;
		this.bookHit = _bookHit;
	}
	
	public BookDTO(String _bookISBN, String _bookTitle, String _bookAuthor, String _bookGenre, String _bookPublisher,
			Blob _bookImage, int _bookCount, String _bookSummary) {
		this.bookISBN = _bookISBN;
		this.bookTitle = _bookTitle;
		this.bookAuthor = _bookAuthor;
		this.bookGenre = _bookGenre;
		this.bookPublisher = _bookPublisher;
		this.bookImage = _bookImage;
		this.bookCount = _bookCount;
		this.bookSummary = _bookSummary;
	}
	
	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Blob getBookImage() {
		return bookImage;
	}

	public void setBookImage(Blob bookImage) {
		this.bookImage = bookImage;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	
	///
	public String getBookSummary() {
		return bookSummary;
	}

	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}

	public int getBookHit() {
		return bookHit;
	}

	public void setBookHit(int bookHit) {
		this.bookHit = bookHit;
	}

	@Override
	public String toString() {
		return "BookDTO [bookISBN=" + bookISBN + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookGenre=" + bookGenre + ", bookPublisher=" + bookPublisher + ", bookImage=" + bookImage
				+ ", bookCount=" + bookCount + ", bookSummary=" + bookSummary + ", bookHit=" + bookHit + "]";
	}

//	public String toString() {
//		return "책 번호: " + getBookISBN() + "\t\t책 제목: " + getBookTitle() + "\t\t책 저자: " + getBookAuthor() + "\t\t책 출판사: "
//				+ getBookPublisher() + "\t\t책 권수: " + getBookCount();
//	}
	
	

}
