<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<!-- 외부 CSS 파일 연결하기 -->
<link href="css/default.css" rel="stylesheet" type="text/css">
<style>
	#passForm {
		width: 300px;
		margin: auto;
		border: 1px solid orange;
		text-align: center;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		width: 300px;
		margin: auto;
		text-align: center;
	}
	
</style>
<script type="text/javascript">
	function confirmCheckout() {
		let result = confirm("탈퇴하시겠습니까? 복구가 불가능합니다.");
		if(result) {
			return true; // submit 
		}

		return false;
	}
</script>
</head>
<body>
	<c:if test="${empty sessionScope.sId }">
		<script type="text/javascript">
			alert("접근 권한이 없습니다!");
			history.back();
		</script>
	</c:if>
	<header>
		<!-- Login, Join 링크 등 표시 영역 -->
		<jsp:include page="/inc/top.jsp"></jsp:include>
	</header>
	<!-- 게시판 글 삭제 -->
	<h2>회원 탈퇴</h2>
	<section id="passForm">
		<form action="MemberCheckoutPro.me" name="deleteForm" method="post">
			<%-- 세션에 아이디가 저장되어 있으므로 전달 불필요 --%>
<%-- 			<input type="hidden" name="id" value="${sessionScope.sId}"> --%>
			<table>
				<tr>
					<td><label>비밀번호</label></td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원탈퇴" onclick="return confirmCheckout()">&nbsp;&nbsp;
						<input type="button" value="돌아가기" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>





