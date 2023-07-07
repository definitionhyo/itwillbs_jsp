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
		// each() 메서드 : 대상에 대한 반복을 수행
		// => 지정 가능한 대상 : 태그, 배열 등의 객체
		// => 기본 문법 : $("선택자").each(function(index, item) {})
		//                $.each(객체, function(index, item) {})
		//                => index : 대상의 인덱스, item : 대상 요소
		$("h3").each(function(index, item) {
			// resultArea 영역에 index 와 item 값 출력
			// => 주의! div 태그 내의 마지막에 항목들이 추가되어야 하므로 append() 사용
// 			$("#resultArea").append(index + " : " + item + "<br>");
			
// 			$("#resultArea").append(index + " : " + item.html() + "<br>");
			// => item 항목은 자바스크립트 객체이므로 jQuery 함수(메서드) 호출 불가!
			//    따라서, 선택자 지정을 통해 item 요소를 감싸 jQuery 객체로 표현해야함
// 			$("#resultArea").append(index + " : " + $(item).html() + "<br>");
			// 또는 $(this) 형식으로 객체 지정 시 동일한 결과
// 			$("#resultArea").append(index + " : " + $(this).html() + "!<br>");
			// ---------------------------------------------
			// table 태그 내에 각 항목 출력
			// => 기존 행(tr 태그)보다 아래쪽에 출력해야하므로 append() 사용
			// => tr 태그와 td 태그 및 출력 항목을 차례대로 기술하여 추가
// 			$("table").append("<tr><td>" + index + "</td></tr>");
			// => 주의! 테이블이 복수개이므로 각 테이블 모두 데이터 출력됨
			
			// table 태그 중 첫번째 테이블 내의 가장 마지막 요소로 index 값 출력
			$("table").eq(0).append("<tr><td>" + index + "</td></tr>");
			
			// table 태그 중 두번째 테이블 내의 가장 마지막 요소로 index, item 값 출력
			// => 단, item 에 해당하는 요소의 텍스트만 추출하여 출력
// 			$("table").eq(1).append(
// 					"<tr><td>" + index + "</td><td>" + $(item).text() + "</td></tr>");
		});
		
		// 배열을 활용하여 반복문을 수행할 경우
		let arr = [
			{no:"1번", name:"홍길동"}, // 객체1
			{no:"2번", name:"이순신"}, // 객체2
			{no:"3번", name:"강감찬"}  // 객체3
		];
		
		// 배열은 별도의 선택자가 제공되지 않으므로 $.each() 형식으로 호출 후
		// 파라미터로 배열, 익명함수를 전달
		$.each(arr, function(index, item) {
			// 배열 크기만큼 자동으로 반복하면서 배열의 각 요소에 접근
			// => 배열 내의 요소가 객체이므로 객체명(item)을 통해 값에 접근 가능
			$("table").eq(1).append(
					"<tr><td>" + item.no + "</td><td>" + item.name + "</td></tr>");
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test10.jsp</h1>
	<h3>item 1</h3>
	<h3>item 2</h3>
	<h3>item 3</h3>
	<div id="resultArea"></div>
	<table border="1">
		<tr><td>번호</td></tr>
	</table>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>항목</td>
		</tr>
	</table>
</body>
</html>












