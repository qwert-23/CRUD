<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<h1>boardList</h1>
		<a href="/addBoard">글작성 </a>
	<table border="1">
		<thead>
			<tr>
				<th>board_no</th>
				<th>board_pw</th>
				<th>board_title</th>
				
			</tr>
		
		
		</thead>
		
		<tbody>
			<c:forEach var="b"  items= "${boardList}">
			<tr>
			
				<td><a href="/boardOne/${b.boardNo}">${b.boardNo}</a></td>
				<td>${b.boardPw}</td>
				<td>${b.boardTitle}</td>
				
			</tr>
			
			
			</c:forEach>
		
		
	
		
		</tbody>
		
	
	
	
	
	</table>
	
		

</body>
</html>