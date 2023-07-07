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
	submit()
	- submit 동작에 대한 이벤트 처리 가능한 메서드
	- 자바스크립트에서의 기본적인 submit 처리 방법과 동일
	=> form 태그 지정 후 submit() 메서드를 호출하여 수행할 동작을 익명함수로 구현
	*/
	$(function() {
		$("form").submit(function() {
			// id 선택자 "selectBox"의 자식 option 요소들 중
			// 첫번째 option 태그의 selected 속성값 출력 => prop() 메서드 활용
// 			alert($("#selectBox > option").eq(0).prop("selected"));
			
			// 만약, 첫번째 option 태그의 selected 속성 상태가 true 일 경우(선택된 경우)
			// "항목 선택 필수!" 출력 후 폼 전송 취소(return false), 
			// 아니면 폼 전송 수행(return true)
// 			if($("#selectBox > option").eq(0).prop("selected")) { // 선택된 경우(true)
// 				alert("항목 선택 필수!");
// 				$("#selectBox").focus(); // 해당 요소에 포커스
// 				return false; // 폼 전송 취소
// 			} else { // 다른 항목 선택된 경우(false)
// 				return true; // 폼 전송 수행
// 			}
			
			// selectbox 미선택, inputbox 미입력 시 폼 전송 취소 
			if($("#selectBox > option").eq(0).prop("selected")) { // 첫번째 항목 선택된 경우(true)
				alert("항목 선택 필수!");
				$("#selectBox").focus(); // 해당 요소에 포커스
				return false; // 폼 전송 취소
			} else if($("input[name=id]").val() == "") { // 아이디가 미입력된 경우
				alert("아이디 입력 필수!");
				$("input[name=id]").focus(); // 해당 요소에 포커스
				return false; // 폼 전송 취소
			} else if($("input[name=passwd]").val() == "") { // 패스워드가 미입력된 경우
				alert("패스워드 입력 필수!");
				$("input[name=passwd]").focus(); // 해당 요소에 포커스
				return false; // 폼 전송 취소
			} else {
				return true; // 폼 전송 수행
			}
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test8.jsp</h1>
	<div id="wrap">
		<form action="test8_result.jsp">
			<div id="inputBox">
				아이디 : <input type="text" name="id"><br>
				패스워드 : <input type="password" name="passwd"><br>
			</div>
			<select id="selectBox" name="subject">
				<option value="">선택하세요</option>
				<option value="자바">자바</option>
				<option value="JSP">JSP</option>
				<option value="스프링">스프링</option>
			</select>
			<br>
			<input type="submit" value="전송">
		</form>
	</div>
</body>
</html>














