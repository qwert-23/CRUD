package gd.fintech.crud.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import gd.fintech.crud.vo.Board;


@Mapper
public interface BoardMapper {
	
	
	
	//페이징
	List<Board>selectBoardListByPage(Map<String, Integer>map);
	int selectBoardListCount();	// count 
	
	List<Board>selectBoardList(); //리스트
	int insertBoard(Board board); // 생성
	int updateBoard(Board board);// 수정
	int deleteBoard(int boardNo); //삭제
	Board selectBoardOne(int board); //상세보기
	
	
	
}
