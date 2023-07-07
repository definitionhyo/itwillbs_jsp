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
	<h1>student_list.jsp - JSTL</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%-- 
		JSTL 과 EL 을 조합하여 List<StudentDTO> 타입 객체(studentList) 가져와서
		저장되어 있는 StudentDTO 객체에 차례대로 접근하여 idx, name 값 출력하기
		- 반복문은 <c:forEach> 태그 사용하며, 향상된 for문처럼 사용하기 위해
		  var="변수명" 속성과 items="객체속성명" 속성을 조합하여 사용한다! 
		- request.setAttribute() 메서드로 저장한 객체는 속성명으로 접근하여 가져오기
		  => ${영역객체명.속성명}
		- StudentDTO 객체에 저장된 멤버변수 값은 꺼낸 속성을 통해 변수명으로 접근하여 가져오기
		  => ${객체변수명.멤버변수명}
		  => DTO 클래스 내에 Getter 메서드 정의 필수!
		--%>
		<%-- 1. request 영역에 저장된 studentList 속성(StudentDTO 객체) 꺼내서 student 변수에 저장(반복) --%>
		<c:forEach var="student" items="${requestScope.studentList }">
			<%-- 2. student 변수에 저장된 StudentDTO 객체의 각 멤버변수값 출력 --%>
			<tr>
				<td>${student.idx }</td>
				<td>${student.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>











