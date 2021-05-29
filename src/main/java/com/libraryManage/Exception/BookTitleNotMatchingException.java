package com.libraryManage.Exception;

public class BookTitleNotMatchingException extends RuntimeException {
	public BookTitleNotMatchingException(String message) {
		super(message);
	}
}
