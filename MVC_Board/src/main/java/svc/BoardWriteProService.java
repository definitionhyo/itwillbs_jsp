package svc;

import java.sql.Connection;

import dao.BoardDAO;
import dao.MemberDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registBoard(BoardBean board) {
		// 1. 작업 요청 처리 결과를 저장할 boolean 타입 변수 선언
		boolean isWriteSuccess = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 insertBoard() 메서드를 호출하여 글쓰기 작업 요청
		//    => 파라미터 : BoardBean 객체   리턴타입 : int(insertCount)
		int insertCount = dao.insertBoard(board);
		
		// 6. DB 작업 요청 처리 결과에 따른 트랜잭션 처리
		if(insertCount > 0) { // 성공 시
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else { // 실패 시
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		// 8. 처리 결과 리턴
		return isWriteSuccess;
	}
	
}
