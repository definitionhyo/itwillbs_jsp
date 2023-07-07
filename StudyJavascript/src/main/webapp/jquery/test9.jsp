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
	DOM 객체(요소)를 탐색 및 접근하여 대상을 조작하는 방법
	- HTML 태그에 대한 자바스크립트 이벤트와 동일함
	- 대상 요소 지정하여 이벤트 처리를 수행하는 각각의 메서드를 호출하거나
	  (ex. click(), submit() 메서드 등)
	  on() 메서드 내에 이벤트 이름을 지정하여 각각의 이벤트를 처리 가능
	  (ex. on("click"), on("submit") 등)
	
	1. on("click") 메서드
	   - 특정 대상을 "클릭" 시 동작하는 이벤트 처리(click() 메서드와 동일)
	   - 클릭 대상에 대한 제한 없음(버튼이 아닌 요소도 가능)
	
	2. on("focus") 또는 on("blur") 메서드
	   - 특정 대상에 포커스가 주어지거나 해제 시 동작하는 이벤트 처리
	   - focus(), blue() 메서드와 동일
	   - 클릭이 아닌 키보드 등을 통한 포커스 이동도 동일하게 취급됨
	*/
	$(function() {
		// 확인 버튼 클릭 시 버튼의 value 값 가져와서 출력하기
// 		alert($("input[type=button]").eq(0).val());
		
		// 확인 버튼 클릭 시 메세지 출력
// 		$("input[type=button]").eq(0).on("click", function() {
// 			alert("확인 버튼 클릭!");
// 		});
		
		// 취소 버튼 클릭 시 메세지 출력
// 		$("input[type=button]").eq(1).on("click", function() {
// 			alert("취소 버튼 클릭!");
// 		});
		
		// -------------------------------------------------------
		// 버튼을 지정하는 선택자로 가상선택자 ":button" 사용 가능
// 		$(":button").on("click", function() {
// // 			alert("버튼 클릭!");
// // 			alert($(this).val()); // 클릭된 버튼을 $(this) 로 가리킴(버튼 텍스트 출력)
// 			// 확인 or 취소 버튼 판별
// 			if($(this).val() == "확인") {
// 				alert("확인!");
// 			} else {
// 				alert("취소!");
// 			}
// 		});
		// -------------------------------------------------------
		// 확인 버튼(= 첫번째 버튼) 클릭되면 익명 함수 실행
		$(":button").eq(0).on("click", function() {
			// 입력받은 아이디, 패스워드, 선택된 과목명을 textarea 에 출력
			// => val() 메서드 또는 html(), text() 메서드 활용
			// => 셀렉트박스는 $("선택자").val() 을 통해 셀렉트박스의 값을 가져오거나
			//    $("선택자 > option:selected").val() 을 통해 옵션 중 선택된 요소 값 가져오기 가능 
			$("#resultArea").html(
				"아이디 : " + $("input[name=id]").val()	+ "\n"
				+ "패스워드 : " + $("input[name=passwd]").val()	+ "\n"
				+ "선택과목 : " + $("#selectBox").val()	+ "\n"
				+ "선택과목 : " + $("#selectBox > option:selected").val()	+ "\n"
			);
		});
		
// 		$("textarea").on("click", function() {
// 			alert("textarea 클릭!");
// 		});
		
		// div 영역("clickDiv") 클릭 이벤트
		$("#clickDiv").on("click", function() {
			alert("div 클릭!");
		});
		
		// textarea focus, blur 이벤트 처리
		$("#resultArea").on("focus", function() {
			$("#resultArea").html("textarea focus in");
		});
		
		$("#resultArea").on("blur", function() {
			$("#resultArea").html("textarea focus out");
		});
		
	});
</script>
</head>
<body>
	<h1>jQuery - test9.jsp</h1>
	<div id="wrap">
		<div id="inputBox">
			아이디 : <input type="text" name="id"><br>
			패스워드 : <input type="password" name="passwd"><br>
			<select id="selectBox" name="subject">
				<option value="">선택하세요</option>
				<option value="자바">자바</option>
				<option value="JSP">JSP</option>
				<option value="스프링">스프링</option>
			</select>
		</div>
		<textarea rows="5" cols="20" id="resultArea"></textarea>
		<br>
		<input type="button" value="확인">
		<input type="button" value="취소">
	</div>
	<br>
	-----------
	<div id="clickDiv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	-----------
</body>
</html>














