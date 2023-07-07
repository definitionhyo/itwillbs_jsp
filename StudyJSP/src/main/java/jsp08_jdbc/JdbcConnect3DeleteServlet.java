package jsp08_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp08_jdbc/JdbcConnect3_DELETE")
public class JdbcConnect3DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3DeleteServlet");

		// DB 자원을 관리하는 Connection, PreparedStatement 타입 변수 선언
		// => finally 블럭에서 close() 메서드 호출하려면 try 블럭보다 위에 선언 필요
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1단계. JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공!");
			
			// 2단계. DB 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp5", "root", "1234");
			System.out.println("DB 연결 성공!");
			
			// 3단계. SQL 구문 작성 및 전달
			// 번호가 1번인 레코드 삭제하는 DELETE 구문 작성
//			String sql = "DELETE FROM jsp08_student WHERE idx = 1";
//			PreparedStatement pstmt = con.prepareStatement(sql);
			// ---------------
			// 만능문자(?) 파라미터를 활용한 PreparedStatement 객체 사용 시
			int idx = 1;
			String sql = "DELETE FROM jsp08_student WHERE idx = ?";
			pstmt = con.prepareStatement(sql);
			// 첫번째 파라미터를 int 타입 변수 idx 로 교체
			pstmt.setInt(1, idx);
			System.out.println(pstmt);
			
			// 4단계. SQL 구문 실행 및 결과 처리
			int deleteCount = pstmt.executeUpdate();
			System.out.println("DELETE 구문 실행 성공! - " + deleteCount + "개 레코드");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!");
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
