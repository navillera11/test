package com.libraryManage.DTO;

import java.sql.Date;

public class NoticeDTO {
	private int noticeID; // 공지 아이디 -- Primary Key, Auto_Increment
	private String noticeTitle; // 공지 제목
	private Date noticeDate; // 공지 날짜
	private String noticeContent; // 공지 콘텐츠

	public NoticeDTO(String _noticeTitle, String _noticeContent) {
		this.noticeTitle = _noticeTitle;
		this.noticeDate = new Date(new java.util.Date().getTime());
		this.noticeContent = _noticeContent;
	}

	public int getNoticeID() {
		return noticeID;
	}

	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
}
