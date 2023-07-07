package jsp10_jdbc_dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp10_jdbc_dao/BoardList")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardListServlet");
		
		// BoardDAO 인스턴스 생성 후 selectBoardList() 메서드를 호출하여 글목록 조회
		// => 파라미터 : 없음    리턴타입 : List<BoardDTO>(boardList)
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> boardList = dao.selectBoardList();
//		System.out.println(boardList);
		
		// 리턴받은 List 객체를 뷰페이지(board_list.jsp)로 전달하기 위해
		// request 객체의 setAttribute() 메서드로 저장
		request.setAttribute("boardList", boardList);
		
		// 글목록 출력을 위해 board_list.jsp 페이지로 포워딩
		// => 현재 서블릿 주소 유지하고, request 객체 유지를 위해 Dispatch 방식 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("board_list.jsp");
		dispatcher.forward(request, response);
	}

}












