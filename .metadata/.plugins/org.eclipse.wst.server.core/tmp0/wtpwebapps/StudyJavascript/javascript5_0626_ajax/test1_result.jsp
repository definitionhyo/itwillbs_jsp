<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 확인</h3>
	
	${param.id }, ${param.passwd }
	
<%-- 	<%response.sendRedirect("test1.jsp?result=success");%> --%>
	<%-- 
	만약, test1.jsp 에서 요청 발생 시 test1_result.jsp 에서 처리 후
	다시, test1.jsp 페이지로 포워딩하는 경우 test1.jsp 페이지는 새로고침이 발생함
	--%>
</body>
</html>