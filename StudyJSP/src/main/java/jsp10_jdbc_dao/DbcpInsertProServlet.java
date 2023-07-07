package jsp10_jdbc_dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp10_jdbc_dao/DbcpInsertPro")
public class DbcpInsertProServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DbcpInsertProServlet");
		
		// 번호(idx)와 이름(name) 파라미터 가져와서 변수에 저장
		request.setCharacterEncoding("UTF-8"); // POST 방식 한글 인코딩 처리
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		
		// 데이터베이스 작업을 수행하기 위해 StudentDAO 클래스의 인스턴스 생성
		StudentDAO dao = new StudentDAO();
		
		// StudentDAO - insert() 메서드를 호출하여 INSERT 작업 요청
		// => 파라미터 : 번호(idx), 이름(name)    리턴타입 : int(insertCount)
//		int insertCount = dao.insert(idx, name);
		
		// -----------------------------------------------------------------
		// 데이터베이스에 사용될 데이터를 각각의 변수로 다루지 않고
		// 하나의 객체(묶음)로 다루기 위해 DTO 객체 생성하여 저장할 수 있다!
		// 1. StudentDTO 클래스의 인스턴스 생성
		StudentDTO student = new StudentDTO();
		// 2. StudentDTO 인스턴스에 데이터 저장 => Setter 메서드 활용
		student.setIdx(idx);
		student.setName(name);
//		System.out.println(student.getIdx() + ", " + student.getName());
		
		// 만약, toString() 메서드 오버라이딩 했을 경우 인스턴스 변수 그대로 출력
		// => 출력문에는 DTO 객체의 변수명만 지정해도 toString() 이 자동으로 호출됨
		// => 만약, String 타입 변수에 toString() 리턴값을 저장하려면 toString() 명시!!
//		System.out.println(student); // toString() 생략되어 있음
		
		// 3. StudentDAO - insert() 메서드를 호출하여 INSERT 작업 요청 시
		//    파라미터로 각각의 변수 대신 StudentDTO 인스턴스 전달
		// => 파라미터 : StudentDTO 객체    리턴타입 : int(insertCount)
		int insertCount = dao.insert(student);
		
		// -----------------------------------------------------------------
		
		// 데이터 추가(INSERT) 작업 결과 판별하여 후속 처리
		// => 성공 시 "INSERT 성공!" 출력하고, 실패 시 "INSERT 실패!" 출력
		if(insertCount > 0) { // 성공
			System.out.println("INSERT 성공!");
			
			// 가입 결과 확인(회원 목록 조회)을 위해 SELECT 페이지로 이동
			// => DbcpSelect 서블릿 주소 요청 = Redirect
//			response.sendRedirect("DbcpSelect");
			
			// -------------------------------------------------------------------
			// 자바스크립트를 사용하여 "INSERT 성공!" 출력 후 SELECT 페이지로 이동
			// => 주의! 자바 코드의 리다이렉트 처리와 자바스크립트 출력은 동시 사용 불가!
			// => 자바스크립트 location 객체의 href 속성으로 페이지 이동 처리!!
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('INSERT 성공!')");
			// location.href 속성으로 페이지 이동 처리
			out.println("location.href = 'DbcpSelect'");
			out.println("</script>");
		} else { // 실패
			System.out.println("INSERT 실패!");
			
			// 자바스크립트를 사용하여 "INSERT 실패!" 출력 후 이전페이지로 돌아가기
			// => 웹브라우저로 HTML 태그 등을 응답데이터로 내보내기(= 출력) 위한 작업 수행
			//    (자바 클래스 내에서 출력스트림을 활용하여 HTML 태그 문자열 출력해야함)
			// => 응답 데이터 생성을 위해 응답 객체인 response 객체 활용
			// 1) 출력할 HTML 형식에 대한 문서 타입(contentType) 설정
			//    => 응답 데이터 타입으로 HTML 태그가 사용됨을 클라이언트에게 알려줌
			//    => response 객체의 setContentType() 메서드 호출하여 문서 타입 전달
			//       (JSP 문서 최상단의 page 디렉티브 내의 contentType=xxx 항목 활용)
			response.setContentType("text/html; charset=UTF-8");
			
			// 2) 자바 코드를 사용하여 HTML 태그 등을 출력(전송)하려면
			//    java.io.PrintWriter 객체 필요함(= 출력스트림으로 사용할 객체)
			//    => response 객체의 getWriter() 메서드를 호출하여 얻어올 수 있다!
			PrintWriter out = response.getWriter();
			
			// 3) PrintWriter 객체(out)의 print() 또는 println() 메서드를 호출하여
			//    파라미터로 HTML 태그 등의 코드를 문자열로 전달
			out.println("<script>");
			out.println("alert('INSERT 실패!')");
			out.println("history.back()");
			out.println("</script>");
			
			// 4) PrintWriter 객체의 모든 데이터를 전송(비워내기)하기 위해
			//    flush() 메서드 호출
			out.flush();
		}
		
	}

}















