package gd.fintech.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gd.fintech.crud.mapper.BoardMapper;
import gd.fintech.crud.service.BoardService;
import gd.fintech.crud.vo.Board;

@Controller
public class BoardController {
	@Autowired 
			BoardService boardService;
	
	@GetMapping("/boardList/{currentPage}")
	public String boardList(Model model, @PathVariable(value="currentPage") int currentPage) {
		int rowPerPage = 3;  // 보여줄 행의 개수
		int countPage = boardService.getBoardListCount();
		int lastPage = 0; //마지막 페이지
		if((countPage % rowPerPage) == 0) { //마지막 페이지 구하기 
			lastPage = countPage / rowPerPage; //마지막 페이지는 총개수 / 3 
			
		}else {
			lastPage = (countPage / rowPerPage) + 1; //마지막 페이지는 총개수 / 3  +1
		}
		
		List<Board> boardList = boardService.getBoardListByPage(currentPage, rowPerPage);
		model.addAttribute("boardList", boardList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
	
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
	return "redirect:/boardList/1";
		
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
		return "redirect:/boardList/1";
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
