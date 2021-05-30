package com.libraryManage.Controller;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/admin/alarm/notice/*")
public class AdminNoticeController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeDAO noticeDAO;

	// 공지사항 추가 페이지 이동
	@RequestMapping(value = "/notice_add", method = RequestMethod.GET)
	public String admin_alarm_notice_add(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showAll();

		model.addAttribute("noticeList", noticeList);

		return "admin_alarm_notice_add";
	}

	// 공지사항 추가 처리
	@PostMapping(value = "/notice_add")
	public void admin_alarm_notice_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}

	// 공지사항 삭제 페이지 이동
	@RequestMapping(value = "/notice_delete", method = RequestMethod.GET)
	public String admin_alarm_notice_delete(Model model) {
		List<NoticeDTO> noticeList = noticeDAO.showAll();

		model.addAttribute("noticeList", noticeList);

		return "admin_alarm_notice_delete";
	}

	// 공지사항 삭제 처리
	@PostMapping(value = "/notice_delete")
	public void admin_alarm_notice_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}
}
