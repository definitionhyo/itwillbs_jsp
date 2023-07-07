package jsp08_jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/JdbcConnectMain")
@WebServlet("/jsp08_jdbc/JdbcConnectMain")
public class JdbcConnectMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnectMainServlet");
		
		/*
		 * 서블릿 주소 매핑을 "/JdbcConnectMain" 으로 수행하는 경우
		 * 실제 주소가 "http://localhost:8080/StudyJSP/JdbcConnectMain" 이다.
		 * 이 때, StudyJSP(컨텍스트 루트) 에 해당하는 JSP 폴더 위치는 webapp 이므로
		 * webapp/jsp08_jdbc/jdbc_connect_main.jsp 페이지를 대상으로 지정하려면
		 * webapp 폴더 기준 나머지 경로 및 파일명을 명시해야한다!
		 */
//		String target = "jsp08_jdbc/jdbc_connect_main.jsp";
		
		// JSP 페이지 지정 시 루트(/)부터 경로를 작성해도 webapp 기준으로 지정됨
//		String target = "/jsp08_jdbc/jdbc_connect_main.jsp";
		
		// ========================================================================
		/*
		 * 서블릿 주소 매핑을 "/jsp08_jdbc/JdbcConnectMain" 으로 수행하는 경우
		 * 실제 주소가 "http://localhost:8080/StudyJSP/jsp08_jdbc/JdbcConnectMain" 이다.
		 * 이 때, StudyJSP(컨텍스트 루트) 에 해당하는 JSP 폴더 위치가 webapp 이며
		 * 루트로부터 /jsp08_jdbc/JdbcConnectMain 주소를 요청하므로
		 * webapp 폴더 내의 jsp08_jdbc 폴더가 기준 폴더가 된다.
		 * 따라서, 파일명을 명시할 경우 jsp08_jdbc 폴더명을 생략하거나
		 * 루트(/) 부터 경로를 작성해야 JSP 페이지에 접근할 수 있다!
		 */
//		String target = "jdbc_connect_main.jsp"; // 폴더명을 생략하고 파일명만 지정
		String target = "/jsp08_jdbc/jdbc_connect_main.jsp"; // 루트부터 경로 모두 지정
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}

}













