package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberInfoService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberInfoAction");
		
		ActionForward forward = null;
		
		// 세션에 저장된 세션 아이디(속성명 : sId) 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sId");
		System.out.println(id);
		
		// 세션 아이디가 존재하지 않을 경우 
		// 자바스크립트로 "잘못된 접근입니다!" 출력 후 이전페이지로 돌아가기
		if(id == null) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('잘못된 접근입니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush(); // out 객체의 모든 데이터 출력(내보내기) - 생략 가능
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 세션 아이디가 존재할 경우
			// 회원 정보 조회 요청
			// 단, 세션 아이디가 "admin"(관리자) 일 경우
			// 파라미터로 전달받은 "id" 값을 가져와서 변수 id 에 저장(덮어쓰기)
			// 일반 회원일 경우 세션 아이디 값을 그대로 사용
			if(id.equals("admin")) {
				id = request.getParameter("id");
			}
			
			// 회원 정보 조회 요청을 위해 MemberInfoService - getMember() 메서드 호출
			// => 파라미터 : 아이디   리턴타입 : MemberBean(member)
			MemberInfoService service = new MemberInfoService();
			MemberBean member = service.getMember(id);
//			System.out.println(member);
			
			// request 객체에 MemberBean 객체 저장(속성명 : member)
			request.setAttribute("member", member);
			
			// member/member_info.jsp 페이지 포워딩 정보 설정 
			// => request 객체 유지, 서블릿 주소 유지 위해 Dispatch 방식 포워딩
			forward = new ActionForward();
			forward.setPath("member/member_info.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}











