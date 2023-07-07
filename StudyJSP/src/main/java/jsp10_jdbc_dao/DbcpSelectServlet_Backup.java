package jsp10_jdbc_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/jsp10_jdbc_dao/DbcpSelect")
public class DbcpSelectServlet_Backup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DbcpSelectServlet");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = JdbcUtil.getConnection();
		
		try {
			// 3단계.
			// jsp08_student 테이블의 모든 레코드 조회
			String sql = "SELECT * FROM jsp08_student";
			pstmt = con.prepareStatement(sql);
			
			// 4단계.
			rs = pstmt.executeQuery();
			
			// while 문을 사용하여 다음 레코드가 존재할 동안(rs.next() 가 true) 반복
			while(rs.next()) {
				// ResultSet 객체의 getXXX() 메서드로 각 컬럼 데이터 접근
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				System.out.println("번호 : " + idx + ", 이름 : " + name);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - DbcpSelectServlet 의 doGet()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
	}

}















