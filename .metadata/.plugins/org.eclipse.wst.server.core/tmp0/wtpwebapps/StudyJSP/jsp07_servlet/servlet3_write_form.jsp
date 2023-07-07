<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>글쓰기</h1>
		<form action="jsp07_servlet3_writePro" method="post">
			<table border="1">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="20" name="content"></textarea> </td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글쓰기"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>












