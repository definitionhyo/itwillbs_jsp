<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro4.jsp - 로그인 처리</h1>
	<%
	// 폼 파라미터(아이디, 패스워드, 로그인 상태 유지) 가져와서 변수에 저장 및 출력
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String rememberLogin = request.getParameter("rememberLogin");
	
// 	out.print("<h3>아이디 : " + id + "</h3>");
// 	out.print("<h3>패스워드 : " + passwd + "</h3>");
// 	out.print("<h3>로그인 상태 유지 : " + rememberLogin + "</h3>");
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>로그인 상태 유지 : <%=rememberLogin %></h3>
	
	<%
	// 임시로 변수에 데이터베이스 아이디와 패스워드를 저장했다고 가정
	String dbId = "admin";
	String dbPasswd = "1234";
	
	// 로그인 성공 시 자바스크립트를 사용하여 requestPro4_responseResult1.jsp 로 이동 
	// 로그인 실패 시 자바스크립트를 사용하여 requestPro4_responseResult2.jsp 로 이동 
	// => 자바스크립트로 응답 데이터에 다른 페이지 이동 코드를 삽입하는 것도 리다이렉트!
	if(id.equals(dbId) && passwd.equals(dbPasswd)) {
		%>
		<script type="text/javascript">
// 			location.href = "requestPro4_responseResult1.jsp";
		</script>
		<%
	} else {
		%>
		<script type="text/javascript">
// 			location.href = "requestPro4_responseResult2.jsp";
		</script>
		<%
	}
	%>
	
	<%-- 자바 코드를 사용하여 동일한 리다이렉트 수행(내장객체 response 활용) --%>
	<%-- response.sendRedirect("이동할 페이지 URL"); --%>
	<%
	if(id.equals(dbId) && passwd.equals(dbPasswd)) {
		response.sendRedirect("requestPro4_responseResult1.jsp");
	} else {
		response.sendRedirect("requestPro4_responseResult2.jsp");
	}
	%>
	
</body>
</html>














