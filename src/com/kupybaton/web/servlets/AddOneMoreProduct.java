package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Product;
import com.kupybaton.web.jdbc.AllProductSelectExpert;

public class AddOneMoreProduct {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String listname = request.getParameter("listname");
		response.setContentType("text/html");
		AllProductSelectExpert apse = new AllProductSelectExpert();
		List<Product> products = apse.getAllProducts();
		request.setAttribute("products", products);
		request.setAttribute("listname", listname);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
		view.forward(request, response);

	}
}
