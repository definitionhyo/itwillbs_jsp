<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.js"></script>
<script type="text/javascript">
	/*
	AJAX(Asyncronous Javascript And XML, 비동기식 자바스크립트 & XML)
	- 웹페이지(브라우저)의 갱신 없이도 화면 상의 요소를 다룰 수 있는 
	  자바스크립트(jQuery) 라이브러리
	- 데이터베이스 등의 작업 요청 시 요청에 대한 응답이 돌아올 때 까지 기다리지 않고
	  다른 작업을 수행하면서 요청에 대한 응답이 돌아오면 해당 응답을 처리하는 기술
	- 주로, 아이디 검증 또는 페이지 무한스크롤 등의 작업에 활용
	
	< 기본 문법 >
	$.ajax({});
	*/
	$(function() {
		// id 선택자 btnLogin 버튼 클릭 시 동작 이벤트에 대한 익명 함수 정의
		$("#btnLogin").on("click", function() {
			// AJAX 를 사용하여 POST 방식 요청으로 test1_result_ajax.jsp 페이지를 요청
			// 이 때, 요청 페이지로 전달할 파라미터 : 입력받은 아이디, 패스워드
			// 리턴되는 응답데이터를 id 선택자 resultArea 에 출력
			// -----------------------------------------------------------
			// 폼 내부의 파라미터를 모두 요청 페이지로 전송하기 위해
			// 폼을 대상으로 serialize() 메서드를 호출 시 해당 폼의 데이터 직렬화
			// => 폼 파라미터 데이터를 모두 내보내기(= 가져오기 가능)
			let sendData = $("form").serialize();
// 			alert(sendData);
			
			$.ajax({
				// AJAX 요청 및 응답 처리에 사용할 데이터를 속성명:"값" 형태로 지정(순서 무관)
				type: "POST", // 요청 방식(Method)
				url: "test1_result_ajax.jsp", // 요청 URL
// 				data: {
// 					// 복수개의 파라미터 전달 시 파라미터명:데이터 형식으로 전달
// // 					id: "admin",
// // 					passwd: "1234"
					
// 					// 특정 입력 항목의 값을 가져와서 전달할 경우 $("선택자").val()
// // 					id: $("#id").val(),
// // 					passwd: $("#passwd").val()
// 				},
				// serialize() 메서드를 통해 가져온 폼 데이터를 전송할 데이터로 지정(중괄호 불필요)
				data: sendData, // $("form").serialize() 와 동일
				dataType: "text", // 응답 데이터 타입
				success: function(msg) { // 요청 응답(성공) 시 수행할 함수 정의(= 콜백 함수)
					// 요청 성공 시 응답 페이지의 내용이 익명 함수 파라미터(msg)로 전달되므로
					// 해당 파라미터를 사용하여 응답 데이터 접근 가능
// 					$("#resultArea").html(msg);
					$("#resultArea").text(msg);
				}
			});
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<form action="test1_result.jsp" method="get">
			<input type="text" placeholder="아이디" name="id" id="id"><br>
			<input type="password" placeholder="패스워드" name="passwd" id="passwd"><br>
<!-- 			<input type="submit" id="btnLogin" value="로그인"> -->
			<input type="button" id="btnLogin" value="로그인">
		</form>
	</div>
	<hr>
	<div id="resultArea"></div>
</body>
</html>








