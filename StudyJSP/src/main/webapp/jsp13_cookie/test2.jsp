<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	쿠키에 저장된 "language" 속성값이 비어있거나 "ko-kr" 일 경우 
	한국어 메세지를 브라우저에 출력하고,
	"en-us" 일 경우 영문 메세지를 브라우저에 출력하기
	--%>
	<%
	// 1. 쿠키 꺼내기
	Cookie[] cookies = request.getCookies();
	
	// 2. 쿠키 이름이 "language" 인 쿠키를 찾아 판별 후 각 페이지(한국어/영문) 출력
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("language")) {
			if(cookie.getValue().equals("ko-kr")) {
				%><h1>안녕하세요. 쿠키 예제입니다.</h1><%
			} else if(cookie.getValue().equals("en-us")) {
				%><h1>Hello, This is a Cookie example.</h1><%
			}
		}
	}
	%>	
	
	<hr>
	
	<c:choose>
		<c:when test="${empty cookie.language or cookie.language.value eq 'ko-kr' }">
			<h1>안녕하세요. 쿠키 예제입니다.</h1>
		</c:when>
		<c:when test="${cookie.language.value eq 'en-us' }">
			<h1>Hello, This is a Cookie example.</h1>
		</c:when>
	</c:choose>
	<button onclick="location.href='CookieServlet2?lang=ko-kr'">한국어</button>
	<button onclick="location.href='CookieServlet2?lang=en-us'">영어</button>
</body>
</html>








