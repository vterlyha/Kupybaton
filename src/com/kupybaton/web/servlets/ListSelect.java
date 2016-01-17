package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.web.jdbc.ListsExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
