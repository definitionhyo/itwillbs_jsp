/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-05-22 03:22:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jquery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test5_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	/*\r\n");
      out.write("	특정 요소에 대한 조작 이벤트\r\n");
      out.write("	1. html()\r\n");
      out.write("	   - HTML 문서 내에서 지정된 범위(선택자) 안의 모든 요소를 가져오거나 추가하는 함수\r\n");
      out.write("	   - 요소를 가져올 때 주석까지 포함해서 모든 요소를 가져옴\r\n");
      out.write("	   - 단, XML 문서를 대상으로는 사용 불가\r\n");
      out.write("	2. text()\r\n");
      out.write("	   - html() 함수와 달리 HTML 문서 및 XML 문서 모두 사용 가능\r\n");
      out.write("	   - 모든 문자열을 가져오거나 추가 가능\r\n");
      out.write("	   - 단, 브라우저마다 줄바꿈이나 공백 등이 달라질 수 있음\r\n");
      out.write("	3. empty() \r\n");
      out.write("	   - 지정된 선택자 내의 하위 요소 제거(비움)\r\n");
      out.write("	4. remove()\r\n");
      out.write("	   - 지정된 선택자와 선택자 내의 하위 요소 모두 제거\r\n");
      out.write("	*/\r\n");
      out.write("	$(function() {\r\n");
      out.write("		// h3 태그 내의 HTML 요소 가져오기\r\n");
      out.write("		console.log($(\"h3\").html()); // \"제목1\" 출력\r\n");
      out.write("		\r\n");
      out.write("		// id 선택자가 \"h3_2\" 인 태그의 모든 요소 가져오기\r\n");
      out.write("		console.log($(\"#h3_2\").html());\r\n");
      out.write("		// 제목2&nbsp;<span>제목2-1</span>&nbsp;<span>제목2-2</span> 출력\r\n");
      out.write("		\r\n");
      out.write("		// id 선택자가 \"h3_2\" 인 태그의 모든 텍스트 요소 가져오기\r\n");
      out.write("		console.log($(\"#h3_2\").text()); // 제목2 제목2-1 제목2-2 출력\r\n");
      out.write("		// -----------------------------------------------------------------------\r\n");
      out.write("		// html() 함수를 사용하여 대상 태그의 요소 바꾸기(= 태그 그대로 적용 가능)\r\n");
      out.write("		// id 선택자 \"h3_1\" 인 태그의 요소 내용 바꾸기\r\n");
      out.write("		// => document.querySelector(\"선택자\").innerHTML = \"값\"; 방식과 동일\r\n");
      out.write("// 		$(\"#h3_1\").html(\"<i>italic 적용된 제목1</i>\");\r\n");
      out.write("		\r\n");
      out.write("		// text() 함수를 사용하여 대상 태그의 텍스트 요소 바꾸기(= 태그로 텍스트로 취급)\r\n");
      out.write("		$(\"#h3_1\").text(\"<i>italic 적용된 제목1</i>\");\r\n");
      out.write("		// ----------------------------------------------------------------------------\r\n");
      out.write("		// html() 함수 내에서 익명함수 구현을 통해 반복문 형태로 내용 변경(text() 동일)\r\n");
      out.write("		// => html(function(index, oldHtml) {}) 형태로 정의\r\n");
      out.write("		//    (index : 해당 요소의 인덱스, oldHtml : 기존 내용)\r\n");
      out.write("		// => 해당 태그에 값 변경하려면 return 문 사용\r\n");
      out.write("		$(\"h3\").html(function(index, oldHtml) { // html() -> text() 로 변경 가능\r\n");
      out.write("// 			return oldHtml + \" 입니다.\";\r\n");
      out.write("			// 기존 내용 + 새로운 내용 형태로 대상 태그의 내용 변경\r\n");
      out.write("			return oldHtml + \" <i>입니다.</i>\";\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// ---------------------------------------------------------------------\r\n");
      out.write("		// 대상 요소 제거 : empty(), remove()\r\n");
      out.write("		// empty() 함수 : 선택자 내의 하위 요소들을 제거(= 대상 태그는 남겨둠)\r\n");
      out.write("// 		$(\"#h3_2\").empty(); // <h3> 태그 자체는 남아있음\r\n");
      out.write("		\r\n");
      out.write("		// remove() 함수 : 선택자 및 선택자 내의 하위 요소 제거(= 대상 태그 자체 제거)\r\n");
      out.write("		$(\"#h3_2\").remove(); // <h3> 태그 자체는 남아있음\r\n");
      out.write("		\r\n");
      out.write("		// ----------------------------------------------------------------------------\r\n");
      out.write("		// id 선택자가 \"ta\" 인 textarea 에 id 선택자 \"wrap\" 요소 전체를 출력(태그 포함)\r\n");
      out.write("		$(\"#ta\").val($(\"#wrap\").html());\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>jQuery - test5.jsp</h1>\r\n");
      out.write("	<div id=\"wrap\">\r\n");
      out.write("		<h3 id=\"h3_1\">제목1</h3>\r\n");
      out.write("		<h3 id=\"h3_2\">제목2&nbsp;<span>제목2-1</span>&nbsp;<span>제목2-2</span></h3>\r\n");
      out.write("		<h3 id=\"h3_3\">제목3</h3>\r\n");
      out.write("	</div>\r\n");
      out.write("	<textarea id=\"ta\" rows=\"5\" cols=\"50\"></textarea>\r\n");
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
