package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import vo.BoardBean;

public class BoardDAO {
	// -----------------------------------------------
	// 싱글톤 패턴을 활용한 인스턴스 관리
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {}

	public static BoardDAO getInstance() {
		return instance;
	}
	// -----------------------------------------------
	// 외부로부터 Connection 객체를 전달받아 관리
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	// -----------------------------------------------
	// 글쓰기
	public int insertBoard(BoardBean board) {
		// 작업 처리 결과를 리턴받아 저장할 변수 선언
		int insertCount = 0;
		
		// DB 작업에 필요한 변수 선언
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 새 글 번호 계산을 위해 기존 board 테이블의 번호(board_num) 중 가장 큰 번호 조회
			// => MySQL 구문의 MAX() 함수 사용(SELECT MAX(컬럼명) FROM 테이블명)
			// => 조회 결과가 있을 경우 조회 결과 + 1 값을 새 글 번호로 지정
			//    (단, 조회 결과가 없을 경우 기본값 1 로 지정)
			int board_num = 1; // 새 글 번호(기본값 1)
			
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있을 경우
				// 기존 게시물이 하나라도 존재할 경우 가장 큰 번호 리턴 + 1 값을 저장
				// 만약, 게시물이 하나도 없을 경우 0 리턴 + 1 값을 저장
				board_num = rs.getInt(1) + 1;
			} 
			// ----------------------------------------------------------------------
			// 전달받은 데이터(BoardBean 객체)를 사용하여 INSERT 작업 수행
			// => 참조글번호(board_re_ref)는 새 글 번호와 동일한 번호로 지정
			// => 들여쓰기레벨(board_re_lev)과 순서번호(board_re_seq)는 0으로 지정
			// => 조회수(board_readcount)는 0 으로 지정
			// => 작성일자는 now() 함수 사용
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, board_num); // 글번호(계산된 새 글 번호 사용)
			pstmt2.setString(2, board.getBoard_name()); // 작성자
			pstmt2.setString(3, board.getBoard_pass()); // 패스워드
			pstmt2.setString(4, board.getBoard_subject()); // 제목
			pstmt2.setString(5, board.getBoard_content()); // 내용
			pstmt2.setString(6, board.getBoard_file()); // 원본파일명
			pstmt2.setString(7, board.getBoard_real_file()); // 실제파일명
			pstmt2.setInt(8, board_num); // 참조글번호(글쓰기 과정은 글번호와 동일)
			pstmt2.setInt(9, 0); // 들여쓰기레벨
			pstmt2.setInt(10, 0); // 순서번호
			pstmt2.setInt(11, 0); // 조회수
			
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - insertBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
		}
		
		return insertCount;
	}

	// 전체 글 목록 조회
	public List<BoardBean> selectBoardList(int startRow, int listLimit) {
		List<BoardBean> boardList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 모든 레코드 조회
			// => 정렬 기준(ORDER BY 절 사용) : 참조글번호(board_re_ref) 기준 내림차순,
			//                                  순서번호(board_re_seq) 기준 오름차순
			// => 조회 레코드 갯수 제한(LIMIT 절 사용)
			//    1) 정수 파라미터 1개(limit) : 지정한 갯수만큼 조회
			//    2) 정수 파라미터 2개(startRow, limit) : 시작행 번호부터 지정한 갯수만큼 조회
			String sql = "SELECT * FROM board "
								+ "ORDER BY board_re_ref DESC, board_re_seq ASC "
								+ "LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			
			// 전체 글목록 저장할 객체 생성
			boardList = new ArrayList<BoardBean>();
			
			while(rs.next()) {
				// 1개 글 정보를 저장할 객체 생성 및 데이터 저장
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass")); // 생략 가능
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				
				// 1개 게시물 정보를 List 객체에 추가
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectBoardList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return boardList;
	}

	// 전체 게시물 수 조회
	public int selectBoardListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 모든 레코드 갯수 조회 - COUNT() 함수 활용
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectBoardListCount()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return listCount;
	}

	// 게시물 상세 정보 조회
	public BoardBean selectBoard(int board_num) {
		BoardBean board = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 글번호에 해당하는 레코드 검색 - SELECT
			String sql = "SELECT * FROM board WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 1개 글 정보를 저장할 객체 생성 및 데이터 저장
				board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass")); // 생략 가능
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return board;
	}

	// 조회수 증가
	public int updateReadcount(int board_num) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE board "
							+ "SET board_readcount = board_readcount + 1 "
							+ "WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - updateReadcount()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return updateCount;
	}

	// 패스워드 판별
	public boolean selectBoardWriter(int board_num, String board_pass) {
		boolean isBoardWriter = false;
		
		// DB 작업에 필요한 변수 선언
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 글번호와 패스워드가 일치하는 레코드 조회
			String sql = "SELECT * FROM board WHERE board_num = ? AND board_pass = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, board_pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있을 경우
				// isBoardWriter 변수값을 true 로 변경
				isBoardWriter = true;
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectBoardWriter()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isBoardWriter;
	}

	// 글 삭제
	public int deleteBoard(int board_num) {
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			// 글번호에 해당하는 레코드 삭제
			String sql = "DELETE FROM board WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - deleteBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return deleteCount;
	}

	// 실제 파일명 조회 
	public String selectBoardRealFile(int board_num) {
		String board_real_file = null;
		
		// DB 작업에 필요한 변수 선언
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 글번호가 일치하는 레코드의 실제 파일명(board_real_file) 조회
			String sql = "SELECT board_real_file FROM board WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있을 경우
				// board_real_file 변수에 파일명 저장
				board_real_file = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectBoardRealFile()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return board_real_file;
	}

	// 글 수정
	public int updateBoard(BoardBean board) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			// 글번호에 해당하는 레코드 삭제
			String sql = "UPDATE board "
						+ "SET board_name = ?, board_subject = ?, board_content = ? "
						+ "WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_subject());
			pstmt.setString(3, board.getBoard_content());
			pstmt.setInt(4, board.getBoard_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - updateBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return updateCount;
	}

	// 답글 쓰기
	public int insertReplyBoard(BoardBean board) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 답글 쓰기 - INSERT
			int ref = board.getBoard_re_ref();
			int lev = board.getBoard_re_lev();
			int seq = board.getBoard_re_seq();
			
			// 1. 기존 답글들에 대한 순서번호 증가 - UPDATE
			//    => 참조글번호(board_re_ref)가 원본글의 참조글번호와 같고,
			//       순서번호(board_re_seq)가 원본글의 순서번호 보다 큰 레코드를 찾아
			//       해당 레코드의 순서번호를 + 1 증가 처리
			String sql = "UPDATE board "
					+ "		SET"
					+ "			board_re_seq = board_re_seq + 1"
					+ "		WHERE"
					+ "			board_re_ref = ?"
					+ "			AND board_re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, seq);
			pstmt.executeUpdate();
			
			pstmt.close();
			
			// 새 답글에 사용될 lev, seq 값은 원본들의 lev 과 seq 값 + 1 처리
			lev++;
			seq++;
			// --------------------------------------------------------------
			// 2. 답글 쓰기
			// 2-1) 기존 게시물의 가장 큰 번호 조회 - SELECT
			//      => 조회된 값 + 1 값을 새 글 번호로 설정
			int board_num = 1;
			sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board_num = rs.getInt(1) + 1;
			}
			
			// ------------------------
			// 2-2) 새 답글 쓰기 - INSERT
			// => 조회수(board_readcount)는 0 으로 지정
			// => 작성일자는 now() 함수 사용
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, board_num); // 글번호(계산된 새 글 번호 사용)
			pstmt2.setString(2, board.getBoard_name()); // 작성자
			pstmt2.setString(3, board.getBoard_pass()); // 패스워드
			pstmt2.setString(4, board.getBoard_subject()); // 제목
			pstmt2.setString(5, board.getBoard_content()); // 내용
			pstmt2.setString(6, board.getBoard_file()); // 원본파일명
			pstmt2.setString(7, board.getBoard_real_file()); // 실제파일명
			pstmt2.setInt(8, ref); // 참조글번호
			pstmt2.setInt(9, lev); // 들여쓰기레벨
			pstmt2.setInt(10, seq); // 순서번호
			pstmt2.setInt(11, 0); // 조회수
			
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - insertReplyBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
		}
		
		return insertCount;
	}

	// 최근 게시물 5개 목록 조회
	public List<BoardBean> selectRecentlyBoardList() {
		List<BoardBean> boardList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 모든 레코드 조회
			// => 정렬 기준(ORDER BY 절 사용) : 작성일순 내림차순
			// => 조회 레코드 갯수 제한(LIMIT 절 사용) : 5개 제한
			String sql = "SELECT * FROM board "
							+ "ORDER BY board_date DESC "
							+ "LIMIT 5";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 전체 글목록 저장할 객체 생성
			boardList = new ArrayList<BoardBean>();
			
			while(rs.next()) {
				// 1개 글 정보를 저장할 객체 생성 및 데이터 저장
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass")); // 생략 가능
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				
				// 1개 게시물 정보를 List 객체에 추가
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectRecentlyBoardList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return boardList;
	}
	
	
	
}












