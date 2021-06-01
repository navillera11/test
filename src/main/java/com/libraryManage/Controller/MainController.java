package com.libraryManage.Controller;

import javax.servlet.http.*;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
public class MainController {
	@Autowired
	BookService bookService;
	@Autowired
	BookDAO bookDAO;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	// 관리자 페이지 테스트용
	@GetMapping("/admin_index")
	public String admin_index() {
		return "admin_index";
	}

	// 회원 페이지 테스트용
	@GetMapping("/member_index")
	public String user_index() {
		return "member_index";
	}

}