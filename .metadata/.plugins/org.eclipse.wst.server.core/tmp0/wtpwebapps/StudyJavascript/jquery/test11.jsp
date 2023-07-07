<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.7.0.js"></script>
<script type="text/javascript">
	// on("change", function() {})
	// => 특정 대상의 "상태가 변하면" 동작하는 이벤트 처리
	$(function() {
		$("table").css("text-align", "center");
		$("table").css("width", "400px");
		// -----------------------------------------
		// 전체선택 체크박스 상태 변화 감지 이벤트
		$("#allCheck").on("change", function() {
			// 전체선택 체크 시 모든 체크박스 체크, 체크 해제 시 모두 해제
// 			if($("#allCheck").prop("checked")) { // 체크 시
// 				alert("체크!");
// 			} else { // 체크해제 시
// 				alert("체크해제!");
// 			}
			
			if($("#allCheck").is(":checked")) { // 체크 시
				// 체크박스들의 checked 속성값을 체크 상태(true)로 변경 - prop() 활용
				// => input[type=checkbox] 대신 가상선택자 :checkbox 사용 가능
				// => prop() 메서드 파라미터로 속성명, 속성값 전달 시 속성 변경 가능
				$(":checkbox").prop("checked", true); // 체크 상태를 체크(true)로 변경

				// each() 메서드를 통해 체크박스 반복으로 각 요소의 상태 변경도 가능함
// 				$(":checkbox").each(function(index, item) {
// // 					$(item).prop("checked", true);
// 					$(this).prop("checked", true);
// 				});
			} else { // 체크해제 시
				$(":checkbox").prop("checked", false); // 체크 상태를 체크해제(false)로 변경
			}
		});
		
		// 셀렉트박스 항목 선택(변경) 시 이벤트 처리
		$("#selectBox").on("change", function() {
// 			alert($("#selectBox").val() + " 선택됨!");

			// 셀렉트박스의 특정 항목 선택 여부 판별 시(전체 선택 여부 판별)
// 			if($("#selectBox").val() == "전체") {
// 				alert("전체 선택");
// 			}
			
			if($("#selectBox > option").eq(0).is(":checked")) {
				alert("전체 선택");
			}
			
		});
		
		// 텍스트 박스에 대한 입력값 이벤트
		// blur : 포커스가 해제될 때 이벤트 수행(값 변경과는 무관)
		// keyup : 키보드를 눌렀다 뗄 때 이벤트 수행(값 변경과는 무관함)
		// change : 이전 동작 기준으로 현재 값이 변경됐을 때 이벤트 수행
		//          => 값 변경 없으면 이벤트 동작 X
// 		$("input[name=searchKeyword]").on("blur", function() {
// 			alert("포커스 해제!");
// 			$("#result").html($("input[name=searchKeyword]").val());
// 		});
		
// 		$("input[name=searchKeyword]").on("keyup", function() {
// 			alert("키보드 눌렀다 뗌!");
// 			$("#result").html($("input[name=searchKeyword]").val());
// 		});
		
		$("input[name=searchKeyword]").on("change", function() {
			alert("내용 변경됨!");
			$("#result").html($("input[name=searchKeyword]").val());
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test11.jsp</h1>
	<table border="1">
		<tr>
			<td colspan="3">
				<select id="selectBox" name="grade">
					<option value="전체">전체</option>
					<option value="VIP">VIP</option>
					<option value="일반">일반</option>
				</select>
			</td>
		</tr>
		<tr>
            <th><input type="checkbox" id="allCheck"></th>
            <th>번호</th>
            <th>이름</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="check"></td>
            <td>1</td>
            <td>홍길동</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="check"></td>
            <td>2</td>
            <td>이순신</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="check"></td>
            <td>3</td>
            <td>강감찬</td>
        </tr>
        <tr>
        	<td colspan="3">
        		<select id="searchType" name="searchType">
					<option value="이름">이름</option>
					<option value="아이디">아이디</option>
				</select>
        		<input type="text" name="searchKeyword" placeholder="검색어입력">
        	</td>
        </tr>
	</table>
   	<div id="result"></div>
</body>
</html>












