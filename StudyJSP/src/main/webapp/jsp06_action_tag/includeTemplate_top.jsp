<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="right">
	<%
	// 세션에 저장된 "sId" 라는 속성값을 가져와서 String 타입 변수 id 에 저장
	String id = (String)session.getAttribute("sId");
	%> 
	<h4>
		<a href="sessionTest3_main.jsp">HOME</a> |
		<%if(id == null) { // 로그인 하지 않았을 경우 %>
			<a href="sessionTest3_loginForm.jsp">로그인</a> |
			<a href="sessionTest3_joinForm.jsp">회원가입</a>
		<%} else { // 로그인 했을 경우 %>
			<a href=""><%=id %> 님</a> |
			<a href="javascript:confirmLogout()">로그아웃</a>
			<%if(id.equals("admin")) { %>
				| <a href="sessionTest3_admin.jsp">관리자페이지</a>
			<%} %>
		<%} %>
	</h4>
</div>
<div align="center">
	<a href="#">상단메뉴1</a>&nbsp;&nbsp;&nbsp;
	<a href="#">상단메뉴2</a>&nbsp;&nbsp;&nbsp;
	<a href="#">상단메뉴3</a>&nbsp;&nbsp;&nbsp;
	<a href="#">상단메뉴4</a>&nbsp;&nbsp;&nbsp;
	<a href="#">상단메뉴5</a>
</div>










