<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// requestForm3.jsp 페이지로부터 전달받은 폼 파라미터 가져오기
// 단, POST 방식 요청이므로 한글 인코딩 방식 UTF-8 로 지정
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

// String jumin1 = request.getParameter("jumin1");
// String jumin2 = request.getParameter("jumin2");
// 만약, 주민번호 등을 DB 에 저장할 때는 하나의 문자열로 결합하여 저장하므로
// 가져온 데이터를 결합하는 작업이 추가적으로 필요
String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");

// String email1 = request.getParameter("email1");
// String email2 = request.getParameter("email2");
String email = request.getParameter("email1") + "@" + request.getParameter("email2");

String job = request.getParameter("job");
String gender = request.getParameter("gender");
// 취미는 동일한 name 속성으로 복수개의 항목이 전달되므로 String[] 타입 사용
String[] arrHobby = request.getParameterValues("hobby");
String motivation = request.getParameter("motivation");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro3.jsp - 회원가입 데이터</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=passwd %></td>
		</tr>
		<tr>
			<th>주민번호</th>
<%-- 			<td><%=jumin1 %>-<%=jumin2 %></td> --%>
			<td><%=jumin %></td>
		</tr>
		<tr>
			<th>E-Mail</th>
<%-- 			<td><%=email1 %>@<%=email2 %></td> --%>
			<td><%=email %></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><%=job %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=gender %></td>
		</tr>
		<tr>
			<th>취미</th>
<%-- 			<td><%=Arrays.toString(arrHobby) %></td> --%>
			<%-- String[] 타입으로 관리되는 취미를 반복문을 통해 하나의 셀에 출력 --%>
			<td>
				<%
				// 전달받은 항목이 있을 경우(배열이 null 이 아님) 에만 반복문 수행
				if(arrHobby != null) {
					for(String hobby : arrHobby) {
						out.print(hobby + " ");
					}
				} else {
					out.print("없음");
				}
				%>
			</td>
		</tr>
		<tr>
			<th>가입동기</th>
			<td><%=motivation %></td>
		</tr>
	</table>
</body>
</html>















