<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 CSS 파일 연결하기 -->
<link href="${pageContext.request.contextPath }/css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<!-- Login, Join 링크 등 표시 영역 -->
		<jsp:include page="inc/top.jsp"></jsp:include>
	</header>
	<article>
		<!-- 본문 표시 영역 -->
		<h1>MVC 게시판</h1>
		<h3><a href="BoardWriteForm.bo">글쓰기</a></h3>
		<h3><a href="BoardList.bo">글목록</a></h3>
		<hr>
		<h3>최근 게시물</h3>
		<table border="1">
			<tr>
				<th width="300">제목</th>
				<th width="150">작성자</th>
				<th width="150">작성일</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>
						<a href="BoardDetail.bo?board_num=${board.board_num }">${board.board_subject }</a>
					</td>
					<td>${board.board_name }</td>
					<td><fmt:formatDate value="${board.board_date }" pattern="yy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
	</article>
</body>
</html>








