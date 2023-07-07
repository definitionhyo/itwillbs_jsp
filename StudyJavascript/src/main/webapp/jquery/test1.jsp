<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- webapp/js 디렉토리에 있는 jquery 라이브러리를 현재 파일에 추가 --%>
<%-- 주의! 외부 라이브러리 추가하는 script 태그 사이에는 자바스크립트 코드 동작 X --%>
<script src="../js/jquery-3.7.0.js"></script>
<script type="text/javascript">
	// <script> 태그 내에 자바스크립트 코드를 직접 기술할 경우
	// 해당 스크립트 태그가 로딩되는 시점에 대상 요소가 존재하지 않아
	// 스크립트가 실행되지 못할 수 있다!
// 	document.querySelector("#header").style.background = "SKYBLUE"; // id 선택자 header 가 없음
	
	// 따라서, window 객체의 onload 이벤트를 통해 window 요소가 모두 로딩되면 실행 가능
	window.onload = function() {
		document.querySelector("#header").style.background = "SKYBLUE";
	}
</script>
</head>
<body>
	<h1 id="header">jQuery - test1.jsp</h1>
	<img src="1.jpg" width="300" height="300" id="img">
	<%-- 로딩 완료 후 스크립트 처리를 위해 대상 태그 아래쪽에 스크립트 작성도 가능 --%>
	<script type="text/javascript">
// 		document.querySelector("#header").style.background = "SKYBLUE";
	</script>
</body>
</html>















