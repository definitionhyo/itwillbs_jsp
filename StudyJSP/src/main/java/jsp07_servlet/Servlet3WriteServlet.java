package jsp07_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/jsp07_servlet3_writePro")
public class Servlet3WriteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet3WriteServlet");
		
		// write_form.jsp 페이지에서 전달받은 파라미터 가져와서 출력
		// POST 방식 요청 시 파라미터 데이터에 대한 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 폼으로부터 전달받은 게시물 정보(작성자, 패스워드, 제목, 내용) 출력하기
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("이름 : " + name);
		System.out.println("패스워드 : " + passwd);
		System.out.println("제목 : " + subject);
		System.out.println("내용 : " + content);
		
		// 글쓰기 작업 완료했다고 가정 후 글 목록 표시를 위해 
		// /jsp07_servlet/jsp07_servlet3_list 서블릿 주소 요청
		// => 기존의 jsp07_servlet3_writePro 서블릿 주소 대신 
		//    새 요청 주소인 jsp07_servlet3_list 로 변경
		// => 이 때, 이전 request 객체 유지 불필요하며, 주소도 변경해야하므로
		//    Redirect 방식으로 포워딩 수행해야함
		response.sendRedirect("jsp07_servlet3_list");
		// 리다이렉트 결과
		// 기존 요청 주소 : http://localhost:8080/StudyJSP/jsp07_servlet/jsp07_servlet3_writePro
		// 새 요청 주소 : http://localhost:8080/StudyJSP/jsp07_servlet/jsp07_servlet3_list
		
	}

}










