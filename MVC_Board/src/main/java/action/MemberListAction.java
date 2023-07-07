package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberListAction");
		
		ActionForward forward = null;

		// 만약, 세션 아이디가 존재하지 않거나 "admin" 이 아닐 경우
		// 자바스크립트로 "잘못된 접근입니다!" 출력 후 이전페이지로 돌아가기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sId");
//		System.out.println(id);
		
		if(id == null || !id.equals("admin")) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('잘못된 접근입니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 전체 회원 목록 조회를 위해 MemberListService - getMemberList() 메서드 호출
			// => 파라미터 : 없음   리턴타입 : List<MemberBean>(memberList)
			MemberListService service = new MemberListService();
			List<MemberBean> memberList = service.getMemberList();
			System.out.println(memberList);
			
			// request 객체에 List 객체 저장(속성명 : memberList)
			request.setAttribute("memberList", memberList);
			
			// member/member_list.jsp 페이지 포워딩 정보 설정 => Dispatch
			forward = new ActionForward();
			forward.setPath("member/member_list.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}












