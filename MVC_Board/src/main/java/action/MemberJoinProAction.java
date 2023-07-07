package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberBean;

// FrontController 를 보조할 Action 클래스 정의
// => 공통된 메서드 execute() 를 직접 정의하지 않고
//    Action 인터페이스를 상속받아 추상메서드 execute() 를 오버라이딩(구현)
public class MemberJoinProAction implements Action {

	// 프론트 컨트롤러(MemberFrontContoller)로부터 호출받아
	// 회원가입 비즈니스 로직을 수행할 execute() 메서드 정의
	// => 컨트롤러 역할을 수행하므로 FrontController 와 마찬가지로 request, response 객체 필요
	// => 파라미터 : HttpServletRequest(request), HttpServletResponse(response) 객체
	// => 리턴타입 : vo.ActionForward
	// => 추상메서드를 갖는 Action 인터페이스를 implements 했으므로 메서드 오버라이딩 필수!
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberJoinProAction");
		
		// 포워딩 정보를 저장하기 위한 ActionForward 타입 변수 선언
		ActionForward forward = null;
		
		// 회원가입 폼에서 입력받은 폼 파라미터 가져오기
		// => 데이터 전송 객체인 MemberBean 객체 생성 후 폼 파라미터 데이터 저장하기 
		// => 이메일과 주민번호는 2개의 입력 항목을 하나로 결합하여 저장
		MemberBean member = new MemberBean();
		member.setName(request.getParameter("name"));
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setJumin(
				request.getParameter("jumin1") + "-" + request.getParameter("jumin2"));
		member.setEmail(
				request.getParameter("email1") + "@" + request.getParameter("email2"));
		member.setJob(request.getParameter("job"));
		member.setGender(request.getParameter("gender"));
		
//		member.setHobby(request.getParameter("hobby"));
		// => 취미는 동일한 name 속성을 갖는 체크박스가 복수개이므로
		//    배열을 처리하기 위해 request.getParameter() 메서드 대신
		//    request.getParameterValues() 메서드를 사용해야한다!
		String[] hobbies = request.getParameterValues("hobby");
		// for문을 활용하여 배열 요소만큼 반복하면서 문자열 결합으로 hobby 저장
		// => 구분자로 "/" 기호 사용
		// => 반복문 수행 전 MemberBean 객체의 hobby 변수값을 널스트링("")으로 초기화
		member.setHobby(""); // 수행하지 않으면 초기값 null 값이 저장되어 있음
		
		if(hobbies != null) { // 취미를 하나라도 체크했을 경우에만 작업 수행
			for(String hobby : hobbies) {
				member.setHobby(member.getHobby() + hobby + "/");
			}
		}
		
		member.setMotivation(request.getParameter("motivation"));
//		System.out.println(member); // toString() 생략됨
		
		// 회원 가입 비즈니스 로직 요청 수행(XXXService 클래스 활용)
		// MemberJoinProService 클래스 인스턴스 생성 후 joinMember() 메서드 호출
		// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isJoinSuccess)
		MemberJoinProService service = new MemberJoinProService();
		boolean isJoinSuccess = service.joinMember(member);
		
		// 가입 작업 결과 판별
		if(!isJoinSuccess) { // 가입 실패
//			System.out.println("가입 실패!");
			
			try {
				/*
				 * 자바스크립트를 사용하여 "회원 가입 실패!" 출력 후 이전페이지로 돌아갈
				 * 응답 데이터를 생성하기
				 * => 웹브라우저로 HTML 태그 등을 내보내기(출력) 위한 작업 수행
				 * => 응답 데이터 생성을 위한 response 객체 활용
				 * 1) 출력할 HTML 형식에 대한 문서 타입(contentType) 설정
				 *    => 응답 데이터의 타입으로 HTML 태그가 사용됨을 클라이언트에게 알려줌
				 *    => response 객체의 setContentType() 메서드를 호출하여 문서 타입 전달
				 *       (JSP 파일 최상단의 page 디렉티브 내의 contentType=XXX 항목 활용)
				 */
				response.setContentType("text/html; charset=UTF-8");
				
				// 2) 자바 코드를 사용하여 HTML 태그 등을 출력(전송)하려면
				//    java.io.PrintWriter 객체 필요함(= 출력스트림으로 사용할 객체)
				//    => response 객체의 getWriter() 메서드를 호출하여 얻어올 수 있다!
				PrintWriter out = response.getWriter();
				
				// 3) PrintWriter 객체의 print() 또는 println() 메서드를 호출하여
				//    파라미터로 HTML 태그 등의 코드를 문자열 형태로 전달
				out.print("<script>");
				out.print("alert('회원가입 실패!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush(); // out 객체의 모든 데이터 출력(내보내기) - 생략 가능
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// ActionForward 객체 생성하지 않음 => null 값 전달(리턴)
		} else { // 가입 성공
			// 포워딩 정보를 저장할 ActionFoward 인스턴스 생성
			forward = new ActionForward();
			// 포워딩 경로(메인페이지 = "./") 저장 => ActionForward 객체의 setPath()
			forward.setPath("./");
			// 포워딩 방식(리다이렉트) 저장 => ActionForward 객체의 setRedirect()
			forward.setRedirect(true);
		}
		
		return forward; // => MemberFrontController 로 리턴
		
	}
	
}














