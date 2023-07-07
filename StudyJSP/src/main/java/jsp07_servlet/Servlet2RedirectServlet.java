package jsp07_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/redirectServlet")
public class Servlet2RedirectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet2RedirectServlet");
		
		// 폼에서 입력받은 파라미터(이름, 나이) 가져와서 변수에 저장 후 출력
		String name = request.getParameter("name");
		// 단, 파라미터를 정수 데이터로 변환해야할 경우
		// Integer 클래스의 static 메서드 parseInt() 메서드에 String 타입 데이터 전달
		// => 주의! 반드시 문자열 형태의 정수만 사용해야한다! (다른 타입 오류 발생!)
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		// 현재 서블릿 클래스에서 작업 완료 후 servlet2_redirect_result.jsp 로 리다이렉트
		// => response 객체의 sendRedirect() 메서드 호출하여 리다이렉트 할 페이지 전달
		response.sendRedirect("servlet2_redirect_result.jsp");
		
		// -------------------------------------------------------------
		// Redirect 방식 포워딩 특징
		// 1. 지정한(리다이렉트 된) 주소로 웹브라우저 주소표시줄 주소 변경됨
		//    즉, 요청받은 새 주소로 변경됨
		//     => 이전 요청 주소인 /redirectServlet 서블릿 주소에서
		//        새 요청 주소인 "http://localhost:8080/StudyJSP/jsp07_servlet/servlet2_redirect_result.jsp" 주소로 변경됨
		// 2. 이전 요청에서 생성된 request 와 response 객체가 유지되지 않음
		//    즉, 새로운 request 와 response 객체가 생성됨
		//    => 따라서, 새 페이지에서 이전에 저장된 request 객체 데이터 접근 불가
		
	}

}












