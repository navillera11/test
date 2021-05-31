package com.libraryManage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.libraryManage.DAO.BoardDAO;
import com.libraryManage.DAO.BookDAO;
import com.libraryManage.DAO.GoodDAO;
import com.libraryManage.DTO.BoardDTO;
import com.libraryManage.Service.BoardService;

@Controller
@RequestMapping(value = "/admin/alarm/board/*")
public class AdminBoardController {
	// 관리자 페이지 중
	// 알림 부분 중
	// 자유게시판 부분
	
	@Autowired
	BoardService boardService;
	@Autowired
	BoardDAO boardDAO;
	/*
	 * @Autowired GoodDAO goodDAO;
	 * 
	 * @Autowired BookDAO bookDAO;
	 */
	
	//게시판 비공개
	@RequestMapping(value = "/board_update", method = RequestMethod.GET)
	public String admin_alarm_good_delete(Model model) {
		List<BoardDTO> boardList = boardDAO.showAll();

		model.addAttribute("boardList", boardList);

		return "admin_alarm_board_update";
	}

	// @Autowired
//	BoardService boardService;
	// @Autowired
	// BoardDAO boardDAO;

	// 자유게시판 목록 페이지 이동

	// 자유게시판 세부 페이지 이동

}
