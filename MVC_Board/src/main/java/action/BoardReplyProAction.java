package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardReplyProService;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardReplyProAction");
		
		ActionForward forward = null;
		
		try {
			// 업로드에 사용될 가상 디렉토리(폴더) 지정
			// => upload 폴더 이클립스 프로젝트에 생성 필요
			String uploadPath = "upload"; // webapp 디렉토리 내의 upload 디렉토리 지정
			String realPath = request.getServletContext().getRealPath(uploadPath);
//			System.out.println("실제 업로드 경로 : " + realPath);
			// D:\Shared\JSP\workspace_jsp5\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MVC_Board\ upload
			
			// 최대 업로드 파일 사이즈 지정(10MB 로 제한)
			int fileSize = 1024 * 1024 * 10;
			
			// 파일 업로드 처리를 위한 MultipartRequest 객체 생성 => cos.jar 라이브러리 필요
			MultipartRequest multi = new MultipartRequest(
					request,    // 1) 실제 요청 정보(파라미터)가 포함된 request 객체
					realPath, // 2) 실제 업로드 경로(getRealPath() 로 알아낸 경로)
					fileSize,   // 3) 업로드 파일 최대 크기
					"UTF-8",    // 4) 한글 파일명 처리를 위한 인코딩 방식
					new DefaultFileRenamePolicy() // 5) 중복 파일명을 처리할 객체
			);
			// => MultipartRequest 객체가 생성되는 시점에 업로드 파일이 실제로 업로드 됨
			
			// 전달받은 폼 파라미터(데이터)를 BoardBean 객체에 저장
			BoardBean board = new BoardBean();
			// 주의! request 객체의 getParameter() 메서드 호출 시 데이터 가져올 수 없다!
			// MultipartRequest 객체의 getParameter() 메서드 호출 필수!
			board.setBoard_name(multi.getParameter("board_name"));
			board.setBoard_pass(multi.getParameter("board_pass"));
			board.setBoard_subject(multi.getParameter("board_subject"));
			board.setBoard_content(multi.getParameter("board_content"));
			board.setBoard_content(multi.getParameter("board_content"));
			
			// 참조글번호, 들여쓰기레벨, 순서번호도 가져와서 저장
			board.setBoard_re_ref(Integer.parseInt(multi.getParameter("board_re_ref")));
			board.setBoard_re_lev(Integer.parseInt(multi.getParameter("board_re_lev")));
			board.setBoard_re_seq(Integer.parseInt(multi.getParameter("board_re_seq")));
			
			// 주의! 파일명은 getParameter() 메서드로 단순 처리 불가능
			board.setBoard_file(multi.getOriginalFileName("board_file")); // 원본 파일
			board.setBoard_real_file(multi.getFilesystemName("board_file")); // 실제 업로드 파일
			// 만약, 파일명이 null 일 경우 널스트링("") 값 저장
			if(board.getBoard_file() == null) {
				board.setBoard_file(""); // 원본 파일
				board.setBoard_real_file(""); // 실제 업로드 파일
			}
//			System.out.println(board);
			// -------------------------------------------------------------
			// BoardReplyProService - registReplyBoard() 메서드를 호출하여
			// 답글 쓰기 작업 요청
			// => 파라미터 : BoardBean 객체    리턴타입 : boolean(isWriteSuccess)
			BoardReplyProService service = new BoardReplyProService();
			boolean isWriteSuccess = service.registReplyBoard(board);
			
			// 답글 쓰기 요청 처리 결과 판별
			// => 실패 시 자바스크립트를 통해 "답글 쓰기 실패!" 출력 후 이전페이지로 돌아가기
			//    성공 시 글목록 표시를 위해 "BoardList.bo" 서블릿 주소 요청
			if(!isWriteSuccess) { // 실패
				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.print("<script>");
					out.print("alert('글쓰기 실패!');");
					out.print("history.back();");
					out.print("</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else { // 성공
				forward = new ActionForward();
				forward.setPath("BoardList.bo");
				forward.setRedirect(true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}










