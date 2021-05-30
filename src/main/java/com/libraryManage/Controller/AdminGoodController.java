package com.libraryManage.Controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;
import com.libraryManage.Exception.*;

@Controller
@RequestMapping(value = "/admin/alarm/good/*")
public class AdminGoodController {
//	@Autowired
//	GoodDTO

	// 사서 추천 도서 추가 페이지 이동
	@RequestMapping(value = "/good_add", method = RequestMethod.GET)
	public String admin_alarm_good_add() {
		return "admin_alarm_good_add";
	}

	// 사서 추천 도서 삭제 페이지 이동
	@RequestMapping(value = "/good_delete", method = RequestMethod.GET)
	public String admin_alarm_good_delete() {
		return "admin_alarm_good_delete";
	}
}
