package svc;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberListService {

	public List<MemberBean> getMemberList() {
		List<MemberBean> memberList = null;
		
		Connection con = JdbcUtil.getConnection();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		// MemberDAO 객체의 selectMemberList() 메서드 호출하여 전체 회원 목록 조회 작업 요청
		// => 파라미터 : 없음   리턴타입 : List<MemberBean>(memberList)
		memberList = dao.selectMemberList();
		
		JdbcUtil.close(con);
		
		return memberList;
	}

}
