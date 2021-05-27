package com.libraryManage.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;

@Service
public class MemberService {
	private MemberDAO memberDAO;

	@Autowired
	public MemberService(MemberDAO _memberDAO) {
		this.memberDAO = _memberDAO;
	}

	public void registMember(MemberDTO _memberDTO) { // 회원가입
		memberDAO.insertMember(_memberDTO);
	}

//	public MemberDTO loginMem() { // 로그인
//		System.out.print("이메일 : ");
//		String inputEmail = sc.nextLine();
//
//		System.out.print("비밀번호 : ");
//		String inputPwd = sc.nextLine();
//
//		MemberDTO member = memberDAO.selectByEmail(inputEmail);
//
//		if (member == null) {
//			System.out.println("\n입력 정보를 확인하세요.\n");
//			return null;
//		} else if (!member.getMemPwd().equals(inputPwd)) { // 비밀번호 오류
//			System.out.println("\n입력 정보를 확인하세요.\n");
//			return null;
//		} else {
//			if (member.getMemEmail().equals("admin")) {
//				System.out.println("\n관리자 로그인 성공\n");
//			} else {
//				System.out.println("\n사용자 로그인 성공\n");
//			}
//		}
//
//		return member;
//	}

//	public void updateMem(MemberDTO _member) { // 회원 수정
//		System.out.print("현재 비밀번호 : ");
//		String oldPwd = sc.nextLine();
//
//		System.out.print("새 비밀번호 : ");
//		String newPwd = sc.nextLine();
//
//		System.out.print("새 비밀번호 확인 : ");
//		String newConfirmPwd = sc.nextLine();
//
//		MemberDTO member = memberDAO.selectByEmail(_member.getMemEmail());
//
//		if (member == null) { // 계정이 존재하지 않을 때
//			System.out.println("\n계정이 존재하지 않습니다.\n");
//		} else if (newPwd.equals(newConfirmPwd) && member.getMemPwd().equals(oldPwd)) {
//			// 확인할 비밀번호와 입력한 비밀번호가 같을 시
//			member.changePassword(oldPwd, newPwd);
//			memberDAO.updateMem(member);
//			System.out.println("\n비밀번호가 변경되었습니다.\n");
//		} else
//			System.out.println("\n입력 정보를 확인하세요.\n");
//
//		memberDAO.showAll();
//	}
//
//	public void deleteMem() { // 회원 삭제
//		memberDAO.showAll();
//		
//		System.out.println("\n삭제할 회원의 이메일을 입력하세요.\n");
//		String inputEmail = sc.nextLine();
//
//		MemberDTO member = memberDAO.selectByEmail(inputEmail);
//
//		if (member == null) {
//			System.out.println("\n계정이 존재하지 않습니다.\n");
//		} else {
//			memberDAO.deleteMem(member);
//			System.out.println("\n회원이 삭제되었습니다.");
//		}
//
//		memberDAO.showAll();
//	}
}
