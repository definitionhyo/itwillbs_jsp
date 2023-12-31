/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-03-31 02:33:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp04_005fsession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class sessionTest1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Date");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- \r\n");
      out.write("	session 객체\r\n");
      out.write("	- HttpSession 타입을 사용하여 관리(서버가 관리하는 객체)\r\n");
      out.write("	- 서버와 클라이언트 사이의 연결 정보에 대한 관리 역할을 수행하는 객체\r\n");
      out.write("	  (= 가상의 연결(Virtual Connection) 개념을 사용)\r\n");
      out.write("	- 웹 페이지와 관계없이 어떠한 정보를 유지하는 용도로 사용\r\n");
      out.write("	  ex) 로그인 후 아이디 정보를 기억하여 페이지 이동시에도 로그인 상태가 계속 유지되도록 함\r\n");
      out.write("	  (=> request 객체는 요청페이지에서 응답페이지까지만 정보가 유지됨)\r\n");
      out.write("	- 서버에 접속(연결) 시 기본적으로 해당 클라이언트에 해당하는 기억 장소(= 세션)가 생성되고\r\n");
      out.write("	  자동으로 아이디(세션ID) 값이 부여됨\r\n");
      out.write("	  => 주의! 로그인 할 때 사용하는 아이디가 아님(세션ID 는 사용자가 결정하지 못함)\r\n");
      out.write("	- 세션 유지 또는 제거 조건\r\n");
      out.write("	  1) 세션 유지 시간(타이머 = maxInactiveInterval) 값만큼 세션 정보가 유지됨\r\n");
      out.write("	     따라서, 유지 시간 동안 아무런 동작이 없을 경우 유지 시간이 만료될 때 세션 정보 자동 제거\r\n");
      out.write("	     => 참고) 기본 세션 유지 시간(maxInactiveInterval) 값은 1800(초) = 30분\r\n");
      out.write("	     => 참고) 서버와 통신을 수행하면 세션 유지 시간이 다시 초기화됨(처음부터 다시 카운팅)\r\n");
      out.write("	  2) 세션 유지 시간과 관계없이 invalidate() 메서드 호출 시 세션 초기화\r\n");
      out.write("	  3) 웹브라우저가 종료되면 세션 초기화\r\n");
      out.write("	-->\r\n");
      out.write("	<h1>sessionTest1.jsp</h1>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 세션 유지시간(maxInactiveInterval) 값 확인 -->\r\n");
      out.write("	<h3>현재 세션 유지시간 : ");
      out.print(session.getMaxInactiveInterval() );
      out.write(" 초</h3>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 세션 유지시간(타이머)를 10초로 변경 -->\r\n");
      out.write("	");
session.setMaxInactiveInterval(10); 
      out.write("\r\n");
      out.write("	<!-- 변경된 세션 유지시간(maxInactiveInterval) 값 확인 -->\r\n");
      out.write("	<h3>변경 후 세션 유지시간 : ");
      out.print(session.getMaxInactiveInterval() );
      out.write(" 초</h3>\r\n");
      out.write("	\r\n");
      out.write("	<h3>\r\n");
      out.write("		새 세션 여부 : ");
      out.print(session.isNew() );
      out.write("<br>\r\n");
      out.write("		세션 아이디 : ");
      out.print(session.getId() );
      out.write("<br>\r\n");
      out.write("		<!-- 날짜 및 시각 관련 정보가 long 타입일 경우 java.util.Date 객체 활용 -->\r\n");
      out.write("		세션 생성 시각 : ");
      out.print(new Date(session.getCreationTime()) );
      out.write("<br>\r\n");
      out.write("		세션 마지막 접근 시각 : ");
      out.print(new Date(session.getLastAccessedTime()) );
      out.write(" \r\n");
      out.write("	</h3>\r\n");
      out.write("	\r\n");
      out.write("	<hr>\r\n");
      out.write("	<!-- 세션 강제 초기화(= 해당 클라이언트에 대한 세션 객체 제거) -->\r\n");
      out.write("	");
session.invalidate(); 
      out.write("\r\n");
      out.write("	<h3>새 세션 여부 : ");
      out.print(session.isNew() );
      out.write("</h3>\r\n");
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
