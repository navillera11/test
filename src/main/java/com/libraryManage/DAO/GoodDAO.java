package com.libraryManage.DAO;

import com.libraryManage.DTO.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import javax.sql.*;
import java.util.*;

@Component
public class GoodDAO {
	private GoodDTO goodDTO;
	private JdbcTemplate jdbcTemplate;

	public GoodDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public GoodDTO selectByID(int inputID) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM GOOD WHERE ID=?;",
					(rs, rowNum) -> new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
							rs.getString("AUTHOR"), rs.getString("GENRE"), rs.getString("PUBLISHER"),
							rs.getBlob("IMAGE"), rs.getString("CONTENT")),
					inputID);
		} catch (Exception ex) {
			return null;
		}
	}

	public List<GoodDTO> showAll() {
		List<GoodDTO> result = jdbcTemplate.query("SELECT * FROM GOOD;", (rs, rowNum) -> {
			GoodDTO goodDTO = new GoodDTO(rs.getInt("ID"), rs.getString("ISBN"), rs.getString("TITLE"),
					rs.getString("AUTHOR"), rs.getString("GENRE"), rs.getString("PUBLISHER"), rs.getBlob("IMAGE"),
					rs.getString("CONTENT"));
			return goodDTO;
		});
		return result;
	}

	public void insertGood(GoodDTO _goodDTO) {
		this.goodDTO = _goodDTO;

		jdbcTemplate.update("INSERT INTO GOOD(ISBN, TITLE, AUTHOR, GENRE, PUBLISHER, IMAGE, CONTENT) VALUES('"
				+ goodDTO.getGoodISBN() + "', '" + goodDTO.getGoodTitle() + "', '" + goodDTO.getGoodAuthor() + "', '"
				+ goodDTO.getGoodGenre() + "', '" + goodDTO.getGoodPublisher() + "', '" + goodDTO.getGoodImage()
				+ "', '" + goodDTO.getGoodContent() + "');");
	}

	public void deleteGood(GoodDTO _goodDTO) {
		this.goodDTO = _goodDTO;

		jdbcTemplate.update("DELETE FROM GOOD WHERE ID=" + goodDTO.getGoodID() + ";");
	}
}
