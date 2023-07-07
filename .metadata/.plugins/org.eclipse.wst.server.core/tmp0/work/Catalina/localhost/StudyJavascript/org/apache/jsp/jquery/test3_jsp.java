/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-05-22 02:12:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jquery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("	선택자(Selector)\r\n");
      out.write("	- 문서 객체 내의 요소 선택을 위한 용도로 사용하는 구성 요소\r\n");
      out.write("	- 자바스크립트에서 사용하는 document.getElementByXXX(\"선택자명\") 또는\r\n");
      out.write("	  document.querySelector(\"선택자\") 메서드 호출과 달리\r\n");
      out.write("	  jQuery 에서는 $(\"선택자\") 형태로 대상을 지정하므로 문장이 간결해짐\r\n");
      out.write("	\r\n");
      out.write("	< 선택자 사용 기분 문법 >\r\n");
      out.write("	$(\"선택자\" 또는 \"*\").함수명(\"속성명\");            =>  특정 속성값 확인\r\n");
      out.write("	$(\"선택자\" 또는 \"*\").함수명(\"속성명\", \"속성값\");  =>  특정 속성값 변경\r\n");
      out.write("	\r\n");
      out.write("	ex) 지정한 요소에 대한 CSS 속성 변경하는 기본 문법\r\n");
      out.write("	$(\"선택자\").css(\"속성명\", \"속성값\");\r\n");
      out.write("	-----------------------------------------------------------------------------------\r\n");
      out.write("	1. 직접 선택자 - 특정 대상(요소)을 직접 지정하기 위한 선택자\r\n");
      out.write("	   1) 아이디(#) - 페이지 내에서 유일한 요소 => $(\"#선택자명\")\r\n");
      out.write("	   2) 클래스(.) - 복수개의 동일한 요소 => $(\".선택자명\")\r\n");
      out.write("	   3) 태그 - 동일한 태그를 갖는 복수개의 요소 => $(\"태그명\")\r\n");
      out.write("	   4) 태그 속성 - 동일한 태그들 중 특정 속성만 지정 => $(\"태그명[속성명]\")\r\n");
      out.write("	   5) 태그 속성 값 - 동일한 태그의 동일한 속성들 중 특정 속성값 지정 => $(\"태그명[속성명=값]\")\r\n");
      out.write("	*/\r\n");
      out.write("	// ready 이벤트를 정의하여 문서 내의 선택자 요소에 접근\r\n");
      out.write("// 	$(document).ready(function() {\r\n");
      out.write("// 		alert(\"ready 이벤트\");\r\n");
      out.write("// 	});\r\n");
      out.write("	   \r\n");
      out.write("	$(function() {\r\n");
      out.write("// 		alert(\"ready 이벤트222\");\r\n");
      out.write("\r\n");
      out.write("		// 전체 요소(*)에 대한 CSS 속성을 변경\r\n");
      out.write("		// => 모든 요소에 대해 글자색(\"COLOR\" 속성)에 대한 속성값을 \"RED\" 로 변경\r\n");
      out.write("		$(\"*\").css(\"color\", \"red\");\r\n");
      out.write("		\r\n");
      out.write("		// id 선택자(#) 중 \"idSelector\" 라는 이름을 갖는 요소의 글자색을 \"BLUE\" 로 변경\r\n");
      out.write("		$(\"#idSelector\").css(\"color\", \"blue\");\r\n");
      out.write("		// => \"idSelector\" 선택자의 \"COLOR\" 속성에 대한 속성값 접근(확인)\r\n");
      out.write("// 		alert($(\"#idSelector\").css(\"color\")); // rgb(0, 0, 255) = blue\r\n");
      out.write("		\r\n");
      out.write("		// class 선택자(.) 중 \"classSelector\" 라는 이름을 갖는 요소들의 글자색 \"ORANGE\" 로 변경\r\n");
      out.write("		$(\".classSelector\").css(\"color\", \"orange\");\r\n");
      out.write("// 		alert($(\".classSelector\").css(\"color\")); // rgb(255, 165, 0) = orange\r\n");
      out.write("		// ---------------------------------------------------------------------------\r\n");
      out.write("		// 태그 지정하기\r\n");
      out.write("		// table 태그 지정하여 대상의 테두리, 배경색 변경\r\n");
      out.write("		// => 별도의 선택자 기호 없이 태그명으로 접근\r\n");
      out.write("		// 1) table 태그의 테두리(\"border\" 속성)를 \"1px solid blue\" 로 변경\r\n");
      out.write("// 		$(\"table\").css(\"border\", \"1px solid blue\");\r\n");
      out.write("		// 2) table 태그의 배경색(\"background\" 속성)을 \"yellow\" 로 변경\r\n");
      out.write("// 		$(\"table\").css(\"background\", \"yellow\");\r\n");
      out.write("		\r\n");
      out.write("		// 동일한 대상에 복수개의 함수를 호출하여 속성을 변경할 경우\r\n");
      out.write("		// 각각의 함수를 연결하여 연쇄적으로 호출 가능하다!\r\n");
      out.write("// 		$(\"table\").css(\"border\", \"1px solid blue\").css(\"background\", \"pink\");\r\n");
      out.write("		\r\n");
      out.write("		// 동일한 대상에 동일한 함수를 호출하는 경우\r\n");
      out.write("		// css() 함수 내에서 블록문{} 을 지정하여 복수개의 속성을 한번에 변경 가능\r\n");
      out.write("		// => 실제 CSS 와 유사함\r\n");
      out.write("		$(\"table\").css({\r\n");
      out.write("			border: \"1px solid blue\",\r\n");
      out.write("			background: \"lightgray\"\r\n");
      out.write("		});\r\n");
      out.write("		// --------------------------------------------\r\n");
      out.write("		// 태그의 특정 속성값을 지정하기\r\n");
      out.write("		// => $(\"태그명[속성명]\") 또는 $(\"태그명[속성명=속성값]\")\r\n");
      out.write("		// input 태그들 중 type 속성값이 \"text\" 인 요소의 배경색 \"yellow\" 로 변경\r\n");
      out.write("		$(\"input[type=text]\").css(\"background\", \"yellow\");\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	// 또 다른 ready 이벤트 처리(ready 이벤트는 복수개 등록 가능하며, 차례대로 실행됨)\r\n");
      out.write("	$(function() {\r\n");
      out.write("		// ======================================================================\r\n");
      out.write("		// 2. 인접관계 선택자\r\n");
      out.write("		//    1) 자식 선택자(>) - 특정 선택자의 바로 하위 요소(자식) 선택\r\n");
      out.write("		//       => $(\"부모선택자 > 자식선택자\")\r\n");
      out.write("		//    2) 자식 또는 후손 선택자(공백) - 특정 선택자의 하위에 일치하는 모든 요소 선택\r\n");
      out.write("		//       => $(\"부모선택자 자식선택자\")\r\n");
      out.write("		//    3) 순서 선택자 - 특정 선택자를 기준으로 지정된 순서에 해당하는 요소 선택\r\n");
      out.write("		//       => $(\"선택자명:옵션명\")\r\n");
      out.write("		//       ex) 첫번째 요소 : \"선택자:first\", 마지막 요소 : \"선택자:last\"\r\n");
      out.write("		//           홀수번째 요소 : \"선택자:odd\", 짝수번째 요소 : \"선택자:even\"\r\n");
      out.write("		// table 태그 내의 tr 태그들의 배경색을 \"green\" 으로 변경\r\n");
      out.write("// 		$(\"table tr\").css(\"background\", \"green\"); // 자식 또는 후손선택자\r\n");
      out.write("		\r\n");
      out.write("		// tr 태그들 중 첫번째 tr 태그의 배경색만 \"green\" 으로 변경\r\n");
      out.write("// 		$(\"table tr:first\").css(\"background\", \"green\");\r\n");
      out.write("		$(\"tr:first\").css(\"background\", \"skyblue\"); // table 태그 생략 가능\r\n");
      out.write("		\r\n");
      out.write("		// tr 태그들 중 홀수번째(1, 3) tr 태그의 배경색만 \"pink\" 로 변경\r\n");
      out.write("		$(\"tr:odd\").css(\"background\", \"pink\");\r\n");
      out.write("		\r\n");
      out.write("		// tr 태그들 중 짝수번째(0, 2, 4) tr 태그의 배경색만 \"yellow\" 로 변경\r\n");
      out.write("		$(\"tr:even\").css(\"background\", \"yellow\");\r\n");
      out.write("		\r\n");
      out.write("		// ----------------\r\n");
      out.write("		// 대상 요소의 값(value 속성값) 가져오기\r\n");
      out.write("		// => 대상 요소 지정하여 val() 함수 호출\r\n");
      out.write("		// id 선택자 \"inputBox\" 의 자식 중 input 태그 type 속성이 \"text\" 인 요소 값 가져오기\r\n");
      out.write("		let id = $(\"#inputBox > input[type=text]\").val();\r\n");
      out.write("		// id 선택자 \"inputBox\" 의 자식 중 input 태그 type 속성이 \"password\" 인 요소 값 가져오기\r\n");
      out.write("		let passwd = $(\"#inputBox > input[type=password]\").val();\r\n");
      out.write("// 		alert(\"아이디 : \" + id + \", 패스워드 : \" + passwd); // 아이디 : admin, 패스워드 : 1234\r\n");
      out.write("	\r\n");
      out.write("		// id 선택자 \"inputBox\" 의 자식 중 \r\n");
      out.write("		// textarea 태그 속성이 readonly 인 요소의 배경색 lightgray 로 변경\r\n");
      out.write("		$(\"#inputBox textarea[readonly]\").css(\"background\", \"lightgray\");\r\n");
      out.write("		// --------------------------------------------------------\r\n");
      out.write("		// id 선택자 \"divBox\" 요소의 후손(공백)들인 div 태그 글자색 blue 로 변경\r\n");
      out.write("// 		$(\"#divBox div\").css(\"color\", \"blue\"); // 1, 1-1, 1-2, 2, 3, 3-1, 3-2 변경됨 \r\n");
      out.write("		\r\n");
      out.write("		// id 선택자 \"divBox\" 요소의 자식(>)들인 div 태그 배경색 pink 로 변경\r\n");
      out.write("		$(\"#divBox > div\").css(\"color\", \"blue\"); // 1, 2, 3 변경됨\r\n");
      out.write("		// --------------------------------------------------------\r\n");
      out.write("		// id 선택자 \"selectBox\" 요소에서 선택된 값(option 태그의 selected 속성이 있는 값)을\r\n");
      out.write("		// 가져와서 id 선택자 \"selectResult\" 인 요소에 표시(출력)하기\r\n");
      out.write("		// => 가상 선택자 활용 가능(option:selected)\r\n");
      out.write("		let selectedItem = $(\"option:selected\").val(); // 선택값 가져오기\r\n");
      out.write("		// val() 함수를 호출하여 파라미터로 값 지정 시 해당 태그의 value 속성값 변경\r\n");
      out.write("		$(\"#selectResult\").val(selectedItem);\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>jQuery - test3.jsp</h1>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<h3 id=\"idSelector\">id 선택자</h3>\r\n");
      out.write("	<h3 class=\"classSelector\">class 선택자</h3>\r\n");
      out.write("	<h3 class=\"classSelector\">class 선택자2</h3>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr><td>번호</td><td>제목</td></tr>\r\n");
      out.write("		<tr><td>1</td><td>1번제목</td></tr>\r\n");
      out.write("		<tr><td>2</td><td>2번제목</td></tr>\r\n");
      out.write("		<tr><td>3</td><td>3번제목</td></tr>\r\n");
      out.write("		<tr><td>4</td><td>4번제목</td></tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<div id=\"inputBox\">\r\n");
      out.write("		<input type=\"text\" value=\"admin\" id=\"id\">\r\n");
      out.write("		<input type=\"password\" value=\"1234\" id=\"passwd\"><br>\r\n");
      out.write("		<textarea rows=\"5\" cols=\"20\" readonly=\"readonly\"></textarea>\r\n");
      out.write("		<textarea rows=\"5\" cols=\"20\" id=\"inputData\"></textarea>\r\n");
      out.write("	</div>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<div id=\"divBox\">\r\n");
      out.write("		<div>\r\n");
      out.write("			1번 div 태그\r\n");
      out.write("			<div>1-1번 div 태그</div>\r\n");
      out.write("			<div>1-2번 div 태그</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<span>span 태그</span>\r\n");
      out.write("		<div>2번 div 태그</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			3번 div 태그\r\n");
      out.write("			<div>3-1번 div 태그</div>\r\n");
      out.write("			<div>3-2번 div 태그</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<select id=\"selectBox\">\r\n");
      out.write("		<option value=\"JAVA\">JAVA</option>\r\n");
      out.write("		<option value=\"JSP\">JSP</option>\r\n");
      out.write("		<option value=\"Spring Framework\">Spring Framework</option>\r\n");
      out.write("	</select>\r\n");
      out.write("	<input type=\"text\" id=\"selectResult\">\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
