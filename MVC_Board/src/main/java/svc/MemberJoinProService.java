package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

// Action 클래스로부터 작업 요청을 받아 DAO 클래스와 상호 작용을 통해
// 실제 비즈니스 로직(DB 작업)을 수행하는 클래스
// 또한, DB 작업 수행 후 결과 판별을 통해 트랜잭션 처리(commit or rollback) 도 수행
public class MemberJoinProService {

	// 회원가입 작업 요청을 위한 joinMember() 메서드 정의
	// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isJoinSuccess)
	public boolean joinMember(MemberBean member) {
		System.out.println("MemberJoinProService - joinMember()");
		
		// 1. 작업 요청 처리 결과를 저장할 boolean 타입 변수 선언
		boolean isJoinSuccess = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		// => 트랜잭션 처리를 Service 객체가 수행하므로
		//    DAO 가 아닌 Service 객체가 Connection 객체를 관리해야함
		Connection con = JdbcUtil.getConnection();
		
		// 3. MemberDAO 클래스로부터 MemberDAO 객체 가져오기(공통)
		// => 싱글톤 디자인 패턴으로 구현되어 있는 객체를 getInstance() 메서드로 리턴받기
//		MemberDAO dao = new MemberDAO(); // The constructor MemberDAO() is not visible
		MemberDAO dao = MemberDAO.getInstance();
		
		// 4. MemberDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. MemberDAO 객체의 xxx() 메서드를 호출하여 xxx 작업 수행 요청 및 결과 리턴받기
		//    insertMember() 메서드를 호출하여 회원가입 작업 요청 및 결과 리턴받기
		//    => 파라미터 : MemberBean 객체   리턴타입 : int(insertCount)
		int insertCount = dao.insertMember(member);
		
		// 6. DB 작업 요청 처리 결과에 따른 트랜잭션 처리
		if(insertCount > 0) { // 성공 시
			// INSERT 작업 성공 시 트랜잭션 처리 중 Commit 작업 수행을 위해
			// JdbcUtil 클래스의 commit() 메서드 호출
			// => 파라미터 : Connection 객체
			JdbcUtil.commit(con);
			
			// 작업 처리 결과를 성공으로 표시하여 리턴하기 위해
			// isJoinSuccess 변수 값을 true 로 변경
			isJoinSuccess = true;
		} else { // 실패 시
			// INSERT 작업 실패 시 트랜잭션 처리 중 Rollback 작업 수행을 위해
			// JdbcUtil 클래스의 rollback() 메서드 호출
			// => 파라미터 : Connection 객체
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection Pool 로부터 가져온 Connection 자원(객체) 반환(공통)
		//    => 주의! DAO 객체에서 Connection 객체 반환(close()) 금지!
		JdbcUtil.close(con);
		
		// 8. 작업 요청 처리 결과 리턴
		return isJoinSuccess; // => MemberJoinProAction
	}
	
}












