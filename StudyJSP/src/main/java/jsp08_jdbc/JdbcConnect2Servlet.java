package jsp08_jdbc;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/JdbcConnectMain")
@WebServlet("/jsp08_jdbc/JdbcConnect2")
public class JdbcConnect2Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect2Servlet");
		
		try {
			// 1단계. JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// => ClassNotFoundException 예외 발생 예상되므로 예외 처리 필요!
			System.out.println("드라이버 로드 성공!");
			
			// 2단계. DB 연결
			// java.sql.DriverManager 클래스의 static 메서드인 
			// getConnection() 메서드를 호출하여 DB 연결 작업 수행
			// => 파라미터 : DB 접속에 필요한 URL, DB 계정명, 패스워드
			// => URL 형식 : "jdbc:mysql://접속할주소:포트번호/DB명"
            //    ex) jdbc:mysql://localhost:3306/study_jsp5
			// => 연결 성공 시 DB 연결 정보를 관리하는 java.sql.Connection 타입 객체 리턴됨
			DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp5", "root", "1234");
			// => SQLException 예외 발생 예상되므로 예외 처리 필요!
			System.out.println("DB 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
		}
		
	}

}













