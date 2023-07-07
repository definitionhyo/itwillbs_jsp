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
		<h1>회원 정보</h1>
		<form action="#" method="post" name="fr">
			<table border="1">
				<tr>
					<th>이름</th>
					<td>${member.name }</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${member.id }</td>
				</tr>
<!-- 				<tr> -->
<!-- 					<th>비밀번호</th> -->
<!-- 					<td></td> -->
<!-- 				</tr> -->
				<tr>
					<th>주민번호</th>
					<td>${member.jumin }</td>
				</tr>
				<tr>
					<th>E-Mail</th>
					<td>${member.email }</td>
				</tr>
				<tr>
					<th>직업</th>
					<td>${member.job }</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${member.gender }</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>${member.hobby }</td>
				</tr>
				<tr>
					<th>가입동기</th>
					<td>${member.motivation }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="탈퇴하기" 
								onclick="location.href='MemberCheckoutForm.me'">
					</td>
				</tr>
			</table>
		</form>
	</article>
</body>
</html>










