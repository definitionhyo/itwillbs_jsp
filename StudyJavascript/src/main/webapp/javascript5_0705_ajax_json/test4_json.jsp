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
			// test4_json_data.json 파일 응답데이터로 전달받는 AJAX 요청
			// => 전달받은 데이터를 "#resultArea" 영역에 테이블 형태로 표시
			$.ajax({
				type: "GET",
				url: "test4_json_data.json",
				dataType: "json"
			}).done(function(data) {
				$("#resultArea").html(
					"<table border='1'>"
					+ "<tr>"
					+ "		<th>JSON 데이터 파싱 결과</th>"
					+ "</tr>"
					+ "<tr>"
					+ "		<th>이름</th>"
					+ "</tr>"
					+ "</table>"		
				);
			
				// 응답된 JSON 데이터가 배열 형태일 경우 일반 자바스크립트 배열 접근과 동일
				// 배열(data)의 길이만큼 for문을 통해 반복 수행
// 				for(let i = 0; i < data.length; i++) {
// 					$("#resultArea > table").append(
// 						"<tr>"
// 						+ "<td>" + data[i] + "</td>"
// 						+ "</tr>"
// 					);
// 				}
				
				// for...of 문으로 동일한 작업 수행
				for(let name of data) {
					$("#resultArea > table").append(
						"<tr>"
						+ "<td>" + name + "</td>"
						+ "</tr>"
					);
				}
				
			}).fail(function() {
				alert("요청 실패! - fail");
			});
			
			// ========================================================
			// test4_json_data2.json 응답 데이터로 전달받는 AJAX 요청
			// => "#resultArea2" 영역에 표시
			$.ajax({
				type: "GET",
				url: "test4_json_data2.json",
				dataType: "json"
			}).done(function(data) {
				$("#resultArea2").html(
					"<table border='1'>"
					+ "<tr>"
					+ "		<th colspan='4'>JSON 데이터 파싱 결과</th>"
					+ "</tr>"
					+ "<tr>"
					+ "		<th>아이디</th>"
					+ "		<th>이름</th>"
					+ "		<th>나이</th>"
					+ "		<th>주소</th>"
					+ "</tr>"
					+ "</table>"		
				);
			
				for(let member of data) {
					$("#resultArea2 > table").append(
						"<tr>"
						+ "<td>" + member.id + "</td>"
						+ "<td>" + member.name + "</td>"
						+ "<td>" + member.age + "</td>"
						+ "<td>" + member.address.address1 + " " + member.address.address2 + "</td>"
						+ "</tr>"
					);
				}
			}).fail(function() {
				alert("요청 실패! - fail");
			});
			
		}); // 버튼 이벤트 끝
		
	});
</script>
</head>
<body>
	<h1>test4_json.jsp - AJAX</h1>
	<input type="button" value="JSON 데이터 파싱" id="btnOk">
	<hr>
	<div id="resultArea"></div>
	<hr>
	<div id="resultArea2"></div>
</body>
</html>













