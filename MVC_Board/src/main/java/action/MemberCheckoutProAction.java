package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BoardDeleteProService;
import svc.MemberCheckoutProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberCheckoutProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberCheckoutProAction");
		
		ActionForward forward = null;
		
		try {
			// 회원 탈퇴에 필요한 정보(아이디, 패스워드) 가져오기
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("sId");
			
			// 세션 아이디가 존재하지 않을 경우 경고메세지 출력 및 이전페이지로 돌아가기
			if(id == null || id.equals("")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('접근 권한이 없습니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
			}
			
			String passwd = request.getParameter("passwd");
//			System.out.println("id = " + id + ", passwd = " + passwd);
			
			MemberBean member = new MemberBean();
			member.setId(id);
			member.setPasswd(passwd);
			
			// MemberCheckoutProService - isCorrectUser() 메서드를 호출하여
			// 아이디, 패스워드 판별
			// => 파라미터 : MemberBean 객체    리턴타입 : boolean(isCorrectUser)
			MemberCheckoutProService service = new MemberCheckoutProService();
			boolean isCorrectUser = service.isCorrectUser(member);
			
			// 작업 결과 판별
			// 만약, 일치하지 않으면(isCorrectUser 가 false)
			// 자바스크립트를 사용하여 "탈퇴 권한이 없습니다!" 출력 후 이전페이지로 돌아가기
			if(!isCorrectUser) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('탈퇴 권한이 없습니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
			} else { // 패스워드 일치할 경우(= 탈퇴 권한이 있을 경우)
				// MemberCheckoutProService - removeMember() 메서드 호출하여 회원정보 삭제
				// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isDeleteSuccess)
				boolean isDeleteSuccess = service.removeMember(member);
				
				// 삭제 결과 판별
				// 실패 시(isDeleteSuccess 가 false) 자바스크립트로 "탈퇴 실패!" 출력 후 이전페이지로 돌아가기
				// 성공 시 로그아웃 처리 후 메인페이지로 리다이렉트
				if(!isDeleteSuccess) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("<script>");
					out.print("alert('삭제 실패!');");
					out.print("history.back();");
					out.print("</script>");
					out.flush();
				} else {
					// 로그아웃 처리
					session.invalidate();
					// -----------------------------------------------------------------
					// ActionForward 객체를 사용하여 메인페이지로 리다이렉트
					forward = new ActionForward();
					forward.setPath("./");
					forward.setRedirect(true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
