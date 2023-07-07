package jsp08_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp08_jdbc/JdbcConnect3_INSERT2_Pro")
public class JdbcConnect3Insert2ProServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3Insert2ProServlet");
		
		// DB 자원을 관리하는 Connection, PreparedStatement 타입 변수 선언
		// => finally 블럭에서 close() 메서드 호출하려면 try 블럭보다 위에 선언 필요
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 외부로부터 추가할 레코드의 데이터를 폼 파라미터로부터 가져오기
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩 변경
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		
		// 폼 파라미터로 전달받은 idx 와 name 값을 사용하여
		// jsp08_student 테이블에 입력받은 번호 및 이름을 추가(INSERT)
		try {
			// 0단계. JDBC 연결에 필요한 문자열을 각각의 변수에 저장
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/study_jsp5";
			String user = "root";
			String password = "1234";
			
			// 1단계. JDBC 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");
			
			// 2단계. DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
			
			// 3단계. SQL 구문 작성 및 전달
			String sql = "INSERT INTO jsp08_student VALUES (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, name);
			System.out.println(pstmt);
			// -------------------------------------------------------------------
			// 4단계. SQL 구문 실행 및 결과 처리
			int insertCount = pstmt.executeUpdate();
			System.out.println("회원 추가(INSERT) 성공! - " + insertCount + "개 레코드");
			
			// =========================================================================
			// 만약, 추가 작업 성공 후 즉시 조회를 수행하려면
			// 조회 작업 수행을 위한 서블릿 주소(JdbcConnect3_SELECT) 요청 - Redirect
			response.sendRedirect("JdbcConnect3_SELECT");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패! 또는 SQL 구문 오류 발생!");
			e.printStackTrace();
		} finally {
			// 자원 반환
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}















