package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/StudyServlet/myServlet3 서블릿 주소 매핑할 TestMyServlet3 클래스 정의
// => web.xml 파일을 통해 매핑하는 대신 @WebServlet 어노테이션을 사용하여 매핑 설정
// => 서블릿 클래스 상단에 @WebServlet("/서블릿주소") 형식으로 어노테이션 설정
@WebServlet("/myServlet3")
public class TestMyServlet3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식 요청이 발생할 경우 자동으로 호출되는 메서드
		System.out.println("TestMyServlet3 - doGet() 메서드 호출됨!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 요청이 발생할 경우 자동으로 호출되는 메서드
		System.out.println("TestMyServlet3 - doPost() 메서드 호출됨!");
	}
	
}














