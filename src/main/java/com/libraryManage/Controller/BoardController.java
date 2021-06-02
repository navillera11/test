package com.libraryManage.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;
import com.libraryManage.Service.*;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	BoardDAO boardDAO;

	// 자유게시판 전체 검색
	@RequestMapping(value = "/board_detail", method = RequestMethod.GET)
	public String board_detail(Model model, @RequestParam String boardID) {
		BoardDTO boardDTO = boardDAO.selectByFBID(boardID); 
		
		model.addAttribute("boardDTO", boardDTO);

		return "board_detail";
	}


	// 자유게시판 전체 검색
	@RequestMapping(value = "/unified_search", method = RequestMethod.GET)
	public String board_unified_search(Model model) {
		List<BoardDTO> boardList = boardDAO.showAll();

		model.addAttribute("boardList", boardList);

		return "board_unified_search";
	}
	
	// 게시판 글쓰기
	@GetMapping("/board_write")
	public String board_write() {

		return "board_write";
	}
	
}
