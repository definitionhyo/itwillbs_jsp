package jsp10_jdbc_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/jsp10_jdbc_dao/DbcpInsertPro")
public class DbcpInsertProServlet_Backup extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DbcpInsertProServlet");
		
		// 데이터베이스 사용을 위한 변수 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// JdbcUtil 클래스에서 DBCP 를 통해 관리되는 Connection 객체 리턴받기
		// => 1단계 & 2단계에 해당
		con = JdbcUtil.getConnection();
		
		try {
			// 3단계. SQL 구문 작성 및 전달
			// jsp08_student 테이블에 번호, 이름 추가 - INSERT
			// 번호(idx)와 이름(name) 파라미터 가져와서 변수에 저장
			request.setCharacterEncoding("UTF-8"); // POST 방식 한글 인코딩 처리
			int idx = Integer.parseInt(request.getParameter("idx"));
			String name = request.getParameter("name");
			
			String sql = "INSERT INTO jsp08_student VALUES (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, name);
			
			// 4단계. SQL 구문 실행 및 결과 처리
			int insertCount = pstmt.executeUpdate();
			
			// INSERT 작업 결과 판별
			// insertCount 가 0보다 크면 성공, 아니면 실패
			if(insertCount > 0) {
				System.out.println("INSERT 성공! - " + insertCount + "개 레코드");
			} else {
				System.out.println("INSERT 실패!");
			}
		} catch (SQLException e) {
			// DB 연결(2단계) 실패 처리는 JdbcUtil 클래스의 getConnection() 메서드에서
			// SQLException 예외로 처리됨
			System.out.println("SQL 구문 오류 발생!");
			e.printStackTrace();
		} finally {
			// DB 자원 반환
			// => JdbcUtil 클래스의 static 메서드 close() 메서드 호출하여
			//    반환할 자원(객체)를 파라미터로 전달
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		
	}

}















