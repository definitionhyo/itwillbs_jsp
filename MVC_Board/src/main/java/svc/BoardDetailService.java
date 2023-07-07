package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardDetailService {
	
	// 게시물 상세 정보 조회 요청
	public BoardBean getBoard(int board_num) {
		BoardBean board = null;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoard() 메서드를 호출하여 게시물 상세 정보 조회
		//    => 파라미터 : 글번호   리턴타입 : BoardBean(board)
		board = dao.selectBoard(board_num);
		
		// 리턴받은 BoardBean 객체가 null 이 아닐 때
		// BoardDAO - updateReadcount() 메서드를 호출하여 조회수 증가 작업 수행
		// => 파라미터 : 글번호   리턴타입 : int(updateCount)
		int updateCount = dao.updateReadcount(board_num);
		
		// 작업 성공 시 commit 수행 및 BoardBean 객체의 readcount 값 1 증가
		// 실패 시 rollback 수행
		if(updateCount > 0) {
			JdbcUtil.commit(con);
			board.setBoard_readcount(board.getBoard_readcount() + 1);
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return board;
	}

}
