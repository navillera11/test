package com.libraryManage.DAO;

import org.springframework.jdbc.core.*;
import java.util.*;
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

	public List<MemberDTO> showAll() {
		// 전체 회원 조회
		List<MemberDTO> result = jdbcTemplate.query("SELECT * FROM MEMBER;", (rs, rowNum) -> {
			MemberDTO memberDTO = new MemberDTO(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getInt("RANK"));
			return memberDTO;
		});
		return result;
	}

	public List<MemberDTO> showBlack() {
		// 블랙리스트 조회
		List<MemberDTO> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE RANK=-1;", (rs, rowNum) -> {
			MemberDTO memberDTO = new MemberDTO(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getInt("RANK"));
			return memberDTO;
		});
		return result;
	}

	public void insertMember(MemberDTO _memberDTO) {
		this.memberDTO = _memberDTO;

		jdbcTemplate.update("INSERT INTO MEMBER(EMAIL, PASSWORD, NAME) VALUES('" + memberDTO.getMemberEmail() + "', '"
				+ memberDTO.getMemberPassword() + "', '" + memberDTO.getMemberName() + "');");
	}

	public void updatePassword(MemberDTO _memberDTO, String newPassword) {
		this.memberDTO = _memberDTO;
		
		jdbcTemplate.update(
				"UPDATE MEMBER SET PASSWORD='" + newPassword + "' WHERE EMAIL='" + memberDTO.getMemberEmail() + "';");
	}

	public void updateRank(MemberDTO memberDTO, int newRank) {
		jdbcTemplate.update("UPDATE MEMBER SET RANK=" + newRank + " WHERE EMAIL='" + memberDTO.getMemberEmail() + "';");
	}

	public void deleteMember(MemberDTO member) {
	}
}