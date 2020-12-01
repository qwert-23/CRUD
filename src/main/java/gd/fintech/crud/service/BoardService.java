package gd.fintech.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gd.fintech.crud.mapper.BoardMapper;
import gd.fintech.crud.vo.Board;

@Transactional
@Service
public class BoardService {
	@Autowired 
		private BoardMapper boardMapper;
	
	
	
	//리스트
	 public List<Board>selectBoardList(){
		 return boardMapper.selectBoardList();
	 }
	
	
	
		
	// 상세
	public Board getBoardOne(int board) {
		return boardMapper.selectBoardOne(board);
	}
	
	
	 //수정
	public int getupdateBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
	
	
	//입력
	public int getaddBoard(Board board) {
		return boardMapper.insertBoard(board);

	}
	
	//삭제
	public int getremoveBoard(int boardNo){
		return boardMapper.deleteBoard(boardNo);
		
	}
		
	
		

}
