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
import com.kupybaton.web.jdbc.GetLastCreatedList;
import com.kupybaton.web.jdbc.GetPurchaseByListId;
import com.kupybaton.web.jdbc.InsertValuesIntoProductExpert;

public class InsertValuesIntoProduct extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			String productName = request.getParameter("productName");
			Integer unitId = Integer.valueOf(request.getParameter("unitId"));
			Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));

			response.setContentType("text/html");
			InsertValuesIntoProductExpert ivipe = InsertValuesIntoProductExpert.getInsertValuesIntoProductExpert();
			ivipe.insertIntoProduct(productName, unitId, categoryId);

			GetLastCreatedList glcl = GetLastCreatedList.getGetLastCreatedList();
			List<ProductList> productlist = glcl.getList();

			GetPurchaseByListId gpbli = GetPurchaseByListId.getGetPurchaseByListId();
			List<Purchase> chosenProducts = gpbli.getPurchase(productlist.get(0).getId().toString());

			AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
			List<Product> products = apse.getAllProducts();

			List<String> chosenBeforeQuantity = new ArrayList<String>();
			Iterator<Purchase> it = chosenProducts.iterator();
			while (it.hasNext()) {
				chosenBeforeQuantity.add(it.next().getQuantity().toString());
			}

			request.setAttribute("chosenBeforeQuantity", chosenBeforeQuantity);
			request.setAttribute("chosenProducts", chosenProducts);
			request.setAttribute("products", products);
			request.setAttribute("productlist", productlist);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			String warningMessage = "Product creation failed. Please try one more time";
			response.setContentType("text/html");
			
			GetLastCreatedList glcl = GetLastCreatedList.getGetLastCreatedList();
			List<ProductList> productlist = glcl.getList();

			GetPurchaseByListId gpbli = GetPurchaseByListId.getGetPurchaseByListId();
			List<Purchase> chosenProducts = gpbli.getPurchase(productlist.get(0).getId().toString());

			AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
			List<Product> products = apse.getAllProducts();

			List<String> chosenBeforeQuantity = new ArrayList<String>();
			Iterator<Purchase> it = chosenProducts.iterator();
			while (it.hasNext()) {
				chosenBeforeQuantity.add(it.next().getQuantity().toString());
			}

			request.setAttribute("warningMessage", warningMessage);
			request.setAttribute("chosenBeforeQuantity", chosenBeforeQuantity);
			request.setAttribute("chosenProducts", chosenProducts);
			request.setAttribute("products", products);
			request.setAttribute("productlist", productlist);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
			view.forward(request, response);

		}
	}
}