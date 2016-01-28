package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetListById;
import com.kupybaton.web.jdbc.GetPurchaseByListId;

public class GetPurchaseProductsByListId extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


			String listId = request.getParameter("listId");

			response.setContentType("text/html");

			GetPurchaseByListId gpbli = GetPurchaseByListId.getGetPurchaseByListId();
			List<Purchase> chosenProducts = gpbli.getPurchase(listId);
			
			GetListById gebi = GetListById.getGetListById();
			List<ProductList> productlist = gebi.getList(listId);

			AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
			List<Product> products = apse.getAllProducts();

			List<String> chosenBeforeQuantity = new ArrayList<String>();
			Iterator<Purchase> it = chosenProducts.iterator();
			while (it.hasNext()) {
				chosenBeforeQuantity.add(it.next().getQuantity().toString());
			}

			request.setAttribute("productlist", productlist);
			request.setAttribute("chosenBeforeQuantity", chosenBeforeQuantity);
			request.setAttribute("chosenProducts", chosenProducts);
			request.setAttribute("products", products);


			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
			view.forward(request, response);
		
	}
}
