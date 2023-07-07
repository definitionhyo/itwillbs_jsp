package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;

public class BoardDeleteProService {

	// 글 삭제를 위한 패스워드 판별 요청
	public boolean isBoardWriter(int board_num, String board_pass) {
		boolean isBoardWriter = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardWriter() 메서드를 호출하여 패스워드 판별 수행
		//    => 파라미터 : 글번호, 패스워드   리턴타입 : boolean(isBoardWriter)
		isBoardWriter = dao.selectBoardWriter(board_num, board_pass);
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		// 판별 결과 리턴
		return isBoardWriter;
	}

	// 글 삭제 요청
	public boolean removeBoard(int board_num) {
		boolean isDeleteSuccess = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO - deleteBoard() 메서드를 호출하여 글 삭제 작업 수행
		// => 파라미터 : 글번호   리턴타입 : int(deleteCount)
		int deleteCount = dao.deleteBoard(board_num);
		
		// 작업 성공 시 commit 수행 및 isDeleteSuccess 를 true 로 변경
		// 실패 시 rollback 수행
		if(deleteCount > 0) {
			JdbcUtil.commit(con);
			isDeleteSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return isDeleteSuccess;
	}

	// 삭제할 파일 조회 요청
	public String getBoardRealFile(int board_num) {
		String board_real_file = null;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardRealFile() 메서드를 호출하여 실제 파일명 조회 수행
		//    => 파라미터 : 글번호   리턴타입 : String(board_real_file)
		board_real_file = dao.selectBoardRealFile(board_num);
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		// 판별 결과 리턴
		return board_real_file;
	}

}
















