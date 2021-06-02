package com.libraryManage.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import com.libraryManage.DTO.*;
import java.util.*;

import javax.sql.*;

@Component
public class CommentDAO {
	private CommentDTO commentDTO;
	private JdbcTemplate jdbcTemplate;

	public CommentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<CommentDTO> selectByFBID(String inputFBID) {
		List<CommentDTO> result = jdbcTemplate.query("SELECT * FROM COMMENT WHERE FBID=" + inputFBID + ";",
				(rs, rowNum) -> {
					CommentDTO commentDTO = new CommentDTO(rs.getInt("CID"), rs.getInt("FBID"), rs.getString("EMAIL"),
							rs.getString("CONTENT"));
					return commentDTO;
				});
		return result;
	}

	public int findLatestCID(String inputFBID) {
		try {
			CommentDTO commentDTO = jdbcTemplate.queryForObject(
					"SELECT * FROM COMMENT WHERE FBID=? ORDER BY CID DESC LIMIT 1;",
					(rs, rowNum) -> new CommentDTO(rs.getInt("CID"), rs.getInt("FBID"), rs.getString("EMAIL"),
							rs.getString("CONTENT")),
					inputFBID);
			
			if(commentDTO == null) {
				throw new Exception();
			} else {
				this.commentDTO = commentDTO;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

		return commentDTO.getCommentID();
	}

	public void insertComment(CommentDTO _commentDTO) {
		jdbcTemplate.update("INSERT INTO COMMENT(CID, FBID, EMAIL, CONTENT) VALUES(" + _commentDTO.getCommentID() + ", "
				+ _commentDTO.getCommentBoardID() + ", '" + _commentDTO.getCommentEmail() + "', '"
				+ _commentDTO.getCommentContent() + "');");
	}
}
