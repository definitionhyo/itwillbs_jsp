package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardReplyProService {

	// 답글 쓰기 요청
	public boolean registReplyBoard(BoardBean board) {
		boolean isWriteSuccess = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
//		// 5. BoardDAO - updateBoardReSeq() 메서드를 호출하여 
//		//    기존 답글들의 순서번호 변경 작업 수행
//		// => 파라미터 : BoardBean 객체   리턴타입 : int(updateCount)
//		int updateCount = dao.updateBoardReSeq(board);
//		
//		// 6. BoardDAO - insertReplyBoard() 메서드를 호출하여 글 수정 작업 수행
//		// => 파라미터 : BoardBean 객체   리턴타입 : int(insertCount)
//		int insertCount = dao.insertReplyBoard(board);
//		
//		// 작업 성공 시 commit 수행 및 isDeleteSuccess 를 true 로 변경
//		// 실패 시 rollback 수행
//		if(updateCount > 0 && insertCount > 0) {
//			JdbcUtil.commit(con);
//			isWriteSuccess = true;
//		} else {
//			JdbcUtil.rollback(con);
//		}
		
		// --------------------------------------------------------------------
		// 5. BoardDAO - insertReplyBoard() 메서드를 호출하여 글 수정 작업 수행
		// => 파라미터 : BoardBean 객체   리턴타입 : int(insertCount)
		// => BoardDAO 의 메서드 내부에서 UPDATE 와 INSERT 작업 차례대로 수행할 경우
		int insertCount = dao.insertReplyBoard(board);
		
		// 작업 성공 시 commit 수행 및 isDeleteSuccess 를 true 로 변경
		// 실패 시 rollback 수행
		if(insertCount > 0) {
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return isWriteSuccess;
	}

}
