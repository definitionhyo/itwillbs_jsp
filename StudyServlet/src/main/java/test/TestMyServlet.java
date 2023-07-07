package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿(Servlet)
 * - 웹에서의 요청을 처리할 수 있는 자바 클래스
 * - 서블릿 클래스를 정의하려면 javax.servlet.http.HttpServlet 클래스를 상속받아 정의
 * - 서블릿 기능을 사용하려면 추가적인 라이브러리(servlet-api.jar) 등록 필요함
 *   => 이전에는 별도로 라이브러리를 다운로드 받아 추가했지만
 *      현재는 톰캣 서버 라이브러리에 기본으로 제공되므로 별도의 추가는 불필요
 *      (Libraries 항목에 Server Runtime 라이브러리 등록되어 있으면 된다!)
 * - 서블릿 클래스에서 특정 서블릿 주소 요청에 대한 처리를 수행하려면
 *   해당 주소(= 서블릿 주소)와 서블릿 클래스 매핑 작업 필수!
 *   방법1) web.xml(배포서술자) 파일을 통해 매핑
 *   방법2) 서블릿 클래스 선언부 상단에 @WebServlet 어노테이션을 통해 매핑
 *          => @WebServlet("/서블릿주소")
 */
public class TestMyServlet extends HttpServlet {

	/*
	 * 서블릿 클래스 내에는 GET or POST 방식 요청에 대한 처리를 위해
	 * doGet() or doPost() 메서드 정의해야한다!
	 * => HttpServlet 클래스로부터 상속받아 오버라이딩
	 * => 만약, 두 메서드 중 필요한 요청에 대한 메서드가 정의되지 않았을 경우
	 *    해당 메서드에 일치하는 요청 방식으로 요청이 발생했을 때
	 *    응답 메세지로 HTTP 405(허용되지 않는 메서드) 오류가 발생함!
	 *    (단, 매핑되는 서블릿 주소가 없을 경우 HTTP 404(찾을 수 없는 페이지) 오류 발생)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식 요청이 발생할 경우 자동으로 호출되는 메서드
		System.out.println("GET 방식 요청에 대한 doGet() 메서드 호출됨!");
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// POST 방식 요청이 발생할 경우 자동으로 호출되는 메서드
//		System.out.println("POST 방식 요청에 대한 doPost() 메서드 호출됨!");
//	}
	
	
}













