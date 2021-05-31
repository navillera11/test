package com.libraryManage.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.libraryManage.DAO.*;
import com.libraryManage.DTO.*;

@Service
public class BoardService {
	private BoardDAO boardDAO;

	@Autowired
	public BoardService(BoardDAO _boardDAO) {
		this.boardDAO = _boardDAO;
	}

	public void updatePublic(BoardDTO _boardDTO, String inputBoardPublic) {
		// 회원 랭크 수정
		boardDAO.updatePublic(_boardDTO, inputBoardPublic);
	}
}
