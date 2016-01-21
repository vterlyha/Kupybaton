package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.PurchaseExpert;

public class PurchasePage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String listname = request.getParameter("listname");
						
		if (listname.isEmpty()) {
			response.setContentType("text/html");
			String warningMessage = "You have to type the name of list!!!";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewList.jsp");
			view.forward(request, response);
		}
		
		if (listname.length() > 0) {
			response.setContentType("text/html");
			PurchaseExpert pe = new PurchaseExpert();
			pe.insertList(listname);
			List<ProductList> productlist = pe.getList(listname);
			AllProductSelectExpert apse = new AllProductSelectExpert();
			List <Product> products = apse.getAllProducts();
			request.setAttribute("products", products);
			request.setAttribute("productlist", productlist);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
			view.forward(request, response);
		}
	}
}
