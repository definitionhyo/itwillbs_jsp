<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardPro.jsp</h1>
	<%
	// 이전 페이지에서 POST 방식으로 전달받은 파라미터 중 한글 데이터가 포함되면 깨지므로
	// request 객체의 setCharacterEncoding() 메서드를 통해 한글 인코딩 방식 변경 필요
	// => 또한, jsp:forward 액션태그의 jsp:param 태그를 통해 파라미터 전달 시에도
	//    전달할 데이터를 생성하는 시점에 한글 처리가 되어있어야 한다!
	//    즉, forwardPro2.jsp 가 아닌 데이터 생성 위치 forwardPro.jsp 페이지에서
	//    한글 인코딩 방식 지정 필수!
	// => Dispatch 방식 포워딩으로 인해 request 객체가 유지되므로
	//    request 객체에 설정되어 있는 인코딩 방식도 다음 페이지까지 유지됨
	request.setCharacterEncoding("UTF-8");
	
	// 폼 파라미터로 전달받은 데이터(이름, 패스워드) 가져와서 변수에 저장 후 출력
	String name = request.getParameter("name");
	String passwd = request.getParameter("passwd");
	// hidden 타입으로 전달받은 파라미터로 동일한 방식으로 접근
	String jumin = request.getParameter("jumin");
	
	// forward 액션 태그의 param 액션태그에 포함시켜 전달할 데이터를 변수에 저장
	int age = 25;
	
	%>
	<h3>이름 : <%=name %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>주민번호 : <%=jumin %></h3>
	<%--
	=============================================================================
	jsp:forward 액션 태그를 사용하여 "forwardPro2.jsp" 페이지로 포워딩(이동) 수행
	=> pageContext.forward() 메서드와 동일한 작업 수행(= Dispatch)
	=> 주소표시줄의 주소(URL)가 변경되지 않고, request 객체도 유지됨
	=> 만약, 포워딩 과정에서 추가적인 파라미터 전달이 필요할 경우
	   <jsp:forward></jsp:forward> 태그 사이에 <jsp:param> 태그를 사용하여 파라미터 저장
	--%>
<%-- 	<jsp:forward page="forwardPro2.jsp" /> --%>
	<jsp:forward page="forwardPro2.jsp">
		<jsp:param name="paramValue1" value="forward 액션태그의 param 태그 데이터" />
		<jsp:param name="paramValue2" value="<%=age %>" />
	</jsp:forward>
	
</body>
</html>
















