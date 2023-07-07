package jsp10_jdbc_dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp10_jdbc_dao/BoardWritePro")
public class BoardWriteProServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("BoardWriteProServlet");
		
		request.setCharacterEncoding("UTF-8");
		
		// board_write_form.jsp 페이지로부터 전달받은 폼파라미터 데이터를 가져와서
		// BoardDTO 클래스 인스턴스 생성 및 데이터 저장
		BoardDTO board = new BoardDTO();
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
//		System.out.println(board);
		
		// BoardDAO - insertBoard() 메서드를 호출하여 글쓰기 작업 요청
		// => 파라미터 : BoardDTO 객체     리턴타입 : int(insertCount)
		BoardDAO dao = new BoardDAO();
		int insertCount = dao.insertBoard(board);
		
		// 글쓰기 성공/실패 여부 판별하여
		// 성공 시 BoardList 서블릿 주소 요청
		// 실패 시 자바스크립트를 통해 "글쓰기 실패!" 출력 후 이전페이지로 돌아가기
		if(insertCount > 0) { // 성공
			// response.sendRedirect() 메서드를 호출하여 서블릿 주소 요청(리다이렉트)
			response.sendRedirect("BoardList");
		} else { // 실패
			// response 객체를 통해 응답 데이터의 문서 타입 지정 및
			// PrintWriter 객체 얻어와서 println() 메서드를 통해 HTML(자바스크립트) 출력
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글쓰기 실패!')");
			out.println("history.back()");
			out.println("</script>");
			out.flush();
		}
		
	}

}









