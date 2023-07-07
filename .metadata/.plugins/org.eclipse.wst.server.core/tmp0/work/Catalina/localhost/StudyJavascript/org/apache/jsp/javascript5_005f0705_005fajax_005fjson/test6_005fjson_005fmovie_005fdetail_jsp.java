/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-07-07 01:21:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.javascript5_005f0705_005fajax_005fjson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test6_005fjson_005fmovie_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("		let key = \"f5eef3421c602c6cb7ea224104795888\";\r\n");
      out.write("		// 영화 상세 정보 조회 요청에 사용될 URL 지정\r\n");
      out.write("		// API 페이지 : https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchMovieInfo\r\n");
      out.write("		// 요청 URL 샘플 : http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=20124079\r\n");
      out.write("		let detailUrl = \"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json\";\r\n");
      out.write("		\r\n");
      out.write("		// URL 로 전달받은 영화코드(movieCd) 파라미터 가져오기\r\n");
      out.write("		let movieCd = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.movieCd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("		\r\n");
      out.write("		// AJAX 를 활용하여 영화 상세정보 조회 API 요청\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			type: \"GET\",\r\n");
      out.write("			url: detailUrl + \"?key=\" + key + \"&movieCd=\" + movieCd,\r\n");
      out.write("			dataType: \"json\",\r\n");
      out.write("			success: function(data) { // 요청 성공 시	\r\n");
      out.write("				// 영화명(국문 - movieNm, 영문 - movieNmEn)\r\n");
      out.write("				// 개봉일(openDt)\r\n");
      out.write("				// 상영시간(showTm)\r\n");
      out.write("				// 감독(directors 배열 내의 peopleNm) - 복수개의 감독 존재 가능\r\n");
      out.write("				// 배우(actors 배열 내의 peopleNm) - 복수개의 배우 존재 가능\r\n");
      out.write("				let movieInfo = data.movieInfoResult.movieInfo;\r\n");
      out.write("// 				alert(JSON.stringify(movieInfo));\r\n");
      out.write("\r\n");
      out.write("				$(\"#movieNm\").html(movieInfo.movieNm + \"<br>(\" + movieInfo.movieNmEn + \")\");\r\n");
      out.write("				$(\"#openDt\").html(movieInfo.openDt);\r\n");
      out.write("				$(\"#showTm\").html(movieInfo.showTm + \"분\");\r\n");
      out.write("				\r\n");
      out.write("				// 감독이 복수개의 객체로 배열에 저장되어 있으므로 반복문 필요\r\n");
      out.write("				for(let director of movieInfo.directors) {\r\n");
      out.write("					$(\"#directors\").append(director.peopleNm + \"<br>\");\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				for(let actor of movieInfo.actors) {\r\n");
      out.write("					$(\"#actors\").append(actor.peopleNm + \"<br>\");\r\n");
      out.write("				}\r\n");
      out.write("// 				\r\n");
      out.write("			},\r\n");
      out.write("			error: function() { // 요청 실패 시\r\n");
      out.write("				$(\"#resultArea\").html(\"<h1>요청 실패!</h1>\");\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>test6_json_movie_detail.jsp - 영화 상세정보 조회</h1>\r\n");
      out.write("	<div id=\"resultArea\">\r\n");
      out.write("		<table border=\"1\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"150\">영화명</th>\r\n");
      out.write("				<td id=\"movieNm\" width=\"400\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>개봉일</th>\r\n");
      out.write("				<td id=\"openDt\" ></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>상영시간</th>\r\n");
      out.write("				<td id=\"showTm\" ></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>감독</th>\r\n");
      out.write("				<td id=\"directors\" ></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>출연진</th>\r\n");
      out.write("				<td id=\"actors\" ></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("	<input type=\"button\" value=\"뒤로가기\" onclick=\"history.back()\">\r\n");
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