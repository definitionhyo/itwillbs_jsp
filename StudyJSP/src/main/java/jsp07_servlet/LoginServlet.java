package jsp07_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 컨텍스트 루트(= 프로젝트명) 뒤의 경로 및 서블릿 주소를 모두 지정하여 매핑
// ex) http://localhost:8080/StudyJSP/jsp07_servlet/jsp07_login
//                                   ~~~~~~~~~~~~~~~~~~~~~~~~~~ => 매핑할 주소
@WebServlet("/jsp07_servlet/jsp07_login")
public class LoginServlet extends HttpServlet {
	// POST 방식 요청만 처리할 경우 doGet() 메서드는 불필요
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet");
		
		// 폼에서 입력받아 전달된 아이디와 패스워드 파라미터 가져와서 변수에 저장 후 출력
		// => request 객체의 getParameter() 메서드 활용
		// => request, response 객체는 doXXX() 메서드 호출 시 톰캣에 의해 자동으로 전달됨
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		
		// 만약, 아이디가 "admin" 이고, 패스워드가 "1234" 이면 "로그인 성공" 출력하고
		// 아니면 "로그인 실패" 출력
		// 클라이언트로 전송할 응답데이터를 response 객체에 담아 전송하는데
		// 이 때, 리다이렉트를 수행하기 위해서는 response 객체의 sendRedirect() 메서드 호출
		if(id.equals("admin") && passwd.equals("1234")) {
			System.out.println("로그인 성공!");
			
			// 세션 객체에 로그인 성공 아이디 저장
			// => 단, 자바에서는 내장 객체 session 이 존재하지 않으므로
			//    request 객체로부터 session 객체를 얻어와서 사용해야한다!
			//    (session 객체의 타입은 javax.servlet.http.HttpSession)
			HttpSession session = request.getSession();
			// 속성명 "sId" 로 로그인 성공 아이디 저장
			session.setAttribute("sId", id);
			
			// response.sendRedirect() 메서드를 호출하여 servlet1_main.jsp 페이지로 리다이렉트
			response.sendRedirect("servlet1_main.jsp");
		} else {
//			System.out.println("로그인 실패!");
			
			/*
			 * 자바스크립트 사용하여 "로그인 실패!" 출력 후 이전페이지로 돌아가기
			 * => 현재 JSP 파일이 아닌 자바 클래스(서블릿)에서 웹브라우저로
			 *    HTML 태그 등을 내보내기(출력) 위한 작업 수행
			 *    (= 자바 클래스 내에서 출력스트림을 활용하여 HTML 태그를 응답데이터로 출력해야함)
			 * => 응답 객체인 response 객체 활용하여 응답 데이터 생성해야함
			 * 
			 * 1) 출력할 HTML 형식에 대한 문서 타입(contentType) 설정
			 *    => 응답 데이터의 형식(타입)으로 HTML 태그가 사용됨을 클라이언트에게 알려줌
			 *    => response 객체의 setContentType() 메서드를 호출하여 문서 타입 지정
			 *       (JSP 파일 최상단 page 디렉티브 내의 contentType=XXX 항목 활용)
			 */
			response.setContentType("text/html; charset=UTF-8");
			
			// 2) 자바 코드를 사용하여 HTML 태그(자바스크립트 포함) 출력(전송)하려면
			//    java.io.PrintWriter 객체 필요(= 출력 스트림으로 사용할 객체)
			//    => response 객체의 getWriter() 메서드를 호출하여 얻을 수 있다!
			PrintWriter out = response.getWriter();
			
			// 3) PrintWriter 객체(out)의 print() 또는 println() 메서드를 호출하여
			//    출력할(전송할) HTML 태그 등의 코드를 문자열 형태로 전달
			out.print("<script>");
			out.print("alert('로그인 실패!');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
	}

}










