<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 내장 객체 중 response 객체의 sendRedirect() 메서드를 사용하여
// responseTest2.jsp 페이지로 이동(리다이렉트)
response.sendRedirect("responseTest2.jsp");
// => 서버가 응답하는 데이터에 리다이렉트가 포함될 경우
//    응답 데이터를 수신한 클라이언트는 
//    리다이렉트 대상 URL 을 다시 요청 정보에 포함하여 서버로 전송한다!
// => 따라서, 이 코드에 의해 클라이언트로부터 새로운 요청이 즉시 발생하므로
//    클라이언트에서는 responseTest1.jsp 페이지의 내용은 볼 수 없고
//    리다이렉트 되는 responseTest2.jsp 페이지를 최종적으로 보게 된다!

%>
<script>
alert("이 코드는 리다이렉트에 의해 실행되지 못한다!");
</script>














