package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardRecentlyListService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardRecentlyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardRecentlyListAction");
		
		ActionForward forward = null;
		
		// 최근 게시물 5개 조회
		// => BoardRecentlyListService - getRecentlyBoardList() 메서드를 호출
		// => BoardDAO - selectRecentlyBoardList() 메서드 호출
		//    파라미터 : 없음    리턴타입 : List<BoardBean>(boardList)
		// (최근 게시물 순으로 정렬하여 5개 조회)
		BoardRecentlyListService service = new BoardRecentlyListService();
		List<BoardBean> boardList = service.getRecentlyBoardList();
		
		// 최근 게시물 목록을 request 객체에 저장
		request.setAttribute("boardList", boardList);
		
		// main.jsp 페이지로 포워딩(dispatch)
		// => 제목, 작성자, 작성일 출력
		forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
