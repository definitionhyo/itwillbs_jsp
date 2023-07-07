package svc;

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardListService {
	
	public List<BoardBean> getBoardList(int startRow, int listLimit) {
		List<BoardBean> boardList = null;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardList() 메서드를 호출하여 전체 게시물 목록 조회
		//    => 파라미터 : 시작행번호, 목록갯수   리턴타입 : List<BoardBean>(boardList)
		boardList = dao.selectBoardList(startRow, listLimit);
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return boardList;
	}

	// 전체 게시물 수 조회
	public int getBoardListCount() {
		int listCount = 0;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardListCount() 메서드를 호출하여 전체 게시물 수 조회
		//    => 파라미터 : 없음   리턴타입 : int(listCount)
		listCount = dao.selectBoardListCount();
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return listCount;
	}

}
