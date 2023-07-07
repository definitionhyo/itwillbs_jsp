package jsp07_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/jsp07_servlet3_writeForm")
public class Servlet3WriteFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3WriteFormServlet");
		
		// http://localhost:8080/StudyJSP/jsp07_servlet/jsp07_servlet3_writeForm
		// 서블릿 요청 시 servlet3_write_form.jsp 페이지로 포워딩
		// => 포워딩 될 새 주소(servlet3_write_form.jsp)를 숨기기 위해
		//    기존 서블릿 주소를 유지해야하므로 Dispatch 방식으로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet3_write_form.jsp");
		dispatcher.forward(request, response);
		
		// Dispatch 방식으로 포워딩 했을 경우
		// 기존 서블릿 주소(http://localhost:8080/StudyJSP/jsp07_servlet/jsp07_servlet3_writeForm)가
		// 새 주소(servlet3_write_form.jsp)로 변경되지 않고 그대로 유지됨
		// 즉, 포워딩 되는 실제 jsp 파일명(디렉토리 구조 포함)이 URL 에 노출되지 않음!
		
	}

}











