<%@page import="jsp11_servlet.StudentDTO"%>
<%@page import="java.util.List"%>
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
	<h1>test4_result.jsp - JSTL</h1>
	<%--
	request 객체에 저장된 속성값을 꺼낼 때 request.getAttribute() 메서드를 사용했으며,
	EL 문법을 통해 가져올 때는 ${속성명} 형식으로 꺼낼 수 있다!
	=> page, request, session, application 영역을 차례대로 검사하여 일치하는 속성을 꺼낸다!
	--%>
	<h3>
		<%-- 주의! request.setAttribute() 로 저장한 데이터는 파라미터가 아니다! --%>
		<%-- 속성명만 지정하면 request 객체의 속성에 접근 가능하다! --%>
		번호 : ${idx }<br>
		이름 : ${name }
	</h3>
	<hr>
	
	<%-- 자바 문법의 일반 for문을 통해 제어변수 i값이 1 ~ 10 까지 1씩 증가하면서 반복 --%>
<%-- 	<%for(int i = 1; i <= 10; i++) { %> --%>
<%-- 		<%=i %> --%>
<%-- 	<%} %> --%>
	<%
	for(int i = 1; i <= 10; i++) {
		out.print(i + " ");
	}
	%>
	<hr>
	<%--
	[ JSTL 의 <c:forEach> 태그를 활용한 반복문 ]
	1. 제어변수를 활용하여 시작값 ~ 종료값까지 증감값만큼 증감을 통해 반복하는 문장
	<c:forEach var="제어변수명" begin="시작값" end="종료값" step="증감값">
		// 반복문 내에서 실행할 문장들...
		// 이 때, var 속성으로 설정한 변수는 EL문법(${변수명}) 으로 접근 가능
	</c:forEach>
	--%>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }
	</c:forEach>
	<hr>
	<%
	// 자바 문법을 사용하여 request 객체에 저장된 3개짜리 배열 names 에 차례대로 접근
// 	String[] names = (String[])request.getAttribute("names");
// 	for(int i = 0; i < names.length; i++) {
// 		out.print(names[i] + " ");
// 	}
	%>
<!-- 	<hr> -->
	<%-- request 객체에 저장된 3개짜리 배열 names 에 차례대로 접근하는 forEach 문 --%>
	<c:forEach var="i" begin="0" end="2" step="1">
		${names[i] }
	</c:forEach>
	<hr>
	<%-- 
	2. 인덱스 없이 객체 내의 데이터를 차례대로 접근하는 forEach문(= 향상된 for문)
	<c:forEach var="객체 데이터 저장할 변수" items="복수개 데이터 저장된 객체" varStatus="상태변수">
		// 반복문 내에서 실행할 문장들...
		// 이 때, var 속성으로 설정한 변수에는 객체 내의 데이터가 자동으로 저장됨
		// varStatus 속성은 반복되는 객체의 인덱스 값 등 반복 상태가 자동으로 저장됨
		// => 반복되는 인덱스는 varStatus변수명.index 값으로 알아낼 수 있음
	</c:forEach>
	--%>
	<%-- names 배열에 접근하여 이름을 차례대로 출력 --%>
	<%
	// 자바 문법을 사용할 경우
	String[] names = (String[])request.getAttribute("names");
	for(String name : names) {
		out.print(name + " ");
	}
	%>
	<hr>
	<c:forEach var="name" items="${names }" varStatus="status">
		<%-- names 라는 이름의 객체(배열 포함)에서 값을 차례대로 꺼내 name 변수에 저장 --%>
		<%-- varStatus 속성은 반복 상태를 관리(인덱스 접근 시 변수명.index 로 접근)  --%>
		${status.index } 번 배열 데이터 : ${name }<br>
	</c:forEach>
	<hr>
	
	<%-- List 객체(studentList) 에 저장된 StudentDTO 객체를 차례대로 접근 --%>
	<%
// 	List<StudentDTO> studentList = (List<StudentDTO>)request.getAttribute("studentList");
// 	for(StudentDTO student : studentList) {
// 		out.print(student.getIdx() + ", " + student.getName() + "<br>");
// 	}
	%>
	<hr>
	<c:forEach var="student" items="${studentList }">
		<%-- 
		StudentDTO 객체 접근 시 var 로 선언한 변수명.멤버변수명으로 접근
		- 이 때, 실제로 멤버변수에 직접 접근하는 것이 아니라
		  내부적으로 StudentDTO 객체의 멤버변수에 대응하는 getXXX() 메서드가 자동 호출됨
		- 따라서, DTO 클래스에는 반드시 멤버변수와 함께 Getter/Setter 정의 필수!
		--%>
		${student.idx }, ${student.name }<br>
	</c:forEach>
</body>
</html>










