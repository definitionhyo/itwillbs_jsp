<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	System.out.println("접속자 : " + request.getRemoteAddr());
	System.out.println("이름 : " + request.getParameter("name"));
	System.out.println("아이디 : " + request.getParameter("id"));
	System.out.println("패스워드 : " + request.getParameter("passwd"));
	%>
	<h1>result.jsp</h1>
	<h3>이름 : ${param.name }</h3>
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
</body>
</html>











