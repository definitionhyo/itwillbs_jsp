<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 파라미터로 전달받은 id, passwd 가져와서 변수에 저장
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

out.println("아이디 : " + id);
out.println("패스워드 : " + passwd);

// 아이디가 "admin" 이고, 패스워드가 "1234" 이면 "로그인 성공" 출력하고
// 아니면, "로그인 실패" 출력
if(id.equals("admin") && passwd.equals("1234")) {
	out.print("로그인 성공");
} else {
	out.print("로그인 실패");
}
	

%>
