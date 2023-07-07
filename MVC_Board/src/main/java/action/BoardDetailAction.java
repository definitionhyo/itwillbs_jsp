package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDetailAction");
		
		ActionForward forward = null;
		
		// 글 상세정보 조회에 필요한 글번호 파라미터 가져오기
		int board_num = Integer.parseInt(request.getParameter("board_num"));
//		System.out.println("board_num = " + board_num);
		// 페이지번호(pageNum)는 현재 작업에서 실제로 활용되는 데이터가 아니므로
		// 다음 페이지 이동 시 URL 또는 request 객체에 전달하기만 하면 된다!
		// 또한, Dispatch 방식 포워딩 시 URL 유지되므로 별도의 작업 불필요
		
		// BoardDetailService - getBoard() 메서드 호출하여 게시물 조회 작업 요청
		// => 파라미터 : 글번호   리턴타입 : BoardBean(board)
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num);
		System.out.println(board);

		// request 객체에 BoardBean 객체 저장
		request.setAttribute("board", board);
		
		// ActionForward 객체를 사용하여 "board/board_view.jsp" 포워딩
		forward = new ActionForward();
		forward.setPath("board/board_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}









