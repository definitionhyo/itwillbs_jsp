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
			영화진흥위원회 오픈 API 를 활용하여 영화 정보 JSON 데이터 처리
			https://www.kobis.or.kr/kobisopenapi/homepg/main/main.do
			--------------------------------------------------------------
			일별 박스오피스 목록 조회 후 #resultArea 영역 테이블에 표시
			https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchDailyBoxOffice
			=> 페이지 내의 요청 URL 을 지정된 요청 파라미터 형식에 맞게 수정 필요
			
			샘플 API 요청 주소(단, 대상 조회일자(targetDt)는 어제(2023.07.04)로 변경)
			https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230704
			*/
			let url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
			let key = "f5eef3421c602c6cb7ea224104795888";
			
			// 조회일자(yyyymmdd)
// 			let targetDt = "20230704";
			
			// --------------------------------------------------------------------
			// 조회일자를 캘린더에서 선택할 경우(미선택 시 "", 선택 시 yyyy-mm-dd)
			let selectedDate = $("#date").val(); // 2023-07-04
// 			alert(selectedDate);
			
			// 날짜 미선택 시 캘린더에 포커스 주기(포커스 요청 후 함수 실행 종료)
			if(selectedDate == "") {
				alert("날짜 선택 필수!");
				$("#date").focus();
				return; // 요청이 진행되지 않도록 함수 실행 종료
			}
			
			// ---------------------------------------------------------------------
			// 1. 선택된 날짜를 파라미터(문자열)로 사용하여 Date 객체 생성
			let objDate = new Date(selectedDate);
// 			alert(objDate); // Tue Jul 04 2023 09:00:00 GMT+0900 (한국 표준시)
	
			// 전달받은 날짜(Date 객체)를 활용하여 요청 파라미터 타입(yyyymmdd)으로 변환
			// => Date 객체의 메서드를 활용하여 연, 월, 일 데이터 가져오기
			// 1) 연도 4자리 가져오기
// 			let year = objDate.getFullYear();
// 			// 2) 월 2자리 가져오기 => 주의! 0 ~ 11월로 처리되므로 + 1 필수!
// 			let month = objDate.getMonth() + 1;
// 			// 3) 일 2자리 가져오기
// 			let day = objDate.getDate(); // 주의! getDay() 는 요일
// 			alert(year + ", " + month + ", " + day); // 2023, 7, 5
// 			alert(typeof year + ", " + typeof month + ", " + typeof day); // 2023, 7, 5
			// => 파싱된 날짜는 number 타입이며, 월, 일의 경우 1자리일 때 0 붙여야함
			//    따라서, 추가적인 작업이 더 수행되어야 yyyymmdd 형식으로 표현 가능
			// --------------------------------------------------------------------
			// 2. 캘린더에서 선택된 날짜를 문자열로 그대로 처리
			// => 전달받은 형식 : yyyy-mm-dd
			// => 파라미터로 전달할 날짜 형식 : yyyymmdd
			// 따라서, 조회 대상 일자에 맞는 형식으로 포맷 변환 필요('-' 문자 제거)
			// ----------
			// 1) split() 메서드를 통해 기준 문자열("-") 를 기준으로 문자열 분리
// 			let splitDate = selectedDate.split("-");
// 			let targetDt = splitDate[0] + splitDate[1] + splitDate[2];
// 			alert("split() 결과 : " + targetDt); // 20230705
			
			// 2) replace() 메서드를 통해 "-" 문자를 널스트링("") 으로 치환
// 			let targetDt = selectedDate.replace("-", ""); // 202307-05
			// replace() 메서드를 연속으로 2번 호출 시 "-" 문자 2개 제거
// 			let targetDt = selectedDate.replace("-", "").replace("-", ""); // 20230705
// 			alert("replace() 결과 : " + targetDt); 
			
			// 3) replaceAll() 메서드로 "-" 문자를 널스트링("") 으로 치환
// 			let targetDt = selectedDate.replaceAll("-", ""); // 20230705
// 			alert("replaceAll() 결과 : " + targetDt); 
			
			// 4) replace() 메서드의 정규표현식 기능을 활용하여 치환
			// => 파라미터 중 첫번째 파라미터(탐색할 문자열)에 정규표현식으로
			//    치환에 사용될 대상 문자열을 지정할 수 있다! => 복합 규칙 설정 가능
			// => 단, 복수개의 문자열을 탐색 대상으로 지정해야할 경우
			//    정규표현식 플래그를 활용하여 모든 문자열 대상 지정 필요
			//    참고) 정규표현식 플래그 종류
			//    a) /g(global) : 대상 문자열 내에서 패턴에 해당되는 모든 대상 지정
			//    b) /i(ignore case) : 대상 문자열을 대소문자 무시하고 지정
			//    c) /m(multi line) : 대상 문자열이 복수개의 라인일 경우 전체 라인 지정
			let targetDt = selectedDate.replace(/-/g, ""); // 한 라인의 모든 "-" 제거
// 			alert("replace() 결과 : " + targetDt); // 20230705
			// --------------------------------------------------------------------
			$.ajax({
				type: "GET",
				url: url + "?key=" + key + "&targetDt=" + targetDt,
				dataType: "json",
				success: function(data) { // 요청 성공 시	
					// 임시) #resultArea 영역에 응답 데이터를 문자열로 출력
// 					$("#resultArea").html(JSON.stringify(data));
					// -------------------------------------------------------
					// 응답데이터(박스오피스 목록 = data 객체)로부터 박스오피스 정보 추출
					// => 전체 데이터가 하나의 객체({})로 묶여 있음
					// 1. 박스오피스 목록 전체 데이터가 저장된 "boxOfficeResult" 객체 추출
					let boxOfficeResult = data.boxOfficeResult;
// 					$("#resultArea").html(JSON.stringify(boxOfficeResult));
					
					// 2. 박스오피스 타입(boxofficeType), 조회날짜(showRange) 추출
					// => 1번에서 추출한 boxOfficeResult 객체를 통해 접근
					// => 두 데이터는 객체가 아닌 일반 속성이므로 변환 없이도 접근 가능
					let boxOfficeType = boxOfficeResult.boxofficeType;
					let showRange = boxOfficeResult.showRange;
// 					$("#resultArea").html(boxOfficeType + ", " + showRange);
					
					// 3. 일별 박스오피스 목록(dailyBoxOfficeList) 추출
					// => 복수개의 영화정보 객체{}가 dailyBoxOfficeList 배열[]로 관리됨
					// => 단, 배열 내의 데이터도 객체이므로 전체 출력 시 변환 필요
					let dailyBoxOfficeList = boxOfficeResult.dailyBoxOfficeList;
// 					$("#resultArea").html(JSON.stringify(dailyBoxOfficeList));
					
					// 4. 추출된 박스오피스 목록(배열)을 반복문을 통해 접근하여
					//    순위(rank), 제목(movieNm), 개봉일(openDt), 누적관객수(audiAcc) 
					//    추출 후 테이블에 추가
					// => 단, 기존 영화 목록 제거 후 새로 추가
// 					$("#resultArea > table").remove(); // 선택자 요소까지 제거
// 					$("#resultArea > table").empty(); // 선택자 요소내의 요소만 제거
					// => 테이블을 미리 생성해두었으므로 영화목록만 제거
					$(".movieItem").remove();
					
					for(let movie of dailyBoxOfficeList) {
						// 영화 상세 정보 조회 요청에 사용될 URL 지정
						// API 페이지 : https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchMovieInfo
						// 요청 URL 샘플 : http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20124079
// 						let detailUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json";
						let detailUrl = "test6_json_movie_detail.jsp?movieCd=" + movie.movieCd;
						
						$("#resultArea > table").append(
							"<tr class='movieItem'>"
							+ "<td>" + movie.rank + "</td>"
							+ "<td>" + movie.movieNm + "</td>"
							+ "<td>" + movie.openDt + "</td>"
							+ "<td>" + movie.audiAcc + "</td>"
							+ "<td>" + movie.movieCd + "</td>"
							+ "<td><input type='button' value='상세정보' onclick=''></td>"
							+ "</tr>"
					);
				}
				},
				error: function() { // 요청 실패 시
					$("#resultArea").html("<h1>요청 실패!</h1>");
				}
			});
			
		}); // 버튼 이벤트 끝
		
	});
</script>
</head>
<body>
	<h1>test5_json_movie_list.jsp - 일별 박스오피스</h1>
	<input type="date" id="date">
	<input type="button" value="일별 박스오피스 조회" id="btnOk">
	<div id="resultArea">
		<table border="1">
			<tr>
				<th width="80">현재순위</th>
				<th width="400">영화명</th>
				<th width="150">개봉일</th>
				<th width="100">누적관객수</th>
				<th width="100">영화코드</th>
				<th></th>
			</tr>
		</table>
	</div>
</body>
</html>













