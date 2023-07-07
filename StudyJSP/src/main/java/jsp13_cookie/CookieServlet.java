package jsp13_cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.ck")
public class CookieServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// URL 에서 서블릿 주소 추출하기
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// if문을 사용하여 요청된 서블릿 주소 판별하기
		if(command.equals("/jsp13_cookie/MakeCookie.ck")) {
//			System.out.println("MakeCookie");
			
			// 1. 쿠키 생성
			// - java.servlet.http.Cookie 객체 생성(실제 쿠키가 생성되는 시점이 아님!)
			//   => 클라이언트에 전송되어야 실제 쿠키가 되며, 현재는 단순 객체이다!
			// "cookieName" 이라는 속성명(쿠키이름)으로 "cookieValue" 라는 값 저장
			Cookie cookie = new Cookie("cookieName", "cookieValue");
			
			// 2. 생성된 쿠키의 유효기간(만료기간) 설정
			// - Cookie 객체의 setMaxAge() 메서드를 호출하여 유효기간 지정(초 단위)
			// - 만약, 유효기간 지정 생략 시 웹브라우저 동작할 동안만 쿠키 유지됨
			//   => 웹브라우저 종료 시 삭제됨
			cookie.setMaxAge(60); // 60초 = 1분간 쿠키 유지됨
			
			// 3. 생성된 쿠키를 클라이언트로 전송(= 클라이언트에 실제 쿠키 생성됨)
			// - 응답 객체인 response 객체의 addCookie() 메서드를 호출하여
			//   생성된 Cookie 객체를 파라미터로 전달
			response.addCookie(cookie);
			// ------------------------------------------------------------
			// 생성된 Cookie 객체의 정보 확인(임시)
			// - getName() 메서드 : 쿠키 이름 리턴
			// - getValue() 메서드 : 쿠키 값 리턴
			// - getMaxAge() 메서드 : 쿠키 유효기간 리턴
			System.out.println("쿠키명 : " + cookie.getName());
			System.out.println("쿠키값 : " + cookie.getValue());
			System.out.println("쿠키 유효기간 : " + cookie.getMaxAge());
			// ------------------------------------------------------------
			// 4. ShowCookie.ck 서블릿 주소 요청 = 리다이렉트
			response.sendRedirect("ShowCookie.ck");
		} else if(command.equals("/jsp13_cookie/ShowCookie.ck")) {
			System.out.println("ShowCookie");
			
			// ------------------- 서블릿 클래스에서 쿠키 확인하기 --------------------
			// 클라이언트에 저장된 쿠키 확인하기
			// 1. requestr 객체의 헤더에 "Cookie" 라는 문자열에 해당하는 데이터 가져오기
			//    (= 쿠키 존재 여부 확인용)
			// => 생략 가능
			String cookieHeader = request.getHeader("Cookie");
			
			// 2. 리턴받은 헤더 정보에 대한 문자열이 null 이 아닐 경우 판별
			// => 생략 가능
			if(cookieHeader != null) { // 쿠키가 존재한다는 의미
				// 3. request 객체를 활용하여 클라이언트에 저장된 Cookie 객체(들) 가져오기
				// => request 객체의 getCookies() 메서드를 호출하여 Cookie[] 타입으로 리턴받기
				Cookie[] cookies = request.getCookies();
				
				// 4. for 문을 사용하여 Cookie 배열 반복하면서 각 쿠키에 접근
//				for(int i = 0; i < cookies.length; i++) {
//					Cookie cookie = cookies[i];
//				}
				
				for(Cookie cookie : cookies) {
					// 5. Cookie 객체의 getName(), getValue() 메서드를 통해 쿠키 정보 가져오기
					System.out.println("쿠키명 : " + cookie.getName());
					System.out.println("쿠키값 : " + cookie.getValue());
				}
				
				// ----------------- 클라이언트에서 쿠키 확인하기 ------------------
				// test1_show_cookie.jsp 페이지로 포워딩(디스패치)
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("test1_show_cookie.jsp");
				dispatcher.forward(request, response);
			}
			
		} else if(command.equals("/jsp13_cookie/DeleteCookie.ck")) {
			System.out.println("DeleteCookie");
			
			// 클라이언트에 저장되어 있는 쿠키 삭제하기
			// => 해당 쿠키의 타이머(유효기간)을 0으로 설정 후 클라이언트에게 전송
			// 1. Cookie 객체 생성 시 쿠키명을 삭제할 쿠키명으로 지정(값은 무관)
			Cookie cookie = new Cookie("cookieName", null);
			
			// 2. 쿠키의 유효기간을 0으로 설정(쿠키 삭제 의미)
			cookie.setMaxAge(0);
			
			// 3. 클라이언트에게 쿠키 전송
			response.addCookie(cookie);
			
			// 4. ShowCookie.ck 서블릿 요청
			response.sendRedirect("ShowCookie.ck");
		}
	}
	
}









