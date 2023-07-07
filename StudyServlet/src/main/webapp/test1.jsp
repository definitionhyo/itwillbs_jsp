<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>
	<!-- 
	POST 방식 요청은 form 태그 내에 method="post" 라고 명시해야하며
	그 외의 대부분의 요청 방식은 모두 GET 방식 요청으로 취급된다!
	-->
	<!-- 하이퍼링크를 사용하여 GET 방식으로 myServlet 서블릿 주소 요청 -->
	<h3><a href="myServlet">myServlet 서블릿 주소 요청(GET)</a></h3>
	
	<!-- form 태그를 사용하여 GET 방식과 POST 방식으로 myServlet 서블릿 주소 요청 -->
	<form action="myServlet"> <!-- method="get" 생략 시 GET 방식(기본값) -->
		<input type="submit" value="myServlet 서블릿 주소 요청(GET)">
	</form>
	
	<!-- 요청 방식에 대해 일치하는 메서드(doPost())가 없을 경우 405 에러 발생 -->
	<form action="myServlet" method="post"> <!-- POST 방식은 method="post" 필수 -->
		<input type="submit" value="myServlet 서블릿 주소 요청(POST)">
	</form>
	
	<!-- 매핑되지 않은 서블릿 주소 요청 시 404 에러 발생 -->
	<form action="myServlet_fail" method="post"> 
		<input type="submit" value="myServlet_fail 서블릿 주소 요청(실패)">
	</form>
</body>
</html>














