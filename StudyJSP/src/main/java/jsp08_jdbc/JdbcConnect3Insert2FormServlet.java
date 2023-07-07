package jsp08_jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp08_jdbc/JdbcConnect3_INSERT2_Form")
public class JdbcConnect3Insert2FormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3Insert2FormServlet");
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("jdbc_connect3_insert2_form.jsp");
		dispatcher.forward(request, response);
	}

}















