<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/*
	1. ID 중복확인 버튼 클릭 시 새 창(check_id.html) 띄우기
	=> 단, 입력된 ID 텍스트의 길이가 4 ~ 8글자 사이일 때만 새 창을 띄우고
	    아니면, "4~8글자만 사용가능합니다" 메세지 출력하기(alert() 함수 사용)
	=> 새 창 띄울 때 ID중복확인 버튼 우측 빈공간에 "중복확인완료" 표시하기
	*/
	function checkDupId() {
		// 입력받은 ID 값 가져와서 변수에 저장
		let id = document.fr.id.value;
		
		// ID 값에 대한 길이 판별(4 ~ 8글자 사이 여부)
		if(id.length >= 4 && id.length <= 8) { // 유효한 길이일 경우
			// check_id.html 파일을 새 창으로 열기
			window.open("check_id.html", "checkId", "width=400, height=250");
			document.querySelector("#checkIdResult").innerHTML = "중복확인완료";
		} else { // 유효하지 않은 길이
			alert("아이디 4 ~ 8글자 필수!");
			document.querySelector("#checkIdResult").innerHTML = "";
			document.fr.id.select();
		}
		
	}
	
	/*
	2. 비밀번호 입력란에 키를 누를때마다 비밀번호 길이 체크하기
	=> 체크 결과를 비밀번호 입력창 우측 빈공간에 표시하기
	=> 비밀번호 길이 체크를 통해 8 ~ 16글자 사이이면 "사용 가능한 패스워드"(파란색) 표시,
	   아니면, "사용 불가능한 패스워드"(빨간색) 표시
	*/
	function checkPasswd(passwd) {
		// span 태그 영역 객체 가져오기
		let span = document.querySelector("#checkPasswdResult");
		
		// 입력된 패스워드 길이 체크
		if(passwd.length >= 8 && passwd.length <= 16) { // 길이 체크 통과
			span.innerHTML = "사용 가능한 패스워드";
			span.style.color = "BLUE";
		} else {
			span.innerHTML = "사용 불가능한 패스워드";
			span.style.color = "RED";
		}
	}
	
	/*
	3. 비밀번호확인 입력란에 키를 누를때마다 비밀번호와 같은지 체크하기
	=> 체크 결과를 비밀번호확인 입력창 우측 빈공간에 표시하기
	=> 비밀번호와 비밀번호확인 입력 내용이 같으면 "비밀번호 일치"(파란색) 표시,
	   아니면, "비밀번호 불일치"(빨간색) 표시
	*/
	function checkConfirmPasswd(confirmPasswd) {
		// span 태그 영역 객체 가져오기
		let span = document.querySelector("#checkConfirmPasswdResult");
		
		// 패스워드 입력란에 입력된 패스워드 가져오기
		let passwd = document.fr.passwd.value;
		
		// 두 패스워드 일치 여부 판별
		if(passwd == confirmPasswd) { // 두 패스워드 일치
			span.innerHTML = "패스워드 일치";
			span.style.color = "BLUE";
		} else {
			span.innerHTML = "패스워드 불일치";
			span.style.color = "RED";
		}
	}
	
	/*
	4. 주민번호 숫자 입력할때마다 길이 체크하기
	=> 주민번호 앞자리 입력란에 입력된 숫자가 6자리이면 뒷자리 입력란으로 커서 이동시키기
	=> 주민번호 뒷자리 입력란에 입력된 숫자가 7자리이면 뒷자리 입력란에서 커서 제거하기
	*/
	function checkJumin1(jumin1) {
		if(jumin1.length == 6) {
			document.fr.jumin2.focus(); // 포커스(커서) 요청
		}
	}
	
	function checkJumin2(jumin2) {
		if(jumin2.length == 7) {
			document.fr.jumin2.blur(); // 포커스(커서) 해제
		}
	}
	
	/*
	5. 이메일 도메인 선택 셀렉트 박스 항목 변경 시 
	   선택된 셀렉트 박스 값을 이메일 두번째 항목(@ 기호 뒤)에 표시하기
	   단, 직접입력 선택 시 표시된 도메인 삭제하기
	*/
	function selectDomain(domain) {
		// 직접입력의 경우 널스트링("") 값이 할당되어 있으므로
		// 모든 값을 email2 영역에 표시하면 직접입력 선택 시 널스트링이 표시됨
		document.fr.email2.value = domain;
		
		// 추가사항. "직접입력" 항목 외의 도메인 선택 시
		// 도메인 입력창을 잠금처리하고 회색으로 변경
		// 아니면, 도메인 입력창에 커서 요청 및 잠금 해제
		// => 주의! HTML 태그 속성명이 두 단어 이상의 조합일 경우
		//    자바스크립트에서는 Camel-case 표기법으로 속성명을 지정해야한다!
		//    ex) readonly 속성 : readOnly 로 표기
		if(domain != "") { // 도메인 선택 시
// 			document.fr.email2.disabled = true; // 입력창 비활성화
			// => 주의! disabled 속성 지정 시 입력창 잠금은 동일하나 
			//    차후에 폼 데이터 전송 과정에서 해당 데이터는 전송 대상에서 제외됨!
			// => readOnly 속성을 통해 입력창 잠금 후에도 데이터 전송이 가능해진다!
			document.fr.email2.readOnly = true; // 입력창 읽기전용 설정
			document.fr.email2.style.background = "LIGHTGRAY";
		} else { // 직접입력 선택 시
			document.fr.email2.readOnly = false; // 읽기전용 해제
			document.fr.email2.style.background = "WHITE";
			document.fr.email2.focus();
		}
	}
	
	// 6. 취미의 "전체선택" 체크박스 체크 시 취미 항목 모두 체크, 
    //    "전체선택" 해제 시 취미 항목 모두 체크 해제하기
    function checkAll(isChecked) {
// 		if(isChecked) {
// 			document.fr.hobby[0].checked = true;
// 			document.fr.hobby[1].checked = true;
// 			document.fr.hobby[2].checked = true;
// 		} else {
// 			document.fr.hobby[0].checked = false;
// 			document.fr.hobby[1].checked = false;
// 			document.fr.hobby[2].checked = false;
// 		}

//     	document.fr.hobby[0].checked = isChecked;
// 		document.fr.hobby[1].checked = isChecked;
// 		document.fr.hobby[2].checked = isChecked;

		// for...of 문 등의 반복문을 통해 작업 가능
		for(hobby of document.fr.hobby) {
			hobby.checked = isChecked;
		}
	}
	
</script>
</head>
<body>	
	<div align="center">
		<h1>회원 가입</h1>
		<form action="jsp07_join" method="post" name="fr">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" placeholder="4 ~ 8글자 사이 입력">
						<input type="button" value="ID중복확인" onclick="checkDupId()">
						<span id="checkIdResult"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<!-- 키 누를때마다 checkPasswd() 함수에 입력받은 패스워드 전달하여 호출 -->
						<input type="password" name="passwd" onkeyup="checkPasswd(this.value)" placeholder="8 ~ 16글자 사이 입력">
						<span id="checkPasswdResult"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td>
						<!-- 키 누를때마다 checkConfirmPasswd() 함수에 입력받은 패스워드 전달하여 호출 -->
						<input type="password" name="passwd2" onkeyup="checkConfirmPasswd(this.value)">
						<span id="checkConfirmPasswdResult"></span>
					</td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="jumin1" onkeyup="checkJumin1(this.value)"> -
						<input type="text" name="jumin2" onkeyup="checkJumin2(this.value)">
					</td>
				</tr>
				<tr>
					<th>E-Mail</th>
					<td>
						<input type="text" name="email1"> @
						<input type="text" name="email2">
						<select name="emailDomain" onchange="selectDomain(this.value)">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="nate.com">nate.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>직업</th>
					<td>
						<select name="job">
							<option value="">항목을 선택하세요</option>
							<option value="개발자">개발자</option>
							<option value="DB엔지니어">DB엔지니어</option>
							<option value="서버엔지니어">서버엔지니어</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남">남
						<input type="radio" name="gender" value="여">여
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="여행">여행
						<input type="checkbox" name="hobby" value="독서">독서
						<input type="checkbox" name="hobby" value="게임">게임
						<!-- 전체선택 체크박스 클릭 시 체크상태(checked 속성의 true 또는 false) 를 함수에 전달 -->
						<input type="checkbox" value="전체선택" onclick="checkAll(this.checked)">전체선택
					</td>
				</tr>
				<tr>
					<th>가입동기</th>
					<td>
						<textarea rows="5" cols="40" name="motivation"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입">
						<input type="reset" value="초기화">
						<input type="button" value="돌아가기">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>















