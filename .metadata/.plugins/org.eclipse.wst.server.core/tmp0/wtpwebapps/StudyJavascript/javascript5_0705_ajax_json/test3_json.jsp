<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnOk").on("click", function() {
			/*
			test3_json_data.txt 파일을 AJAX 를 통해 요청
			- 요청 메서드 : "GET"
			- 응답 데이터 형식 : "text" - 기본 텍스트 형식 데이터
			- AJAX 요청 성공 시 자동으로 호출되는 콜백 함수를 success: 속성에 기술
			  (또는 $.ajax() 함수 호출 외부에 done() 함수를 연결하여 콜백 처리도 가능)
			  (단, success: 와 done() 은 기술 위치도 다르도 호출 순서도 다름)
			*/
// 			$.ajax({
// 				type: "GET",
// 				url: "test3_json_data.txt",
// 				dataType: "text", // 응답 데이터를 일반 텍스트 형식으로 인식
// 				success: function(msg) { // 요청 성공 시 호출되는 콜백 함수
// // 					alert("요청 성공!");
// 					// 응답 데이터로 전달받은 msg 를 "#resultArea" 영역에 표시
// 					$("#resultArea").html(msg);
// 				},
// 				error: function() { // 요청 실패 시 호출되는 콜백 함수
// // 					alert("요청 실패!");
// 				}
// 			});
			// ------------
// 			$.ajax({
// 				type: "GET",
// 				url: "test3_json_data.txt",
// 				dataType: "text"
// 			}).always(function() {
// 				// 요청 성공/실패 여부와 관계없이 항상 실행됨(위치에 따라 호출 순서 다름)
// 				alert("항상 호출됨! - always");
// 			}).done(function(msg) { // success 와 기능 동일(success 보다 호출 순서 낮음)
// 				alert("요청 성공! - done");
// 				$("#resultArea").html(msg);
// 			}).fail(function() { // error 와 기능 동일(error 보다 호출 순서 낮음)
// 				alert("요청 실패! - fail");
// 			});
			// ================================================================
			// test3_json_data.txt 파일 내용 응답 데이터로 요청 시
			// 응답 데이터 형식을 "JSON" 형식으로 지정하여
			// JSON 객체로 인식할 수 있도록 할 수 있다!
			// => 응답 즉시 JSON 객체 형태로 처리 가능
			// => 단, 잘못된 JSON 형식의 문법이라도 일단 JSON 객체로 전달받음
			//    (처리 과정에서 오류 발생)
			$.ajax({
				type: "GET",
				url: "test3_json_data.txt",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 지정
			}).done(function(data) { // success 와 기능 동일(success 보다 호출 순서 낮음)
// 				alert("요청 성공! - " + data); // 요청 성공! - [object Object]
// 				$("#resultArea").html(data); // 아무것도 표시되지 않음
				// => JSON 객체 형식(object 타입)이므로 그대로 사용 불가
				// -------------------------------------------------------
				// 만약, 전달받은 JSON 객체를 문자열 형식으로 변환할 경우
				// 자바스크립트의 내장 객체인 JSON 을 사용하여
				// JSON.stringify() 메서드를 호출하여 변환 가능(파라미터 : JSON 객체)
// 				$("#resultArea").html(JSON.stringify(data)); 
// 				$("#resultArea").append("<br>" + typeof(JSON.stringify(data))); 
				// 출력데이터 {"id":"admin","name":"관리자","age":0}
				// => dataType: "text" 와 결과가 동일함
				// -------------------------------------------------------------
				// JSON 데이터를 객체 형태로 접근하여 테이블에 해당 데이터 출력
				// 1) JSON 데이터를 표시할 테이블 생성
				$("#resultArea").html(
					"<table border='1'>"
					+ "<tr>"
					+ "		<th colspan='3'>JSON 데이터 파싱 결과</th>"
					+ "</tr>"
					+ "<tr>"
					+ "		<th>아이디</th>"
					+ "		<th>이름</th>"
					+ "		<th>나이</th>"
					+ "</tr>"
					+ "</table>"		
				);
			
				// 2) 응답 데이터(JSON 객체)를 처리하여 테이블에 표시
				// JSON 데이터가 객체(중괄호{} 로 감싸져 있음)일 경우 
				// 해당 객체 내의 속성들이 변수 역할을 수행하므로
				// AJAX 를 통해 리턴받는 객체가 저장된 변수(data)를 통해
				// 객체 내의 id, name, age 속성에 접근
				// => 자바스크립트 객체 접근 기본 문법 : 객체명.속성명(ex. data.id)
				// "#resultArea" 영역의 <table> 태그 내에 마지막 요소로 1개 행 추가
				$("#resultArea > table").append(
					"<tr>"
					+ "<td>" + data.id + "</td>"
					+ "<td>" + data.name + "</td>"
					+ "<td>" + data.age + "</td>"
					+ "</tr>"
				);
			}).fail(function() { // error 와 기능 동일(error 보다 호출 순서 낮음)
// 				alert("요청 실패! - fail");
			});
	
			// =================================================================
			// test3_json_data2.json 파일 응답데이터로 전달받는 AJAX 요청
			// => 전달받은 데이터를 "#resultArea2" 영역에 테이블 형태로 표시
			$.ajax({
				type: "GET",
				url: "test3_json_data2.json",
				dataType: "json"
			}).done(function(data) {
				$("#resultArea2").html(
					"<table border='1'>"
					+ "<tr>"
					+ "		<th colspan='3'>JSON 데이터 파싱 결과</th>"
					+ "</tr>"
					+ "<tr>"
					+ "		<th>아이디</th>"
					+ "		<th>이름</th>"
					+ "		<th>나이</th>"
					+ "		<th>주소</th>"
					+ "</tr>"
					+ "</table>"		
				);
			
				$("#resultArea2 > table").append(
					"<tr>"
					+ "<td>" + data.id + "</td>"
					+ "<td>" + data.name + "</td>"
					+ "<td>" + data.age + "</td>"
// 					+ "<td>" + data.address + "</td>" // address 객체 내에 객체 존재하므로 object 출력됨
					+ "<td>" + data.address.address1 + " " + data.address.address2 + "</td>"
					+ "</tr>"
				);
			}).fail(function() {
				alert("요청 실패! - fail");
			});
			
		}); // 버튼 이벤트 끝
		
	});
</script>
</head>
<body>
	<h1>test3_json.jsp - AJAX</h1>
	<input type="button" value="JSON 데이터 파싱" id="btnOk">
	<hr>
	<div id="resultArea"></div>
	<hr>
	<div id="resultArea2"></div>
</body>
</html>













