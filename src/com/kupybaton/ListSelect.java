package com.kupybaton;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ListSelect extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String listname = request.getParameter("listname");
		String[] c = request.getParameterValues("product");
		response.setContentType("text/html");
		ListsExpert le = new ListsExpert();
		List <Product> l = le.getProducts(listname, c);
		request.setAttribute("styles", l);
		request.setAttribute("name", listname);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		view.forward(request, response);
	}
}
