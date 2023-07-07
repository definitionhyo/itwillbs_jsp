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

@WebServlet("/jsp08_jdbc/JdbcConnect3_INSERT")
public class JdbcConnect3InsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3InsertServlet");
		
		// DB 자원을 관리하는 Connection, PreparedStatement 타입 변수 선언
		// => finally 블럭에서 close() 메서드 호출하려면 try 블럭보다 위에 선언 필요
		Connection con = null;
		PreparedStatement pstmt = null;
		
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
			// => DB 연결 성공 시 java.sql.Connecion 타입 객체 리턴됨
			//    (DB 접속 정보를 관리하는 객체)
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
			
			/*
			 -----------------------------------------------------------------			
			 2단계까지는 DB 제품별로 정보(문자열)가 달라지는 부분이며
			 3단계부터는 실제 DB 내의 SQL 구문을 실행하므로 공통 작업에 해당함
			 -----------------------------------------------------------------
			 study_jsp5.jsp08_student 테이블 생성
			 => 번호(idx, 정수), 이름(name, 문자 16자)
			 CREATE TABLE jsp08_student (
			 	idx INT,
			 	name VARCHAR(16)
			 );
			 */
			// --------------------------------------------------------------------
			// 3단계. SQL 구문 작성 및 전달
			// - jsp08_student 테이블에 번호(idx)와 이름(name) 추가하는 INSERT 구문 작성
			//   임의의 데이터 : 번호 - 1, 이름 - '홍길동'
//			String sql = "INSERT INTO jsp08_student VAL (1, '홍길동')";
//			String sql = "INSERT INTO jsp08_student VALUES (2, '이순신')";
			// - Connection 객체의 prepareStatement() 메서드를 호출하여 SQL 구문 전달
			//   => 파라미터 : SQL 구문(문자열)   리턴타입 : java.sql.PreparedStatement
//			pstmt = con.prepareStatement(sql); // SQL 문장 관리하는 객체
			
			// -------------------------------------------------------------------
			// 외부로부터 추가할 레코드의 데이터를 입력받아 변수에 저장했다고 가정
			int idx = 4;
			String name = "김태희";
			
			// SQL 구문 작성 시 변수값을 SQL 구문에 포함시키는 방법 2가지
			// 1) SQL 구문 작성 시 문자열 결합을 통해 변수값을 포함(추천X)
			// => CREATE 구문 등을 사용할 경우에는 사용하기도 하나, 데이터 추가 시 사용X
			// => 다른 데이터타입을 제외하고 문자열의 경우 작은따옴표로 둘러싸서 표현하므로
			//    변수 결합 시 작은따옴표는 그대로 유지해야함
//			String sql = "INSERT INTO jsp08_student VALUES (" + idx + ", '" + name + "')";
//			pstmt = con.prepareStatement(sql); // SQL 문장 관리하는 객체
			// => 문제점. SQL 구문 구조를 알 수 있으면 SQL 삽입 공격의 대상이 된다!
			
			// 2) SQL 구문 작성 시 데이터가 위치할 부분을
			//    만능문자(Wildcard) 파라미터인 ? 기호로 먼저 채우고
			//    나중에 별도로 만능문자 부분에 데이터 교체 작업 수행(추천!!)
			// 2-1) SQL 구문 내에 데이터 부분을 만능문자(?) 로 표기
			//      (문자열을 별도로 구별할 필요없이 무조건 ? 기호로 표시만 함)
			String sql = "INSERT INTO jsp08_student VALUES (?, ?)";
			pstmt = con.prepareStatement(sql);
			// 2-2) SQL 문장을 전달받은 PreparedStatement 객체의 setXXX() 메서드를 호출하여
			//      만능문자(?) 부분을 실제 사용할 데이터로 교체
			//      => setXXX(index, data) 메서드의 XXX 은 교체할 데이터의 자바 데이터타입 이름 사용
			//         ex) 정수형 데이터 교체 시 : setInt()
			//             문자열 데이터 교체 시 : setString()
			//      => 첫번째 파라미터 : 만능문자의 순서번호
			//      => 두번째 파라미터 : 만능문자 부분에 교체할 데이터
			//      => 주의! 모든 만능문자에 모든 데이터가 전달되어야 한다!
			//         빠진 데이터가 있을 경우 예외 발생
			
			// 첫번째(1번인덱스) 만능문자에 int 타입 변수 idx 값 전달
			pstmt.setInt(1, idx); 
			// 두번째(2번인덱스) 만능문자에 String 타입 변수 name 값 전달
			pstmt.setString(2, name);
			
			// 주의! 2개의 만능문자가 있을 때 1개의 데이터만 설정한 경우
			// java.sql.SQLException: No value specified for parameter 2 예외 발생함
			// => 2번째 파라미터의 값이 정의되지 않았다(데이터 없음)는 의미
			
//			pstmt.setString(3, name);
			// 주의! 2개의 만능문자가 있을 때 1, 2번이 아닌 더 큰 번호를 지정한 경우
			// java.sql.SQLException: Parameter index out of range (3 > number of parameters, which is 2). 예외 발생
			// => 현재 파라미터 최대값 2보다 더 큰 번호가 지정되어 범위를 벗어났다는 의미 
			
			// 만약, 결합된 데이터가 포함된 SQL 문장 확인하려면 PreparedStatement 객체 출력
			System.out.println(pstmt);
			// -------------------------------------------------------------------
			// 4단계. SQL 구문 실행 및 결과 처리
			// - INSERT 구문이므로 PreparedStatement 객체의 executeUpdate() 메서드 호출
			// => 파라미터 : 없음   리턴타입 : int
			int insertCount = pstmt.executeUpdate();
			System.out.println("회원 추가(INSERT) 성공! - " + insertCount + "개 레코드");
		} catch (ClassNotFoundException e) {
			// 1단계 - 드라이버 로드 작업 실패 시 실행되는 코드들...
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 2단계 - DB 연결 작업 실패 시 실행되는 코드들...
			// 3단계, 4단계 - SQL 구문 작업 실패 시에도 실행되는 코드들...
			System.out.println("DB 연결 실패! 또는 SQL 구문 오류 발생!");
			e.printStackTrace();
		} finally {
			// finally 블럭 : try 블럭 내에서 예외(Exception) 발생 여부와 관계없이
			// 				  항상 마지막에 실행되는 블럭
			// 따라서, DB 자원 사용 후 반납하는 close() 메서드를
			// finally 블럭에서 호출하면 예외가 발생하더라도 무조건 자원 반환 가능!
			// 이 때, 자원 반환 순서는 자원 생성 순서의 역순으로 반환
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}











