<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/*
	[ 자바스크립트에서 정규표현식 활용 방법 ]
	1. 정규표현식 패턴 문자열을 갖는 객체 생성
	   1) let 변수명 = new RegExp("패턴문자열");
	   2) let 변수명 = /패턴문자열/;
	2. 변수명.exec("검사할 문자열") 형태로 유효성 검사
	   => 검사 결과를 판별하여 
	      적합할 경우 대상 문자열 리턴, 부적합할 경우 null 리턴 
	   => 자바스크립트의 if문에 boolean 타입이 아닌 다른 타입의 값이 전달될 경우
	      값이 존재하기만 하면 무조건 true 가 리턴되고, null 이면 false 로 취급됨
	*/
	function checkName(name) {
		// 이름 유효성 검사에 사용할 패턴 문자열을 변수 regex 에 저장
		// => 패턴 규칙 : 한글 2글자 ~ 5글자(처음부터 끝까지 모두 한글만 가능)
// 		let regex = new RegExp("^[가-힣]{2,5}$");
		let regex = /^[가-힣]{2,5}$/;
// 		alert(regex + " : " + typeof(regex));

		// 정규표현식에 따른 유효성 검사를 위해 정규표현식 객체의 exec() 메서드를 호출하여
		// 검증에 사용될 대상 문자열을 파라미터로 전달
// 		alert(regex.exec(name)); // 한글이면 입력데이터 출력, 아니면 null 출력
		
		// if문을 사용하여 정규표현식 검증 코드를 파라미터로 전달 시
		// 규칙에 부합될 경우 해당 문자열이 리턴되므로 true 가 되고,
		// 아니면 null 값이 리턴되어 false 가 된다!
		if(regex.exec(name)) { // 정규표현식과 일치하는 데이터(= 적합한 데이터)일 경우
			// id 선택자가 "checkNameResult" 인 요소에 
			// HTML 태그로 "사용 가능" 문자열 표시(초록색)
			document.querySelector("#checkNameResult").innerHTML = "사용 가능";
			document.querySelector("#checkNameResult").style.color = "green";
		} else { // 정규표현식과 일치하지 않는 데이터(= 부적합한 데이터)일 경우
			// id 선택자가 "checkNameResult" 인 요소에 
			// HTML 태그로 "사용 불가능" 문자열 표시(빨간색)
			document.querySelector("#checkNameResult").innerHTML = "사용 불가능";
			document.querySelector("#checkNameResult").style.color = "red";
		}
		
	}
	
	function checkPhone(phone) {
		/* 
		전화번호 규칙 판별하여 checkPhoneResult 영역에 결과 표시
		- 국번은 010 또는 011 또는 02 또는 051 로 시작하고, 
	      국번 뒤에 하이픈(-) 이 포함되고,
	      가운데 숫자는 3 ~ 4자리로 구성되고, 
	      뒤에 하이픈(-) 이 포함되고,
	      마지막 숫자는 4자리로 끝
	     */
		let regex = /^(010|011|02|051)-[\d]{3,4}-[0-9]{4}$/;
		
		if(regex.exec(phone)) { // 정규표현식과 일치하는 데이터(= 적합한 데이터)일 경우
			// id 선택자가 "checkPhoneResult" 인 요소에 
			// HTML 태그로 "사용 가능" 문자열 표시(초록색)
			document.querySelector("#checkPhoneResult").innerHTML = "사용 가능";
			document.querySelector("#checkPhoneResult").style.color = "green";
		} else { // 정규표현식과 일치하지 않는 데이터(= 부적합한 데이터)일 경우
			// id 선택자가 "checkPhoneResult" 인 요소에 
			// HTML 태그로 "사용 불가능" 문자열 표시(빨간색)
			document.querySelector("#checkPhoneResult").innerHTML = "사용 불가능";
			document.querySelector("#checkPhoneResult").style.color = "red";
		}
	}
	
	function checkIntro(intro) {
// 		alert(intro);
		// 자기소개 항목에 "볼드모트" 라는 문자열 포함되면 오류메세지 "언급 불가!" 출력
		let regex = /볼드모트/;
		
		if(!regex.exec(intro)) {
			document.querySelector("#checkIntroResult").innerHTML = intro + "\n검사 통과";
			document.querySelector("#checkIntroResult").style.color = "green";
		} else {
			document.querySelector("#checkIntroResult").innerHTML = intro + "\n언급 불가!";
			document.querySelector("#checkIntroResult").style.color = "red";
		}
	}
</script>
</head>
<body>
	<h1>test1.jsp - 정규표현식</h1>
	<form action="#">
		<%-- 이름 항목에 변화가 있을 경우 checkName() 함수 호출(파라미터로 입력값 전달) --%>
		이름 <input type="text" name="name" id="name" placeholder="한글2~5글자"
				onchange="checkName(this.value)">
		<span id="checkNameResult"></span><br>
		
		전화번호 
		<input type="text" name="phone" id="phone" placeholder="000-0000-0000 형식"
				onchange="checkPhone(this.value)">
		<span id="checkPhoneResult"></span><br>
		
		자기소개 <textarea rows="5" cols="20" id="intro" onchange="checkIntro(this.value)"></textarea>
		<div id="checkIntroResult"></div><br>
	</form>
</body>
</html>












