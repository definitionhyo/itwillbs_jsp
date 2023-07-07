<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 파라미터로 전달받은 id 가져와서 중복 체크
String id = request.getParameter("id").trim();

// 아이디가 "admin" 이면 "존재하는 아이디" 출력하고
// 아니면, "사용 가능한 아이디" 출력
if(id.equals("admin")) {
// 	out.print("존재하는 아이디");
	out.print(true);
} else {
// 	out.print("사용 가능한 아이디");
	out.print(false);
}
%>
