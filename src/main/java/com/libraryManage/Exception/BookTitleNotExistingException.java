package com.libraryManage.Exception;

public class BookTitleNotExistingException extends RuntimeException {
	public BookTitleNotExistingException(String message) {
		super(message);
	}
}
