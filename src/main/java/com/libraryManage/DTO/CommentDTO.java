package com.libraryManage.DTO;

public class CommentDTO {
	private int commentID;
	private int commentBoardID;
	private String commentEmail;
	private String commentContent;

	public CommentDTO(int _commentID, int _commentBoardID, String _commentEmail, String _commentContent) {
		this.commentID = _commentID;
		this.commentBoardID = _commentBoardID;
		this.commentEmail = _commentEmail;
		this.commentContent = _commentContent;
	}

	public CommentDTO(int _commentBoardID, String _commentEmail, String _commentContent) {
		this.commentBoardID = _commentBoardID;
		this.commentEmail = _commentEmail;
		this.commentContent = _commentContent;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public int getCommentBoardID() {
		return commentBoardID;
	}

	public void setCommentBoardID(int commentBoardID) {
		this.commentBoardID = commentBoardID;
	}

	public String getCommentEmail() {
		return commentEmail;
	}

	public void setCommentEmail(String commentEmail) {
		this.commentEmail = commentEmail;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
