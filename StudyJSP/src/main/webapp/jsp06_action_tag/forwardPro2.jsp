<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardPro2.jsp</h1>
	<%
	// 이전 페이지에서 POST 방식으로 전달받은 파라미터 중 한글 데이터가 포함되면 깨지므로
	// request 객체의 setCharacterEncoding() 메서드를 통해 한글 인코딩 방식 변경 필요
// 	request.setCharacterEncoding("UTF-8");
	// => 이전 페이지(forwardPro.jsp)에서 한글 인코딩 방식을 변경했으므로
	//    현재 페이지에서는 request 객체 유지로 인해 별도의 인코딩 방식 변경 불필요
	
	// forwardForm.jsp 페이지에서 파라미터로 입력받아 전달된 데이터
	String name = request.getParameter("name");
	String passwd = request.getParameter("passwd");
	
	// forwardForm.jsp 페이지에서 hidden 타입으로 전달된 데이터
	String jumin = request.getParameter("jumin");
	
	// forwardPro.jsp 페이지에서 jsp:param 태그로 전달된 데이터 = 접근 방식 동일
	String paramValue1 = request.getParameter("paramValue1");
	String paramValue2 = request.getParameter("paramValue2");
	%>
	<h3>이름 : <%=name %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>주민번호 : <%=jumin %></h3>
	
	<%-- foward 액션 태그 내의 param 태그로 전달받은 파라미터 출력 --%>
	<h3>paramValue1 : <%=paramValue1 %></h3>
	<h3>paramValue2 : <%=paramValue2 %></h3>
</body>
</html>











