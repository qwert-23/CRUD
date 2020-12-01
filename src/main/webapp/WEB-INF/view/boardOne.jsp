<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardOne</h1>
	<a href="/boardList">boardList</a>
	<table border="1">
	
		<tr>
			<th>board_no</th>
			<td>${boardOne.boardNo}</td>
		</tr>
		<tr>
				<th>board_pw</th>
				<td>${boardOne.boardPw}</td>
				
		</tr>
		<tr>
				<th>board_title</th>
				<td>${boardOne.boardTitle}</td>
		
		</tr>		
		<tr>
				<th>board_content</th>
				<td>${boardOne.boardContent}</td>
		
		</tr>		
		<tr>
				<th>board_user</th>
				<td>${boardOne.boardUser}</td>
		
		</tr>		
		<tr>
				<th>board_date</th>
				<td>${boardOne.boardDate}</td>
		
		</tr>
	
	
	
	
	
	
	</table>
	<a href="/removeBoard/${boardOne.boardNo}">삭제</a>
	<a href="/modifyboard/${boardOne.boardNo}">수정</a>
</body>
</html>