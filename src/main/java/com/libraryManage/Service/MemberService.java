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

	public MemberDTO registMember(MemberDTO _memberDTO) { // 회원가입
		MemberDTO memberDTO = memberDAO.selectByEmail(_memberDTO.getMemberEmail());

		if (memberDTO == null) { // 회원 존재하지 않음 --> 회원가입 진행
			memberDAO.insertMember(_memberDTO);
			
			return _memberDTO; // 가입한 계정 반환
		} else {
			System.out.println("이미 존재하는 계정입니다.");
			
			return null; // 존재하는 계정 반환
		}
	}

	public MemberDTO loginMember(String inputEmail, String inputPassword) { // 로그인
		MemberDTO memberDTO = memberDAO.selectByEmail(inputEmail);
		
		if (memberDTO == null) {
			System.out.println("이메일 입력 에러");
			return null;
		} else if (!memberDTO.getMemberPassword().equals(inputPassword)) {
			// 비밀번호 오류
			System.out.println("비밀번호 에러");
			return null;
		}

		return memberDTO;
	}
	
	public MemberDTO forgotPassword(String inputEmail) {
		MemberDTO memberDTO = memberDAO.selectByEmail(inputEmail);
		
		if(memberDTO == null) {
			System.out.println("존재하지 않는 계정입니다.");
			return null;
		} else {
			
		}
		
		return memberDTO;
	}

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
