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

@WebServlet("/jsp08_jdbc/JdbcConnect3_UPDATE")
public class JdbcConnect3UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3UpdateServlet");

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
			// 번호가 2 이고 이름이 이순신인 레코드의 이름을 홍길동으로 수정 - UPDATE
			int idx = 2;
			String name = "이순신";
			String newName = "홍길동";
			
			String sql = "UPDATE jsp08_student SET name = ? WHERE idx = ? AND name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newName); // 첫번째 만능문자
			pstmt.setInt(2, idx); // 두번째 만능문자
			pstmt.setString(3, name); // 세번째 만능문자
			System.out.println(pstmt);
			
			// 4단계. SQL 구문 실행 및 결과 처리
			int updateCount = pstmt.executeUpdate();
			System.out.println("UPDATE 구문 실행 성공! - " + updateCount + "개 레코드");
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
