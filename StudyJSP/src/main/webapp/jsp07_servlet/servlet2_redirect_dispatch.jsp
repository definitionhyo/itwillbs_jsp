<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>servlet2_redirect_dispatch</h1>
	<form action="redirectServlet" method="get">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="redirectServlet 요청(GET)">
	</form>
	<form action="dispatchServlet" method="get">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="dispatchServlet 요청(GET)">
	</form>
</body>
</html>











