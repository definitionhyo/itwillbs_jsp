package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDeleteProAction");
		
		ActionForward forward = null;
		
		// 글 삭제에 필요한 글번호, 패스워드 파라미터 가져오기
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_pass = request.getParameter("board_pass");
//		System.out.println("board_num = " + board_num + ", board_pass = " + board_pass);
		// 페이지번호(pageNum)는 현재 작업에서 실제로 활용되는 데이터가 아니므로
		// 다음 페이지 이동 시 URL 또는 request 객체에 전달하기만 하면 된다!
		// 또한, Dispatch 방식 포워딩 시 URL 유지되므로 별도의 작업 불필요
		
		// BoardDeleteProService - isBoardWriter() 메서드를 호출하여
		// 글 삭제 가능 여부 판별
		// => 파라미터 : 글번호, 패스워드    리턴타입 : boolean(isBoardWriter)
		BoardDeleteProService service = new BoardDeleteProService();
		boolean isBoardWriter = service.isBoardWriter(board_num, board_pass);
		
		// 작업 결과 판별
		// 만약, 일치하지 않으면(isBoardWriter 가 false)
		// 자바스크립트를 사용하여 "삭제 권한이 없습니다!" 출력 후 이전페이지로 돌아가기
		if(!isBoardWriter) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('삭제 권한이 없습니다!');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 패스워드 일치할 경우(= 삭제 권한이 있을 경우)
			// 파일 삭제를 위한 실제 업로드 파일명 조회
			// => BoardDeleteProService - getBoardRealFile() 메서드 호출
			// => 주의! 레코드 삭제 전 조회 작업 먼저 수행 필수!
			// => 파라미터 : 글번호   리턴타입 : String(board_real_file) => 실제 파일
			String board_real_file = service.getBoardRealFile(board_num);
			
			// BoardDeleteProService - removeBoard() 메서드 호출하여 게시물 삭제
			// => 파라미터 : 글번호   리턴타입 : boolean(isDeleteSuccess)
			boolean isDeleteSuccess = service.removeBoard(board_num);
			
			// 삭제 결과 판별
			// 실패 시(isDeleteSuccess 가 false) 자바스크립트로 "삭제 실패!" 출력 후 이전페이지로 돌아가기
			// 성공 시 BoardList.bo 페이지로 리다이렉트
			if(!isDeleteSuccess) {
				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("<script>");
					out.print("alert('삭제 실패!');");
					out.print("history.back();");
					out.print("</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					// -------- 삭제 성공 시 실제 업로드 된 파일 삭제 작업 수행 --------
					// 1. 가상 업로드 디렉토리(이클립스 상의 폴더) 지정
					String uploadPath = "upload";
					// 2. 실제 톰캣 상의 업로드 디렉토리 알아내기
					String realPath = request.getServletContext().getRealPath(uploadPath);
					// 3. java.nio.file.Paths 클래스의 get() 메서드를 호출하여
					//    파일 경로를 관리하는 객체 생성(파라미터 : "경로명/파일명")
					//    => 리턴타입 : java.nio.file.Path
					Path path = Paths.get(realPath + "/" + board_real_file);
					// 4. java.nio.file.Files 클래스의 deleteIfExists() 메서드를 호출하여
					//    실제 파일 삭제 작업 수행(파라미터 : Path 객체)
					Files.deleteIfExists(path);
				} catch (IOException e) {
					System.out.println("삭제할 파일이 존재하지 않습니다!");
				}
				// -----------------------------------------------------------------
				// ActionForward 객체를 사용하여 글목록(BoardList.bo) 페이지로 리다이렉트
				forward = new ActionForward();
				forward.setPath("BoardList.bo?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}









