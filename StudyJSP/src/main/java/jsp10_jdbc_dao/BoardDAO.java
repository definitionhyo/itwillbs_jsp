package jsp10_jdbc_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	// 글쓰기 작업 - jsp10_board 테이블에 BoardDTO 에 저장된 내용 INSERT
	public int insertBoard(BoardDTO board) {
		System.out.println("BoardDAO - insertBoard()");
		
		int insertCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// 1단계&2단계
		con = JdbcUtil.getConnection();
		
		try {
			// 3단계.
			// 작성자, 패스워드, 제목, 내용 항목을 board 테이블에 INSERT
			String sql = "INSERT INTO jsp10_board VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			// 만능문자 파라미터를 대체할 데이터는 BoardDTO 객체에 저장되어 있음
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_pass());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			
			// 4단계.
			// executeUpdate() 메서드 호출 수 리턴되는 int 타입 데이터 저장
			insertCount = pstmt.executeUpdate();
			System.out.println("글쓰기 성공!");
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생 - insertBoard()");
			e.printStackTrace();
		} finally {
			// DB 자원 반환 - JdbcUtil.close() 활용
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		// 작업 결과 리턴
		return insertCount; // BoardWriteProServlet 으로 돌아감
	}

	// 글 목록 조회 - jsp10_board 테이블 SELECT
	public List<BoardDTO> selectBoardList() {
		System.out.println("BoardDAO - selectBoardList()");
		
		List<BoardDTO> boardList = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 1단계&2단계
		con = JdbcUtil.getConnection();
		
		try {
			// 3단계.
			String sql = "SELECT * FROM jsp10_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 4단계.
			// 전체 레코드를 저장할 ArrayList 객체 생성(List 타입으로 업캐스팅)
			boardList = new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				// 1개 레코드 정보를 저장하는 BoardDTO 객체 생성
				BoardDTO board = new BoardDTO();
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
//				System.out.println(board);
				
				// 전체 레코드 저장하는 List 객체에 1개 레코드가 저장된 BoardDTO 객체 저장
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생 - selectBoardList()");
			e.printStackTrace();
		} finally {
			// DB 자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		// 전체 레코드가 저장된 List 객체 리턴
		return boardList; // BoardListServlet 으로 이동
	}

}













