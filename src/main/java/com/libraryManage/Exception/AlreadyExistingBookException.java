package com.libraryManage.Exception;

public class AlreadyExistingBookException extends RuntimeException {
	public AlreadyExistingBookException(String message) {
		super(message);
	}
}
