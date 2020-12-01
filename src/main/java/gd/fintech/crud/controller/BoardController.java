package gd.fintech.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gd.fintech.crud.service.BoardService;
import gd.fintech.crud.vo.Board;

@Controller
public class BoardController {
	@Autowired 
			BoardService boardService;
	
	
	@GetMapping("/boardList")  // 목록
	public String boardList(Model model){
		List<Board>boardList = boardService.selectBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@GetMapping("/addBoard")  //  추가
	public String addBoard(Model model) {
		List<Board> boardList =boardService.selectBoardList();
		model.addAttribute("BoardList", boardList);
		return "addBoard";
	}
	

	@PostMapping("/addBoard")  
	public String addBoard(Board board) {
	boardService.getaddBoard(board);
	return "redirect:/boardList";
		
	}
	

	
	@GetMapping("/boardOne/{boardNo}")	//상세보기
	public String boardOne(Model model,
		@PathVariable(value = "boardNo")int boardNo ) {
		Board boardOne = boardService.getBoardOne(boardNo);
		model.addAttribute("boardOne", boardOne);		
		
		return "boardOne";
	}
	
	
	@GetMapping("/removeBoard/{boardNo}") // 삭제
		public String removeBoard(Model model,
		@PathVariable(value="boardNo")int boardNo) {
		boardService.getremoveBoard(boardNo);
		return "redirect:/boardList";
	}
	
	@GetMapping("/modifyboard/{boardNo}")	//수정 
	public String modifyBoard (Model model,
			@PathVariable(value="boardNo")int boardNo) {
		Board board = boardService.getBoardOne(boardNo);
		model.addAttribute("Board",board);
		return "modifyboard";
	}
	
	
	
	
	@PostMapping("/modifyboard/{boardNo}")
	public String modifyBoard (Board board) {
		boardService.getupdateBoard(board);
		return "redirect:/boardOne/{boardNo}";
	}
	

}
