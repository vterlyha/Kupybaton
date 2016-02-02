package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetListById;
import com.kupybaton.web.jdbc.GetPurchaseByListId;
import com.kupybaton.web.jdbc.InsertValuestIntoPurchase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AddOneMoreProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			Integer productId = Integer.valueOf(request.getParameter("productId"));
			String listId = request.getParameter("oneproductlist");
			String quantity = request.getParameter("quantity");

			String[] alreadychosenProducts = request.getParameterValues("chosenProduct");
			List<Integer> chosenBeforeProducts = new ArrayList<Integer>();
			if (alreadychosenProducts[0] != "") {
				for (String product_id : alreadychosenProducts) {
					Integer id = Integer.valueOf(product_id);
					chosenBeforeProducts.add(id);
				}
			}
			chosenBeforeProducts.add(productId);

			String[] alreadychosenQuantity = request.getParameterValues("chosenQuantity");
			List<String> chosenBeforeQuantity = new ArrayList<String>();
			if (alreadychosenProducts[0] != "") {
				chosenBeforeQuantity = new ArrayList<String>(Arrays.asList(alreadychosenQuantity));
			}
			chosenBeforeQuantity.add(quantity);

			response.setContentType("text/html");

			InsertValuestIntoPurchase ivip = InsertValuestIntoPurchase.getInsertValuestIntoPurchase();
			ivip.insertIntoPurchase(listId, productId, quantity);

			GetListById gc = GetListById.getGetListById();
			List<ProductList> productlist = gc.getList(listId);

			AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
			List<Product> products = apse.getAllProducts();

			GetPurchaseByListId gpbli = GetPurchaseByListId.getGetPurchaseByListId();
			List<Purchase> chosenProducts = gpbli.getPurchase(listId);

			request.setAttribute("chosenBeforeQuantity", chosenBeforeQuantity);
			request.setAttribute("chosenProducts", chosenProducts);
			request.setAttribute("products", products);
			request.setAttribute("productlist", productlist);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			String warningMessage = "Purchase creation failed. Please try one more time";
			String listId = request.getParameter("oneproductlist");

			GetListById gc = GetListById.getGetListById();
			List<ProductList> productlist = gc.getList(listId);

			AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
			List<Product> products = apse.getAllProducts();

			request.setAttribute("productlist", productlist);
			request.setAttribute("warningMessage", warningMessage);
			request.setAttribute("products", products);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewList.jsp");
			view.forward(request, response);
		}

    }

}
