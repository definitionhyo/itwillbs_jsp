/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-07-07 00:08:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.javascript5_005f0705_005fajax_005fjson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test5_005fjson_005fmovie_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"../js/jquery-3.7.0.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function() {\r\n");
      out.write("		$(\"#btnOk\").on(\"click\", function() {\r\n");
      out.write("			/*\r\n");
      out.write("			영화진흥위원회 오픈 API 를 활용하여 영화 정보 JSON 데이터 처리\r\n");
      out.write("			https://www.kobis.or.kr/kobisopenapi/homepg/main/main.do\r\n");
      out.write("			--------------------------------------------------------------\r\n");
      out.write("			일별 박스오피스 목록 조회 후 #resultArea 영역 테이블에 표시\r\n");
      out.write("			https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchDailyBoxOffice\r\n");
      out.write("			=> 페이지 내의 요청 URL 을 지정된 요청 파라미터 형식에 맞게 수정 필요\r\n");
      out.write("			\r\n");
      out.write("			샘플 API 요청 주소(단, 대상 조회일자(targetDt)는 어제(2023.07.04)로 변경)\r\n");
      out.write("			https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230704\r\n");
      out.write("			*/\r\n");
      out.write("			let url = \"https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json\";\r\n");
      out.write("			let key = \"f5eef3421c602c6cb7ea224104795888\";\r\n");
      out.write("			\r\n");
      out.write("			// 조회일자(yyyymmdd)\r\n");
      out.write("// 			let targetDt = \"20230704\";\r\n");
      out.write("			\r\n");
      out.write("			// 영화 상세 정보 조회 요청에 사용될 URL 지정\r\n");
      out.write("			// API 페이지 : https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchMovieInfo\r\n");
      out.write("			// 요청 URL 샘플 : http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20124079\r\n");
      out.write("			let detailUrl = \"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json\";\r\n");
      out.write("			\r\n");
      out.write("			// --------------------------------------------------------------------\r\n");
      out.write("			// 조회일자를 캘린더에서 선택할 경우(미선택 시 \"\", 선택 시 yyyy-mm-dd)\r\n");
      out.write("			let selectedDate = $(\"#date\").val(); // 2023-07-04\r\n");
      out.write("// 			alert(selectedDate);\r\n");
      out.write("			\r\n");
      out.write("			// 날짜 미선택 시 캘린더에 포커스 주기(포커스 요청 후 함수 실행 종료)\r\n");
      out.write("			if(selectedDate == \"\") {\r\n");
      out.write("				alert(\"날짜 선택 필수!\");\r\n");
      out.write("				$(\"#date\").focus();\r\n");
      out.write("				return; // 요청이 진행되지 않도록 함수 실행 종료\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			// ---------------------------------------------------------------------\r\n");
      out.write("			// 1. 선택된 날짜를 파라미터(문자열)로 사용하여 Date 객체 생성\r\n");
      out.write("			let objDate = new Date(selectedDate);\r\n");
      out.write("// 			alert(objDate); // Tue Jul 04 2023 09:00:00 GMT+0900 (한국 표준시)\r\n");
      out.write("	\r\n");
      out.write("			// 전달받은 날짜(Date 객체)를 활용하여 요청 파라미터 타입(yyyymmdd)으로 변환\r\n");
      out.write("			// => Date 객체의 메서드를 활용하여 연, 월, 일 데이터 가져오기\r\n");
      out.write("			// 1) 연도 4자리 가져오기\r\n");
      out.write("// 			let year = objDate.getFullYear();\r\n");
      out.write("// 			// 2) 월 2자리 가져오기 => 주의! 0 ~ 11월로 처리되므로 + 1 필수!\r\n");
      out.write("// 			let month = objDate.getMonth() + 1;\r\n");
      out.write("// 			// 3) 일 2자리 가져오기\r\n");
      out.write("// 			let day = objDate.getDate(); // 주의! getDay() 는 요일\r\n");
      out.write("// 			alert(year + \", \" + month + \", \" + day); // 2023, 7, 5\r\n");
      out.write("// 			alert(typeof year + \", \" + typeof month + \", \" + typeof day); // 2023, 7, 5\r\n");
      out.write("			// => 파싱된 날짜는 number 타입이며, 월, 일의 경우 1자리일 때 0 붙여야함\r\n");
      out.write("			//    따라서, 추가적인 작업이 더 수행되어야 yyyymmdd 형식으로 표현 가능\r\n");
      out.write("			// --------------------------------------------------------------------\r\n");
      out.write("			// 2. 캘린더에서 선택된 날짜를 문자열로 그대로 처리\r\n");
      out.write("			// => 전달받은 형식 : yyyy-mm-dd\r\n");
      out.write("			// => 파라미터로 전달할 날짜 형식 : yyyymmdd\r\n");
      out.write("			// 따라서, 조회 대상 일자에 맞는 형식으로 포맷 변환 필요('-' 문자 제거)\r\n");
      out.write("			// ----------\r\n");
      out.write("			// 1) split() 메서드를 통해 기준 문자열(\"-\") 를 기준으로 문자열 분리\r\n");
      out.write("// 			let splitDate = selectedDate.split(\"-\");\r\n");
      out.write("// 			let targetDt = splitDate[0] + splitDate[1] + splitDate[2];\r\n");
      out.write("// 			alert(\"split() 결과 : \" + targetDt); // 20230705\r\n");
      out.write("			\r\n");
      out.write("			// 2) replace() 메서드를 통해 \"-\" 문자를 널스트링(\"\") 으로 치환\r\n");
      out.write("// 			let targetDt = selectedDate.replace(\"-\", \"\"); // 202307-05\r\n");
      out.write("			// replace() 메서드를 연속으로 2번 호출 시 \"-\" 문자 2개 제거\r\n");
      out.write("// 			let targetDt = selectedDate.replace(\"-\", \"\").replace(\"-\", \"\"); // 20230705\r\n");
      out.write("// 			alert(\"replace() 결과 : \" + targetDt); \r\n");
      out.write("			\r\n");
      out.write("			// 3) replaceAll() 메서드로 \"-\" 문자를 널스트링(\"\") 으로 치환\r\n");
      out.write("// 			let targetDt = selectedDate.replaceAll(\"-\", \"\"); // 20230705\r\n");
      out.write("// 			alert(\"replaceAll() 결과 : \" + targetDt); \r\n");
      out.write("			\r\n");
      out.write("			// 4) replace() 메서드의 정규표현식 기능을 활용하여 치환\r\n");
      out.write("			// => 파라미터 중 첫번째 파라미터(탐색할 문자열)에 정규표현식으로\r\n");
      out.write("			//    치환에 사용될 대상 문자열을 지정할 수 있다! => 복합 규칙 설정 가능\r\n");
      out.write("			// => 단, 복수개의 문자열을 탐색 대상으로 지정해야할 경우\r\n");
      out.write("			//    정규표현식 플래그를 활용하여 모든 문자열 대상 지정 필요\r\n");
      out.write("			//    참고) 정규표현식 플래그 종류\r\n");
      out.write("			//    a) /g(global) : 대상 문자열 내에서 패턴에 해당되는 모든 대상 지정\r\n");
      out.write("			//    b) /i(ignore case) : 대상 문자열을 대소문자 무시하고 지정\r\n");
      out.write("			//    c) /m(multi line) : 대상 문자열이 복수개의 라인일 경우 전체 라인 지정\r\n");
      out.write("			let targetDt = selectedDate.replace(/-/g, \"\"); // 한 라인의 모든 \"-\" 제거\r\n");
      out.write("// 			alert(\"replace() 결과 : \" + targetDt); // 20230705\r\n");
      out.write("			// --------------------------------------------------------------------\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				type: \"GET\",\r\n");
      out.write("				url: url + \"?key=\" + key + \"&targetDt=\" + targetDt,\r\n");
      out.write("				dataType: \"json\",\r\n");
      out.write("				success: function(data) { // 요청 성공 시	\r\n");
      out.write("					// 임시) #resultArea 영역에 응답 데이터를 문자열로 출력\r\n");
      out.write("// 					$(\"#resultArea\").html(JSON.stringify(data));\r\n");
      out.write("					// -------------------------------------------------------\r\n");
      out.write("					// 응답데이터(박스오피스 목록 = data 객체)로부터 박스오피스 정보 추출\r\n");
      out.write("					// => 전체 데이터가 하나의 객체({})로 묶여 있음\r\n");
      out.write("					// 1. 박스오피스 목록 전체 데이터가 저장된 \"boxOfficeResult\" 객체 추출\r\n");
      out.write("					let boxOfficeResult = data.boxOfficeResult;\r\n");
      out.write("// 					$(\"#resultArea\").html(JSON.stringify(boxOfficeResult));\r\n");
      out.write("					\r\n");
      out.write("					// 2. 박스오피스 타입(boxofficeType), 조회날짜(showRange) 추출\r\n");
      out.write("					// => 1번에서 추출한 boxOfficeResult 객체를 통해 접근\r\n");
      out.write("					// => 두 데이터는 객체가 아닌 일반 속성이므로 변환 없이도 접근 가능\r\n");
      out.write("					let boxOfficeType = boxOfficeResult.boxofficeType;\r\n");
      out.write("					let showRange = boxOfficeResult.showRange;\r\n");
      out.write("// 					$(\"#resultArea\").html(boxOfficeType + \", \" + showRange);\r\n");
      out.write("					\r\n");
      out.write("					// 3. 일별 박스오피스 목록(dailyBoxOfficeList) 추출\r\n");
      out.write("					// => 복수개의 영화정보 객체{}가 dailyBoxOfficeList 배열[]로 관리됨\r\n");
      out.write("					// => 단, 배열 내의 데이터도 객체이므로 전체 출력 시 변환 필요\r\n");
      out.write("					let dailyBoxOfficeList = boxOfficeResult.dailyBoxOfficeList;\r\n");
      out.write("// 					$(\"#resultArea\").html(JSON.stringify(dailyBoxOfficeList));\r\n");
      out.write("					\r\n");
      out.write("					// 4. 추출된 박스오피스 목록(배열)을 반복문을 통해 접근하여\r\n");
      out.write("					//    순위(rank), 제목(movieNm), 개봉일(openDt), 누적관객수(audiAcc) \r\n");
      out.write("					//    추출 후 테이블에 추가\r\n");
      out.write("					// => 단, 기존 영화 목록 제거 후 새로 추가\r\n");
      out.write("// 					$(\"#resultArea > table\").remove(); // 선택자 요소까지 제거\r\n");
      out.write("// 					$(\"#resultArea > table\").empty(); // 선택자 요소내의 요소만 제거\r\n");
      out.write("					// => 테이블을 미리 생성해두었으므로 영화목록만 제거\r\n");
      out.write("					$(\".movieItem\").remove();\r\n");
      out.write("					\r\n");
      out.write("					for(let movie of dailyBoxOfficeList) {\r\n");
      out.write("						$(\"#resultArea > table\").append(\r\n");
      out.write("							\"<tr class='movieItem'>\"\r\n");
      out.write("							+ \"<td>\" + movie.rank + \"</td>\"\r\n");
      out.write("							+ \"<td>\" + movie.movieNm + \"</td>\"\r\n");
      out.write("							+ \"<td>\" + movie.openDt + \"</td>\"\r\n");
      out.write("							+ \"<td>\" + movie.audiAcc + \"</td>\"\r\n");
      out.write("							+ \"<td>\" + movie.movieCd + \"</td>\"\r\n");
      out.write("							+ \"<td><input type='button' value='상세정보' onclick=''></td>\"\r\n");
      out.write("							+ \"</tr>\"\r\n");
      out.write("					);\r\n");
      out.write("				}\r\n");
      out.write("				},\r\n");
      out.write("				error: function() { // 요청 실패 시\r\n");
      out.write("					$(\"#resultArea\").html(\"<h1>요청 실패!</h1>\");\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("		}); // 버튼 이벤트 끝\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>test5_json_movie_list.jsp - 일별 박스오피스</h1>\r\n");
      out.write("	<input type=\"date\" id=\"date\">\r\n");
      out.write("	<input type=\"button\" value=\"일별 박스오피스 조회\" id=\"btnOk\">\r\n");
      out.write("	<div id=\"resultArea\">\r\n");
      out.write("		<table border=\"1\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"80\">현재순위</th>\r\n");
      out.write("				<th width=\"400\">영화명</th>\r\n");
      out.write("				<th width=\"150\">개봉일</th>\r\n");
      out.write("				<th width=\"100\">누적관객수</th>\r\n");
      out.write("				<th width=\"100\">영화코드</th>\r\n");
      out.write("				<th></th>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
