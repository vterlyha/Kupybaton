package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Product;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetFirstProduct;
import com.kupybaton.web.jdbc.GetListById;;;

public class AddFirstProduct extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String product_id = request.getParameter("product");
		String list_id = request.getParameter("oneProductList");
		response.setContentType("text/html");
		GetListById gc = new GetListById();
		List<ProductList> productlist = gc.getList(list_id);
		AllProductSelectExpert apse = new AllProductSelectExpert();
		List <Product> products = apse.getAllProducts();
		GetFirstProduct gfp = new GetFirstProduct();
		//List <Product> chosenProducts = gfp.getProduct(product_id);
		request.setAttribute("products", products);
		request.setAttribute("productlist", productlist);
		//request.setAttribute("chosenProducts", chosenProducts);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
		view.forward(request, response);

	}
}
