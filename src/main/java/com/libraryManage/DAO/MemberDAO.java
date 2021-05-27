package com.libraryManage.DAO;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.*;

import com.libraryManage.DTO.*;

@Component
public class MemberDAO {
	private Map<String, MemberDTO> map = new HashMap<>();

	public MemberDTO selectByEmail(String email) {
		return map.get(email);
	}

	public void printBookList(MemberDTO member) {
		System.out.println("\n-----대여한 도서-----");
		List<BookDTO> bookList = member.getMemBook();
		
		for(BookDTO book : bookList) {
			System.out.println(book.toString());
		}
	}

	public void insertMem(MemberDTO member) {
		//sqlSession.insert()
	}

	public void updateMem(MemberDTO member) {
		map.replace(member.getMemEmail(), member);
	}

	public void deleteMem(MemberDTO member) {
		map.remove(member.getMemEmail());
	}

	public void showAll() {
		System.out.println("사용자 이메일\t\t사용자 비밀번호\t\t사용자 이름\t\t사용자 연락처\t\t사용자 주소\t\t사용자 등록시간");
		System.out.println("---------------------------------------------------------------------------------------");

		for (Map.Entry<String, MemberDTO> element : map.entrySet()) {
			MemberDTO valueFromMap = element.getValue();
			System.out.println(valueFromMap.toString());
		}
	}
}
