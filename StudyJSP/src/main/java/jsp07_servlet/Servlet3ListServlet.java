package jsp07_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/jsp07_servlet3_list")
public class Servlet3ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3ListServlet");
		
		// 서블릿 요청에 대해 servlet3_list.jsp 페이지로 포워딩
		// => 서블릿 주소를 유지한 채로 JSP 파일명을 숨기기 위해 Dispatch 방식 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("servlet3_list.jsp");
		dispatcher.forward(request, response);
	}

}










