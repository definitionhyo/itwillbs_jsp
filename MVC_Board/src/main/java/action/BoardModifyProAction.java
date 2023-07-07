package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardModifyProAction");
		
		ActionForward forward = null;
		
		// 폼 파라미터 데이터를 BoardBean 객체에 저장
		// => 파일 업로드 작업이 없으므로(폼태그에 enctype="multipart/form-data" 가 아님)
		//    request.getParameter() 메서드 호출
		BoardBean board = new BoardBean();
		board.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		System.out.println(board);
		
		// BoardModifyProService - isBoardWriter() 메서드 호출하여 패스워드 판별 작업 요청
		// => 파라미터 : BoardBean 객체   리턴타입 : boolean(isBoardWriter)
		BoardModifyProService service = new BoardModifyProService();
		boolean isBoardWriter = service.isBoardWriter(
				board.getBoard_num(), board.getBoard_pass());
		
		// 패스워드 판별 작업 요청 결과 판별
		// 불일치 시(false) 자바스크립트를 통해 "수정 권한이 없습니다!" 출력 후 이전페이지로 돌아가가ㅣ
		if(!isBoardWriter) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('수정 권한이 없습니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// BoardModifyProService - modifyBoard() 메서드 호출하여 글 수정 작업 요청
			// => 파라미터 : BoardBean 객체    리턴타입 : boolean(isModifySuccess)
			boolean isModifySuccess = service.modifyBoard(board);
			
			// 글 수정 작업 결과 판별
			// 실패 시 자바스크립트를 통해 "글 수정 실패!" 출력 후 이전페이지로 돌아가기
			// 성공 시 글 상세정보 조회 페이지로 리다이렉트
			if(!isModifySuccess) { // 실패
				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("<script>");
					out.print("alert('수정 실패!');");
					out.print("history.back();");
					out.print("</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else { // 성공
				// ActionForward 객체를 사용하여 상세정보 조회 페이지(BoardDetail.bo)로 리다이렉트
				// => 파라미터 : 글번호, 페이지번호
				forward = new ActionForward();
				forward.setPath("BoardDetail.bo?board_num=" + board.getBoard_num() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
			
			
		}
		
		
		return forward;
	}

}
