package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetLastCreatedList;
import com.kupybaton.web.jdbc.PurchaseExpert;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;
import com.kupybaton.web.jdbc.retrieve.PurchasesRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PurchasePage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String listname = request.getParameter("listname");

		if (listname.isEmpty()) {
			response.setContentType("text/html");
			String warningMessage = "You have to type the name of list!!!";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewList.jsp");
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
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewList.jsp");
			view.forward(request, response);
		}
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listIdString = request.getParameter("listId");

        Integer listId;
        try {
            listId = Integer.valueOf(listIdString);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/lists.html?listEditError=true");
            return;
        }
        response.setContentType("text/html");

        ProductList productList = ListsRetriever.getListsRetriever().getProductListById(listId);
        request.setAttribute("productList", productList);

        List<Purchase> purchaseList = PurchasesRetriever.getListsRetriever().getPurchasesByListId(listId);
        request.setAttribute("purchaseList", purchaseList);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/purchases.jsp");
        view.forward(request, response);
    }
}
