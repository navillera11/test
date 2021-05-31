package com.libraryManage.DAO;

import javax.sql.*;
import java.util.*;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import com.libraryManage.DTO.*;

@Component
public class CheckOutDAO {
	private CheckOutDTO checkOutDTO;
	private JdbcTemplate jdbcTemplate;

	public CheckOutDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<CheckOutDTO> selectOverDue() {
		// 연체 도서 받아오기
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT WHERE NOW() > RETURN_DUE_DATE;",
				(rs, rowNum) -> {
					CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("EMAIL"),
							rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"));
					return checkOutDTO;
				});
		return result;
	}

	public List<CheckOutDTO> showAll() {
		// 모든 대여 도서 받아오기
		List<CheckOutDTO> result = jdbcTemplate.query("SELECT * FROM CHECKOUT;", (rs, rowNum) -> {
			CheckOutDTO checkOutDTO = new CheckOutDTO(rs.getString("ISBN"), rs.getString("EMAIL"),
					rs.getDate("RENTAL_DATE"), rs.getDate("RETURN_DUE_DATE"));
			return checkOutDTO;
		});
		return result;
	}
}
