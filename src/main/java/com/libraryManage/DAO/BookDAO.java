package com.libraryManage.DAO;

import com.libraryManage.DTO.*;

import org.springframework.stereotype.*;
import org.springframework.jdbc.core.*;

import javax.sql.*;
import java.util.*;

@Component
public class BookDAO {

	private BookDTO bookDTO;
	private JdbcTemplate jdbcTemplate;

	public BookDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BookDTO selectByISBN(String inputISBN) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM BOOK WHERE ISBN=?;",
					(rs, rowNum) -> new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
							rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getBlob("IMAGE"), rs.getInt("COUNT")),
					inputISBN);
		} catch (Exception ex) {
			return null;
		}
	}

	public List<BookDTO> showAll() {
		List<BookDTO> result = jdbcTemplate.query("SELECT * FROM BOOK;", (rs, rowNum) -> {
			BookDTO bookDTO = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getBlob("IMAGE"), rs.getInt("COUNT"));
			return bookDTO;
		});
		return result;
	}

	public void insertBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update("INSERT INTO BOOK(ISBN, TITLE, AUTHOR, GENRE, PUBLISHER, IMAGE, COUNT) VALUES('"
				+ bookDTO.getBookISBN() + "', '" + bookDTO.getBookTitle() + "', '" + bookDTO.getBookAuthor() + "', '"
				+ bookDTO.getBookGenre() + "', '" + bookDTO.getBookPublisher() + "', '" + bookDTO.getBookImage()
				+ "', '" + bookDTO.getBookCount() + "');");
	}

	public void deleteBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update("DELETE FROM BOOK WHERE ISBN=" + _bookDTO.getBookISBN() + ";");
	}

	public void updateBook(BookDTO _bookDTO) {
		this.bookDTO = _bookDTO;

		jdbcTemplate.update("UPDATE BOOK SET TITLE='" + bookDTO.getBookTitle() + "', AUTHOR='" + bookDTO.getBookAuthor()
				+ "', GENRE='" + bookDTO.getBookGenre() + "', PUBLISHER='" + bookDTO.getBookPublisher() + "', IMAGE="
				+ bookDTO.getBookImage() + ", COUNT=" + bookDTO.getBookCount() + " WHERE ISBN='"
				+ bookDTO.getBookISBN() + "';");
	}
}
