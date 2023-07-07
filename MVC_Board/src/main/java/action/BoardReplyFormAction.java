package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardReplyFormAction");
		
		ActionForward forward = null;
		
		// 글 상세정보 조회에 필요한 글번호 파라미터 가져오기
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// BoardDetailService - getBoard() 메서드 호출하여 게시물 조회 작업 요청(재사용)
		// => 파라미터 : 글번호   리턴타입 : BoardBean(board)
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num);

		// request 객체에 BoardBean 객체 저장
		request.setAttribute("board", board);
		
		// ActionForward 객체를 사용하여 "board/board_reply_form.jsp" 포워딩
		forward = new ActionForward();
		forward.setPath("board/board_reply_form.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}










