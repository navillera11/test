package com.libraryManage.DTO;

import java.io.*;

public class MemberDTO {
	private String memberEmail; // 사용자 이메일
	private String memberPassword; // 사용자 비밀번호
	private String memberName; // 사용자 이름
	private int memberRank; // 사용자 랭크
	// private List<BookDTO> memBook = new ArrayList<BookDTO>(); // 대여한 도서 리스트

	public MemberDTO(String _memberEmail, String _memberPassword, String _memberName) {
		this.memberEmail = _memberEmail;
		this.memberPassword = _memberPassword;
		this.memberName = _memberName;
	}

	public MemberDTO(String _memberEmail, String _memberPassword, String _memberName, int _memberRank) {
		this.memberEmail = _memberEmail;
		this.memberPassword = _memberPassword;
		this.memberName = _memberName;
		this.memberRank = _memberRank;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(int memberRank) {
		this.memberRank = memberRank;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!memberPassword.equals(oldPassword))
			System.out.println("\n입력 정보를 확인하세요.\n");
		else
			this.memberPassword = newPassword;
	}

	public String toString() {
		return "사용자 이메일: " + getMemberEmail() + "\t\t사용자 비밀번호: " + getMemberPassword() + "\t\t사용자 이름: "
				+ getMemberName();
	}
}
