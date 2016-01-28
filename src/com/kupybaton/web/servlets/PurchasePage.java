package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetLastCreatedList;
import com.kupybaton.web.jdbc.PurchaseExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			if (listname.length() > 0) {
				response.setContentType("text/html");
				PurchaseExpert pe = PurchaseExpert.getPurchaseExpert();
				GetLastCreatedList gl = GetLastCreatedList.getGetLastCreatedList();
				pe.insertList(listname);
				List<ProductList> productlist = gl.getList();
				AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
				List<Product> products = apse.getAllProducts();
				request.setAttribute("products", products);
				request.setAttribute("productlist", productlist);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			String warningMessage = "List creation failed. Please try one more time";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewList.jsp");
			view.forward(request, response);
		}
	}

}
