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
	// jQuery 기본 문법
	// $(객체명 또는 선택자).함수명();
	// => 주의! 라이브러리 추가되지 않았을 경우 $ is not defined 오류메세지 출력
	// => 자바스크립트의 document.querySelector() 또는 document.getElementXXX() 을 대체
	// 현재 문서의 요소를 모두 로딩한 후 자바스크립트를 실행하기 위해
	// window.onload 이벤트 대신 $(window).on("load") 형식으로 대체 가능
// 	$(window).on("load", function() {
// 		alert("window 객체의 load 이벤트!");
// 	});
	// -------------------------------------------------------------------
	// 문서의 DOM 객체가 로딩되면 자동으로 호출되는 이벤트 : document 객체의 ready 이벤트
	// 이벤트 처리 문법-1) jQuery(객체명 또는 선택자).함수명();
// 	jQuery(document).ready(function() {
// 		alert("Ready 이벤트 처리 문법 - 1");
// 	});
	
	// 이벤트 처리 문법-2) $(객체명 또는 선택자).함수명();
	// => jQuery 객체명 대신 $ 기호 사용 가능
// 	$(document).ready(function() {
// 		alert("Ready 이벤트 처리 문법 - 2");
// 	});
	
	// 이벤트 처리 문법-3) $(function() {});
	// => document 객체 지정 및 ready 이벤트 함수 호출 생략
	$(function() {
		alert("Ready 이벤트 처리 문법 - 3");
	});
</script>
</head>
<body>
	<h1 id="header">jQuery - test2.jsp</h1>
	<img src="1.jpg" width="300" height="300" id="img">
</body>
</html>















