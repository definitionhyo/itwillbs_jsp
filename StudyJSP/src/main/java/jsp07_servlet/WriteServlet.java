package jsp07_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/jsp07_write")
public class WriteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("WriteServlet");
		
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
		
		// 메인페이지로 리다이렉트
		response.sendRedirect("servlet1_main.jsp");
	}

}













