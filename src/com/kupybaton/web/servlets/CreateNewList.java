package com.kupybaton.web.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateNewList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewList.jsp");
		view.forward(request, response);
	}

}
