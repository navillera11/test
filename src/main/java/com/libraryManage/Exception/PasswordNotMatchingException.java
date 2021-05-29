package com.libraryManage.Exception;

public class PasswordNotMatchingException extends RuntimeException {
	public PasswordNotMatchingException(String message) {
		super(message);
	}
}
