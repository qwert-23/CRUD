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
			<!--1번째 페이지 처음 이전 x   마지막 페이지는 다음 마지막 x  -->
				
	
	</table>
	<c:if test="${currentPage >1}">
			<!-- 페이지가 1보다 크면 안보이게 -->
			<a href="/boardList/1">처음</a>
					<a href="/boardList/${currentPage-1}">이전</a>			  	
				
			
							  
				</c:if>
				
					
			
					
				
				<c:if test="${currentPage <lastPage}">
			<!-- 마지막 페이지 이면 안보이게 -->
				
					 <a href="/boardList/${currentPage+1}">다음</a>
					 <a href="/boardList/${lastPage}">마지막</a>	
				
				
				</c:if>
				
		

</body>
</html>