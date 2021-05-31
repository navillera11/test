package com.libraryManage.Controller;

import org.springframework.ui.*;
import java.io.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

@Controller
@RequestMapping(value = "/admin/member/*")
public class AdminMemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDAO memberDAO;

	// 회원 조회 페이지 이동
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String admin_member_show(Model model) {
		List<MemberDTO> memberList = memberDAO.showAll();

		model.addAttribute("memberList", memberList);

		return "admin_member_show";
	}

	// 블랙리스트 회원 조회 페이지 이동
	@RequestMapping(value = "/black_show", method = RequestMethod.GET)
	public String admin_member_black_show(Model model) {
		List<MemberDTO> memberBlackList = memberDAO.showBlack();

		model.addAttribute("memberBlackList", memberBlackList);

		return "admin_member_black_show";
	}
	
	// 회원 희망 도서 페이지 이동
	@RequestMapping(value = "/hope", method = RequestMethod.GET)
	public String admin_member_hope(Model model) {
		return "admin_member_hope";
	}
}
