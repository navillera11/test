package com.libraryManage.Exception;

public class BookNotExistingException extends RuntimeException {
	public BookNotExistingException(String message) {
		super(message);
	}
}
