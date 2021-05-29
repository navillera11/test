package com.libraryManage.DAO;

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import javax.sql.*;

import com.libraryManage.DTO.*;

@Component
public class MemberDAO {

	private MemberDTO memberDTO;
	private JdbcTemplate jdbcTemplate;

	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public MemberDTO selectByEmail(String inputEmail) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE EMAIL=?;", (rs,
					rowNum) -> new MemberDTO(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME")),
					inputEmail);
		} catch (Exception ex) {
			return null;
		}
	}

	public void insertMember(MemberDTO _memberDTO) {
		this.memberDTO = _memberDTO;

		jdbcTemplate.update("INSERT INTO MEMBER(EMAIL, PASSWORD, NAME) VALUES('" + memberDTO.getMemberEmail() + "', '"
				+ memberDTO.getMemberPassword() + "', '" + memberDTO.getMemberName() + "');");
	}

	public void updateMember(MemberDTO member) {
	}

	public void deleteMember(MemberDTO member) {
	}
}