package jsp11_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨텍스트 루트 뒤의 서블릿 주소가 xxxxxxx.st 로 끝나는 주소일 경우 모두 매핑됨
// => ex) http://localhost:8080/StudyJSP/jsp11_servlet/xxxxxx.st
// => ex) http://localhost:8080/StudyJSP/MemberList.st
// => 단, 각각의 서블릿 주소에 따른 작업을 별도로 수행하려면 서블릿 주소 구별 필요함
@WebServlet("*.st")
public class StudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET&POST 방식 요청에 대해 공통으로 작업을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET&POST 방식 요청에 대해 공통으로 작업을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}
	
	// GET 방식 요청에 대한 doGet() 메서드와 POST 방식 요청에 대한 doPost() 메서드에서
	// 각각 별도로 처리할 작업을 하나의 메서드(doProcess())로 통합
	// => doProcess() 메서드 정의(파라미터 : request, response 객체)
	// => doGet(), doPost() 메서드에서 doProcess() 메서드를 호출
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentServlet - doProcess() 호출됨!");
		
		// POST 방식 요청에 대한 한글 인코딩 방식 변경 처리
		request.setCharacterEncoding("UTF-8");
		
		// ==================================================================
		// 주소표시줄에 입력되어 있는 URL 에서 서블릿 주소 부분을 가져와서
		// 각 서블릿 주소 판별을 통해 수행해야할 동작을 결정해야한다.
		// 따라서, 요청 정보가 저장된 request 객체에서 서블릿 주소 추출 필요!
		// ex) /jsp11_servlet/StudentInsertForm.st 주소 요청과
		//     /jsp11_servlet/StudentList.st 주소 요청에 대한 동작이 다르므로
		//     URL 에서 서블릿 주소(= 프로젝트명 뒷부분의 /xxx.yy)를 추출 후
		//     문자열 비교를 통해 각 서블릿 주소 판별 작업을 수행해야함
		// ------------------------------------------------------------------
		// < 서블릿 주소 추출 과정 >
		// 0. 참고) 요청 주소(전체 URL) 추출(= 가져오기)
//		String requestURL = request.getRequestURL().toString();
//		System.out.println("requestURL : " + requestURL);
		// requestURL : http://localhost:8080/StudyJSP/jsp11_servlet/StudentList.st
		// => 단, 서버마다 IP 주소나 서비스 포트번호 등이 달라질 수도 있으므로
		//    요청 주소(URL) 전체를 문자열로 판별하는 작업은 비효율적이다.
		// => 공통 부분을 제외한 나머지(= 서블릿 주소) 부분만 추출 가능
		// ---------
		// 1. 요청 주소 중 URI 부분(/프로젝트명(컨텍스트경로)/서블릿주소) 추출
		String requestURI = request.getRequestURI();
		System.out.println("requestURI : " + requestURI);
		// requestURI : /StudyJSP/jsp11_servlet/StudentList.st
		// => URI 중 컨텍스트 경로 부분을 제외한 나머지(= 서블릿주소) 추출 필요
		// ----------
		// 2. 요청 주소 중 컨텍스트 경로(/프로젝트명) 추출
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		// contextPath : /StudyJSP
		// ----------
		// 3. 요청 주소 중 서블릿주소 부분(/서블릿주소) 추출
		// => requestURI 와 contextPath 를 가공해서 추출
		// ex) /StudyJSP/jsp11_servlet/StudentList.st => "/jsp11_servlet/StudentList.st"
		// 방법1) requestURI 중에서 "/서블릿주소"에 해당하는 부분문자열 추출
		// => String - substring() 메서드 활용
		//    requestURI 주소 중에서 "/jsp11_servlet/StudentList.st" 추출이 필요하므로
		//    "/StudyJSP" 문자열의 길이를 알아낸 후 시작 인덱스로 지정한 후
		//    해당 문자열의 마지막까지 추출할 수 있다!
		// => ex) "/StudyJSP" 문자열 길이가 9이므로 서블릿 주소 시작인덱스인 9번 지정 가능
//		String command = requestURI.substring(contextPath.length());
//		System.out.println("command : " + command);
		
		// 방법2) requestURI 중에서 contextPath 부분을 널스트링("")으로 치환(교체)
		// => String - replace() 메서드 활용
//		String command = requestURI.replace(contextPath, "");
//		System.out.println("command : " + command);
		// ============================================================================
		// 위의 1 ~ 3번 과정을 하난의 메서드로 압축하여 제공
		// => request 객체의 getServletPath() 메서드 활용
		String command = request.getServletPath();
		System.out.println("command : " + command);
		// ---------------------------------------------------------
		// 추출된 서블릿 주소(command)를 if 문을 통해 문자열 비교를 수행하고
		// 각 주소에 따른 작업(= 액션)을 수행
		if(command.equals("/jsp11_servlet/StudentInsertForm.st")) {
			System.out.println("학생 등록 폼!");
			// 학생 등록 폼을 출력하는 뷰페이지(jsp11_servlet/student_insert_form.jsp)로 이동
			// => 비즈니스 로직(= DB 작업) 불필요하므로 뷰페이지로 바로 이동
			// => 주소표시줄 변경 없이 기존 서블릿 주소가 유지 = Dispatch 방식 포워딩
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("student_insert_form.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/jsp11_servlet/StudentInsertPro.st")) {
			System.out.println("학생 등록 작업!");
			
			// 전달받은 폼 파라미터 데이터를 가져와서 StudentDTO 객체에 저장
			StudentDTO student = new StudentDTO();
			student.setIdx(Integer.parseInt(request.getParameter("idx")));
			student.setName(request.getParameter("name"));
//			System.out.println(student);
			
			// 학생 등록 작업 처리를 수행할 StudentDAO 클래스 인스턴스 생성 후
			// insert() 메서드를 호출
			// => 파라미터 : StudentDTO 객체(student)   리턴타입 : int(insertCount)
			StudentDAO dao = new StudentDAO();
			int insertCount = dao.insert(student);
			
			// 등록 작업 성공/실패 여부 판별
			// 성공일 경우 "StudentList.st" 서블릿 주소 요청(리다이렉트)
			// 실패일 경우 자바스크립트로 "등록 실패!" 출력 후 이전페이지로 돌아가기
			if(insertCount > 0) { // 성공
				response.sendRedirect("StudentList.st");
			} else { // 실패
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록 실패!')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
			}
			
		} else if(command.equals("/jsp11_servlet/StudentList.st")) {
			System.out.println("학생 목록 조회 작업!");
			
			// 학생 목록 조회를 위한 StudentDAO - selectStudentList() 메서드 호출
			// => 파라미터 : 없음   리턴타입 : List<StudentDTO>(studentList)
			StudentDAO dao = new StudentDAO();
			List<StudentDTO> studentList = dao.selectStudentList();
			
			// 뷰페이지로 학생 목록을 전달하기 위해 
			// request 객체의 setAttribute() 메서드를 통해 List 객체 저장("studentList")
			request.setAttribute("studentList", studentList);
			
			// 뷰페이지(student_list.jsp) 포워딩
			// => URL 유지 및 request 객체 유지를 위해 Dispatch 방식 포워딩
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("student_list.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
}













