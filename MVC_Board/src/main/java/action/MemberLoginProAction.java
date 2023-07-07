package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberLoginProAction");
		
		ActionForward forward = null;
		
		// 파라미터로 전달받은 아이디, 패스워드 가져오기 => MemberBean 객체에 저장
		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
//		System.out.println(member);
		
		// MemberLoginProService 클래스 인스턴스 생성 후 isCorrectUser() 메서드 호출
		// => 파라미터 : MemberBean 객체    리턴타입 : boolean(isCorrectUser)
		MemberLoginProService service = new MemberLoginProService();
		boolean isCorrectUser = service.isCorrectUser(member);
		
		// 로그인 성공 여부 판별
		if(!isCorrectUser) { // 로그인 실패(아이디 없음 또는 패스워드 틀림)
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('로그인 실패!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush(); // out 객체의 모든 데이터 출력(내보내기) - 생략 가능
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 로그인 성공
			// 세션 객체에 로그인 성공한 아이디를 "sId" 라는 속성명으로 저장
			// => 단, 컨트롤러에서는 세션 객체가 내장 객체로 제공되지 않음(JSP 만 가능)
			//    따라서, request 객체로부터 세션 객체를 얻어와야 함 = getSession() 메서드 호출
			//    => 리턴타입 : HttpSession
			HttpSession session = request.getSession();
			session.setAttribute("sId", member.getId());
			
			// 메인페이지로 리다이렉트
			forward = new ActionForward();
			forward.setPath("./");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}













