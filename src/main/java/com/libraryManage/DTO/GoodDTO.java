package com.libraryManage.DTO;

import java.sql.*;

public class GoodDTO {
	private int goodID;
	private String goodISBN;
	private String goodTitle;
	private String goodAuthor;
	private String goodGenre;
	private String goodPublisher;
	private Blob goodImage;
	private String goodContent;

	public GoodDTO(int _goodID, String _goodISBN, String _goodTitle, String _goodAuthor, String _goodGenre,
			String _goodPublisher, Blob _goodImage, String _goodContent) { // 불러올 시
		this.goodID = _goodID;
		this.goodISBN = _goodISBN;
		this.goodTitle = _goodTitle;
		this.goodAuthor = _goodAuthor;
		this.goodGenre = _goodGenre;
		this.goodPublisher = _goodPublisher;
		this.goodImage = null;
		this.goodContent = _goodContent;
	}
	
	public GoodDTO(String _goodISBN, String _goodTitle, String _goodAuthor, String _goodGenre,
			String _goodPublisher, Blob _goodImage, String _goodContent) { // 추가할 시
		this.goodISBN = _goodISBN;
		this.goodTitle = _goodTitle;
		this.goodAuthor = _goodAuthor;
		this.goodGenre = _goodGenre;
		this.goodPublisher = _goodPublisher;
		this.goodImage = null;
		this.goodContent = _goodContent;
	}

	public int getGoodID() {
		return goodID;
	}

	public void setGoodID(int goodID) {
		this.goodID = goodID;
	}

	public String getGoodISBN() {
		return goodISBN;
	}

	public void setGoodISBN(String goodISBN) {
		this.goodISBN = goodISBN;
	}

	public String getGoodTitle() {
		return goodTitle;
	}

	public void setGoodTitle(String goodTitle) {
		this.goodTitle = goodTitle;
	}

	public String getGoodAuthor() {
		return goodAuthor;
	}

	public void setGoodAuthor(String goodAuthor) {
		this.goodAuthor = goodAuthor;
	}

	public String getGoodGenre() {
		return goodGenre;
	}

	public void setGoodGenre(String goodGenre) {
		this.goodGenre = goodGenre;
	}

	public String getGoodPublisher() {
		return goodPublisher;
	}

	public void setGoodPublisher(String goodPublisher) {
		this.goodPublisher = goodPublisher;
	}

	public Blob getGoodImage() {
		return goodImage;
	}

	public void setGoodImage(Blob goodImage) {
		this.goodImage = goodImage;
	}

	public String getGoodContent() {
		return goodContent;
	}

	public void setGoodContent(String goodContent) {
		this.goodContent = goodContent;
	}
}
