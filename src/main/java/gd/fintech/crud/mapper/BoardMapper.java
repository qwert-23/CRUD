package gd.fintech.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import gd.fintech.crud.vo.Board;


@Mapper
public interface BoardMapper {
 
	List<Board>selectBoardList(); //리스트
	int insertBoard(Board board); // 생성
	int updateBoard(Board board);// 수정
	int deleteBoard(int boardNo); //삭제
	Board selectBoardOne(int board); //상세보기
	
	
	
}
