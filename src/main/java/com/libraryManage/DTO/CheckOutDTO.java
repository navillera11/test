package com.libraryManage.DTO;

import java.sql.*;

public class CheckOutDTO {
	private String checkOutISBN;
	private String checkOutTitle;
	private String checkOutEmail;
	private Date checkOutRentalDate;
	private Date checkOutReturnDueDate;

	public CheckOutDTO(String _inputCheckOutISBN, String _inputCheckOutTitle, String _inputCheckOutEmail,
			Date _inputCheckOutRentalDate, Date _inputCheckOutReturnDueDate) {
		this.checkOutISBN = _inputCheckOutISBN;
		this.checkOutTitle = _inputCheckOutTitle;
		this.checkOutEmail = _inputCheckOutEmail;
		this.checkOutRentalDate = _inputCheckOutRentalDate;
		this.checkOutReturnDueDate = _inputCheckOutReturnDueDate;
	}

	public String getCheckOutISBN() {
		return checkOutISBN;
	}

	public void setCheckOutISBN(String checkOutISBN) {
		this.checkOutISBN = checkOutISBN;
	}

	public String getCheckOutTitle() {
		return checkOutTitle;
	}

	public void setCheckOutTitle(String checkOutTitle) {
		this.checkOutTitle = checkOutTitle;
	}

	public String getCheckOutEmail() {
		return checkOutEmail;
	}

	public void setCheckOutEmail(String checkOutEmail) {
		this.checkOutEmail = checkOutEmail;
	}

	public Date getCheckOutRentalDate() {
		return checkOutRentalDate;
	}

	public void setCheckOutRentalDate(Date checkOutRentalDate) {
		this.checkOutRentalDate = checkOutRentalDate;
	}

	public Date getCheckOutReturnDueDate() {
		return checkOutReturnDueDate;
	}

	public void setCheckOutReturnDueDate(Date checkOutReturnDueDate) {
		this.checkOutReturnDueDate = checkOutReturnDueDate;
	}

	@Override
	public String toString() {
		return "CheckOutDTO [checkOutISBN=" + checkOutISBN + ", checkOutTitle=" + checkOutTitle + ", checkOutEmail="
				+ checkOutEmail + ", checkOutRentalDate=" + checkOutRentalDate + ", checkOutReturnDueDate="
				+ checkOutReturnDueDate + "]";
	}
}
