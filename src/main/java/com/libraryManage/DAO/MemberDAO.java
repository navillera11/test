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

	public void insertMember(MemberDTO _memberDTO) {
		this.memberDTO = _memberDTO;

		jdbcTemplate.update("INSERT INTO MEMBER(EMAIL, PASSWORD, NAME) VALUES('" + memberDTO.getMemberEmail() + "', '"
				+ memberDTO.getMemberPassword() + "', '" + memberDTO.getMemberName() + "');");
	}

	public void updateMember(MemberDTO member) {
		// map.replace(member.getMemEmail(), member);
	}

	public void deleteMember(MemberDTO member) {
		// map.remove(member.getMemEmail());
	}

//	public void showAll() {
//		System.out.println("사용자 이메일\t\t사용자 비밀번호\t\t사용자 이름\t\t사용자 연락처\t\t사용자 주소\t\t사용자 등록시간");
//		System.out.println("---------------------------------------------------------------------------------------");
//
//		for (Map.Entry<String, MemberDTO> element : map.entrySet()) {
//			MemberDTO valueFromMap = element.getValue();
//			System.out.println(valueFromMap.toString());
//		}
//	}
}
