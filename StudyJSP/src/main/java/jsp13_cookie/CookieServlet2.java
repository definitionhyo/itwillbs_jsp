package jsp13_cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp13_cookie/CookieServlet2")
public class CookieServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lang 파라미터값 가져와서 출력
		String language = request.getParameter("lang");
//		System.out.println(language);
		
		// language 라는 쿠키명으로 전달받은 언어 설정값(ko-kr 또는 en-us)을 쿠키에 저장
		// => 쿠키 유효기간 : 1일
		Cookie cookie = new Cookie("language", language);
//		cookie.setMaxAge(86400); // 초 단위로 입력해야하므로 1일을 초로 변환하여 전달
		// => 차후에 유효기간 변경 시 다시 계산해야하므로 유지보수성이 떨어짐
		// => 기초 단위부터 각 단위별 연산 과정을 기술하면 유지보수가 쉬워진다!
		cookie.setMaxAge(60 * 60 * 24); // 60초 * 60분 * 24시간 = 1일
		// => 차후 4시간으로 변경 시 24 -> 4 로 변경하므로 변경이 쉬워진다!
		response.addCookie(cookie);
		
		// test2.jsp 페이지로 리다이렉트(임시)
		response.sendRedirect("test2.jsp");
	}

}










