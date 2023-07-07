package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberInfoService {

	public MemberBean getMember(String id) {
		MemberBean member = null;
		
		Connection con = JdbcUtil.getConnection();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		// MemberDAO 객체의 selectMember() 메서드 호출하여 회원 정보 조회 작업 요청
		// => 파라미터 : 아이디   리턴타입 : MemberBean(member)
		member = dao.selectMember(id);
		
		JdbcUtil.close(con);
		
		return member;
	}

}
