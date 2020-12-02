package gd.fintech.crud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	//페이징 
		public List<Board>getBoardListByPage(int currentPage , int rowPerPage){
			int beginRow = (currentPage -1 ) * rowPerPage; //보여줄 목록  시작하는 데이터  데이터 개수 
			
			Map<String, Integer>map = new HashMap<String, Integer>();
			map.put("beginRow", beginRow);
			map.put("rowPerPage", rowPerPage);
			List<Board> boardList = boardMapper.selectBoardListByPage(map);
			return  boardList;
								
		}
		
		public int getBoardListCount() {
			return boardMapper.selectBoardListCount();
		}
	
	
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
