<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 확인하기</h1>
	<%
// 	// 자바 코드로 쿠키에 접근하기
// 	String cookieHeader = request.getHeader("Cookie");
			
// 	// 2. 리턴받은 헤더 정보에 대한 문자열이 null 이 아닐 경우 판별
// 	// => 생략 가능
// 	if(cookieHeader != null) { // 쿠키가 존재한다는 의미
// 		// 3. request 객체를 활용하여 클라이언트에 저장된 Cookie 객체(들) 가져오기
// 		// => request 객체의 getCookies() 메서드를 호출하여 Cookie[] 타입으로 리턴받기
// 		Cookie[] cookies = request.getCookies();
		
// // 		4. for 문을 사용하여 Cookie 배열 반복하면서 각 쿠키에 접근
// // 		for(int i = 0; i < cookies.length; i++) {
// // 			Cookie cookie = cookies[i];
// // 		}
		
// 		for(Cookie cookie : cookies) {
// 			// 5. Cookie 객체의 getName(), getValue() 메서드를 통해 쿠키 정보 가져오기
// 			out.print("쿠키명 : " + cookie.getName());
// 			out.print("<br>쿠키값 : " + cookie.getValue());
// 			out.print("<hr>");
// 		}
// 	}
	%>
	
	<%-- 
	EL 을 사용하여 쿠키에 접근 후 데이터 출력하기
	=> 쿠키명 : ${cookie.쿠키이름.name}
	=> 쿠키값 : ${cookie.쿠키이름.value}
	--%>
	<h3>쿠키명 : ${cookie.cookieName.name }</h3>
	<h3>쿠키값 : ${cookie.cookieName.value }</h3>
	
</body>
</html>










