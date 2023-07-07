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
		/*
		css() 함수
		- 파라미터로 속성명 지정 시 해당 CSS 속성값 리턴
		  => 이 때, 대상이 복수개일 경우 첫번째 요소의 값만 리턴
		- 속성명과 속성값 함께 지정 시 해당 CSS 속성값 변경
		  => 이 때, 대상이 복수개일 경우 복수개의 모든 요소 값 변경
		*/
		
		// h3 태그의 "color" 속성값 출력
// 		alert($("h3").css("color")); // rgb(0, 0, 0)
		
		// 모든 h3 태그의 "color" 속성값을 "green" 으로 변경
		$("h3").css("color", "green");
		
		// 첫번째 h3 태그의 "color" 속성값만 "blue" 로 변경
		// => 순서선택자 :first 사용 가능
		$("h3:first").css("color", "blue");
		
		// h3 태그의 "color" 속성값 출력
// 		alert($("h3").css("color")); // rgb(0, 0, 255) = blue 출력됨
		// => 첫번째 h3 태그의 color 속성값 리턴하므로 blue 만 출력됨
		
		/*
		css() 함수(다른 함수도 가능)내에서 익명함수 구현 시
	 	대상 태그를 차례대로 접근하는 반복문 형태로 사용 가능함
	 	=> css("속성명", function([파라미터...]) {})
	 	=> css("속성명", function() {})
	 	=> css("속성명", function(index) {})
	 	=> css("속성명", function(index, value) {})
		*/
		// 1) 파라미터가 없는 익명함수 구현 시 해당 태그 갯수만큼 반복 수행함
		//    => css("속성명", function() {})
		$("h3").css("color", function() {
			console.log("h3 태그 접근!"); // 3번 실행됨(h3 태그가 3개)
		});
		
		// 2) 파라미터가 1개인 익명함수 구현 시 해당 태그 갯수만큼 반복 수행하면서
		//    현재 태그의 인덱스(순서번호)가 리턴됨(파라미터(변수)에 저장됨)
		//    => css("속성명", function(index) {})
		$("h3").css("color", function(index) {
			console.log(index + "번 h3 태그 접근!");
		});
		
		// 3) 파라미터가 2개인 익명함수 구현 시 해당 태그 갯수만큼 반복 수행하면서
		//    현재 태그의 인덱스와 속성값이 리턴됨(파라미터(변수)에 저장됨)
		//    => css("속성명", function(index, value) {})
		$("h3").css("color", function(index, value) {
			console.log(index + "번 h3 태그 color 속성값 : " + value);
			// 0번 h3 태그 color 속성값 : rgb(0, 0, 255)
			// 1번 h3 태그 color 속성값 : rgb(0, 128, 0)
			// 2번 h3 태그 color 속성값 : rgb(0, 128, 0)
		});
		
		// --------------------------------------------------------------------
		// 배열을 활용하면 대상 태그 속성값을 차례대로 한꺼번에 변경도 가능
		// => 대상을 반복하면서 값 변경 시 return 문을 통해 변경할 값을 리턴
		
		// 변경에 사용될 속성값을 각 배열에 저장
		let colorValue = ["red", "green", "blue"];
		let bgColorValue = ["cyan", "skyblue", "yellow"];
		
		// h3 태그의 css 함수를 호출하여 "color" 속성에 차례대로 접근 반복(인덱스 리턴받기)
// 		$("h3").css("color", function(index) {
// // 			return "red"; // 반복하는 대상의 모든 color 속성값을 "red" 로 변경
			
// 			// 함수 파라미터로 전달받는 index 값을 배열 인덱스로 활용하여 속성값 리턴
// 			return colorValue[index];
// 		});
		
		// h3 태그의 css 함수를 호출하여 "background" 속성에 차례대로 접근 반복(인덱스 리턴받기)
		// => bgColorValue 배열 활용하여 배경색 변경
// 		$("h3").css("background", function(index) {
// 			return bgColorValue[index];
// 		});
		
		// 동일한 대상에 동일한 함수로 복수개의 속성을 반복문 형태로 변경하는 경우
		// $("선택자").css({속성1:함수(index){}, 속성2:함수(index){}});
		$("h3").css({
			color: function(index) {
				return colorValue[index];
			},
			background: function(index) {
				return bgColorValue[index];
			}
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test4.jsp</h1>
	<h3>제목1</h3>
	<h3>제목2</h3>
	<h3>제목3</h3>
</body>
</html>













