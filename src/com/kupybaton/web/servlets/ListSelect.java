package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.ListsExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListSelect extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		ListsExpert le = ListsExpert.getListsExpert();
		List <ProductList> productlist = le.getLists();
		request.setAttribute("productlist", productlist);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/ListSelect.jsp");
		view.forward(request, response);
	}
}
