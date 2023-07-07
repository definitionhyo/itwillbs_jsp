package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMyServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식 요청이 발생할 경우 자동으로 호출되는 메서드
		System.out.println("TestMyServlet2 - doGet() 메서드 호출됨!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 요청이 발생할 경우 자동으로 호출되는 메서드
		System.out.println("TestMyServlet2 - doPost() 메서드 호출됨!");
	}
	
}
