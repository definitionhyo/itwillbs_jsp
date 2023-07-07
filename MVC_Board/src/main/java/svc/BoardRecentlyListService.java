package svc;

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardRecentlyListService {
	
	// 최근 게시물 5개 조회 요청
	public List<BoardBean> getRecentlyBoardList() {
		List<BoardBean> boardList = null;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectRecentlyBoardList() 메서드를 호출하여 전체 게시물 목록 조회
		//    => 파라미터 : 없음   리턴타입 : List<BoardBean>(boardList)
		boardList = dao.selectRecentlyBoardList();
		
		// 6. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		return boardList;
	}

}
