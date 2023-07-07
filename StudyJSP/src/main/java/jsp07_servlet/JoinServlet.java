package jsp07_servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp07_servlet/jsp07_join")
public class JoinServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// requestForm3.jsp 페이지로부터 전달받은 폼 파라미터 가져오기
		// 단, POST 방식 요청이므로 한글 인코딩 방식 UTF-8 로 지정
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		// 취미는 동일한 name 속성으로 복수개의 항목이 전달되므로 String[] 타입 사용
		String[] arrHobby = request.getParameterValues("hobby");
		String motivation = request.getParameter("motivation");
		
		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		System.out.println("주민번호 : " + jumin);
		System.out.println("이메일 : " + email);
		System.out.println("직업 : " + job);
		System.out.println("성별 : " + gender);
		// java.util.Arrays 클래스의 toString() 메서드를 호출하여 배열 -> 문자열 변환 가능
		// 또는 반복문 사용하여 배열 내의 데이터 차례대로 접근 후 출력도 가능
//		System.out.println("취미 : " + Arrays.toString(arrHobby));
		System.out.print("취미 : ");
		for(String hobby : arrHobby) {
			System.out.print(hobby + " ");
		}
		System.out.println();
		
		System.out.println("가입동기 : " + motivation);
		
		response.sendRedirect("servlet1_main.jsp");
	}

}












