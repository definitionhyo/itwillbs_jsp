<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">include 템플릿 페이지</h3>
	<table border="1">
		<tr>
			<td colspan="2" width="800" height="100">
				<%-- includeTemplate_top.jsp 페이지 삽입 --%>
				<jsp:include page="includeTemplate_top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td width="200" height="400">
				<%-- includeTemplate_left.jsp 페이지 삽입 --%>
				<jsp:include page="includeTemplate_left.jsp"></jsp:include>
			</td>
			<td>
				<%-- includeTemplate_main.jsp 페이지 삽입 --%>
				<jsp:include page="includeTemplate_main.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="100">
				<%-- includeTemplate_bottom.jsp 페이지 삽입 --%>
				<jsp:include page="includeTemplate_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>











