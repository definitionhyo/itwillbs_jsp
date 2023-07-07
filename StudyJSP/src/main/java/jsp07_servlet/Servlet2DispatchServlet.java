package jsp07_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/dispatchServlet")
public class Servlet2DispatchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet2DispatchServlet");
		
		// 폼에서 입력받은 파라미터(이름, 나이) 가져와서 변수에 저장 후 출력
		String name = request.getParameter("name");
		// 단, 파라미터를 정수 데이터로 변환해야할 경우
		// Integer 클래스의 static 메서드 parseInt() 메서드에 String 타입 데이터 전달
		// => 주의! 반드시 문자열 형태의 정수만 사용해야한다! (다른 타입 오류 발생!)
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		// 작업 완료 후 servlet2_dispatch_result.jsp 로 포워딩(Dispatch)
		// 1. request 객체의 getRequestDispatcher() 메서드 호출
		// => 파라미터 : 포워딩 할 페이지   리턴타입 : javax.servlet.RequestDispatcher
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("servlet2_dispatch_result.jsp");
		
		// 2. RequestDispatcher 객체의 forward() 메서드를 호출하여 포워딩 작업 수행
		// => 파라미터 : request 객체, response 객체
		dispatcher.forward(request, response);
		
		// -----------------------------------------------------------------------
		// Dispatch 방식 포워딩 특징
		// 1. 포워딩 시 지정한 주소(요청받은 새 주소)가 웹브라우저 주소표시줄에 표시되지 않고
		//    이전 요청 주소가 그대로 유지됨(= 주소표시줄 주소가 변경되지 않음)
		//    => http://localhost:8080/StudyJSP/jsp07_servlet/dispatchServlet 주소 유지된 채로
		//       servlet2_dispatch_result.jsp 페이지로 포워딩함
		// 2. 이전 요청에서 생성된 request 객체를 포워딩 시점에서 함께 전달하므로
		//    포워딩 후에도 기존 request 객체(response 포함)가 그대로 유지됨
		//    따라서, 원래 저장되어 있던 파라미터 등의 데이터도 그대로 유지됨
		//    => 즉, 새 페이지에서 기존 저장된 데이터 공유 가능함
	}

}














