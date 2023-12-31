/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-05-23 03:40:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jquery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test11_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	// on(\"change\", function() {})\r\n");
      out.write("	// => 특정 대상의 \"상태가 변하면\" 동작하는 이벤트 처리\r\n");
      out.write("	$(function() {\r\n");
      out.write("		$(\"table\").css(\"text-align\", \"center\");\r\n");
      out.write("		$(\"table\").css(\"width\", \"400px\");\r\n");
      out.write("		// -----------------------------------------\r\n");
      out.write("		// 전체선택 체크박스 상태 변화 감지 이벤트\r\n");
      out.write("		$(\"#allCheck\").on(\"change\", function() {\r\n");
      out.write("			// 전체선택 체크 시 모든 체크박스 체크, 체크 해제 시 모두 해제\r\n");
      out.write("// 			if($(\"#allCheck\").prop(\"checked\")) { // 체크 시\r\n");
      out.write("// 				alert(\"체크!\");\r\n");
      out.write("// 			} else { // 체크해제 시\r\n");
      out.write("// 				alert(\"체크해제!\");\r\n");
      out.write("// 			}\r\n");
      out.write("			\r\n");
      out.write("			if($(\"#allCheck\").is(\":checked\")) { // 체크 시\r\n");
      out.write("				// 체크박스들의 checked 속성값을 체크 상태(true)로 변경 - prop() 활용\r\n");
      out.write("				// => input[type=checkbox] 대신 가상선택자 :checkbox 사용 가능\r\n");
      out.write("				// => prop() 메서드 파라미터로 속성명, 속성값 전달 시 속성 변경 가능\r\n");
      out.write("				$(\":checkbox\").prop(\"checked\", true); // 체크 상태를 체크(true)로 변경\r\n");
      out.write("\r\n");
      out.write("				// each() 메서드를 통해 체크박스 반복으로 각 요소의 상태 변경도 가능함\r\n");
      out.write("// 				$(\":checkbox\").each(function(index, item) {\r\n");
      out.write("// // 					$(item).prop(\"checked\", true);\r\n");
      out.write("// 					$(this).prop(\"checked\", true);\r\n");
      out.write("// 				});\r\n");
      out.write("			} else { // 체크해제 시\r\n");
      out.write("				$(\":checkbox\").prop(\"checked\", false); // 체크 상태를 체크해제(false)로 변경\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 셀렉트박스 항목 선택(변경) 시 이벤트 처리\r\n");
      out.write("		$(\"#selectBox\").on(\"change\", function() {\r\n");
      out.write("// 			alert($(\"#selectBox\").val() + \" 선택됨!\");\r\n");
      out.write("\r\n");
      out.write("			// 셀렉트박스의 특정 항목 선택 여부 판별 시(전체 선택 여부 판별)\r\n");
      out.write("// 			if($(\"#selectBox\").val() == \"전체\") {\r\n");
      out.write("// 				alert(\"전체 선택\");\r\n");
      out.write("// 			}\r\n");
      out.write("			\r\n");
      out.write("			if($(\"#selectBox > option\").eq(0).is(\":checked\")) {\r\n");
      out.write("				alert(\"전체 선택\");\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 텍스트 박스에 대한 입력값 이벤트\r\n");
      out.write("		// blur : 포커스가 해제될 때 이벤트 수행(값 변경과는 무관)\r\n");
      out.write("		// keyup : 키보드를 눌렀다 뗄 때 이벤트 수행(값 변경과는 무관함)\r\n");
      out.write("		// change : 이전 동작 기준으로 현재 값이 변경됐을 때 이벤트 수행\r\n");
      out.write("		//          => 값 변경 없으면 이벤트 동작 X\r\n");
      out.write("// 		$(\"input[name=searchKeyword]\").on(\"blur\", function() {\r\n");
      out.write("// 			alert(\"포커스 해제!\");\r\n");
      out.write("// 			$(\"#result\").html($(\"input[name=searchKeyword]\").val());\r\n");
      out.write("// 		});\r\n");
      out.write("		\r\n");
      out.write("// 		$(\"input[name=searchKeyword]\").on(\"keyup\", function() {\r\n");
      out.write("// 			alert(\"키보드 눌렀다 뗌!\");\r\n");
      out.write("// 			$(\"#result\").html($(\"input[name=searchKeyword]\").val());\r\n");
      out.write("// 		});\r\n");
      out.write("		\r\n");
      out.write("		$(\"input[name=searchKeyword]\").on(\"change\", function() {\r\n");
      out.write("			alert(\"내용 변경됨!\");\r\n");
      out.write("			$(\"#result\").html($(\"input[name=searchKeyword]\").val());\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>jQuery - test11.jsp</h1>\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"3\">\r\n");
      out.write("				<select id=\"selectBox\" name=\"grade\">\r\n");
      out.write("					<option value=\"전체\">전체</option>\r\n");
      out.write("					<option value=\"VIP\">VIP</option>\r\n");
      out.write("					<option value=\"일반\">일반</option>\r\n");
      out.write("				</select>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("            <th><input type=\"checkbox\" id=\"allCheck\"></th>\r\n");
      out.write("            <th>번호</th>\r\n");
      out.write("            <th>이름</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><input type=\"checkbox\" name=\"check\"></td>\r\n");
      out.write("            <td>1</td>\r\n");
      out.write("            <td>홍길동</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><input type=\"checkbox\" name=\"check\"></td>\r\n");
      out.write("            <td>2</td>\r\n");
      out.write("            <td>이순신</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td><input type=\"checkbox\" name=\"check\"></td>\r\n");
      out.write("            <td>3</td>\r\n");
      out.write("            <td>강감찬</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        	<td colspan=\"3\">\r\n");
      out.write("        		<select id=\"searchType\" name=\"searchType\">\r\n");
      out.write("					<option value=\"이름\">이름</option>\r\n");
      out.write("					<option value=\"아이디\">아이디</option>\r\n");
      out.write("				</select>\r\n");
      out.write("        		<input type=\"text\" name=\"searchKeyword\" placeholder=\"검색어입력\">\r\n");
      out.write("        	</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("	</table>\r\n");
      out.write("   	<div id=\"result\"></div>\r\n");
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
