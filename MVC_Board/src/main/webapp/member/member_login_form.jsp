<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 CSS 파일 연결하기 -->
<link href="css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<!-- 
		Login, Join 링크 표시 영역(inc/top.jsp 페이지 삽입)
		삽입 대상은 현재 파일 기준 상대주소 사용
		(webapp 디렉토리를 가리키려면 / 사용) 
		-->
		<jsp:include page="/inc/top.jsp"></jsp:include>
	</header>
	<article>
		<h1>로그인</h1>
		<form action="MemberLoginPro.me" method="post" name="fr">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" required="required">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="passwd" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</article>
</body>
</html>