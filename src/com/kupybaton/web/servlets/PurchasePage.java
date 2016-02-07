package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.GetLastCreatedList;
import com.kupybaton.web.jdbc.create.ListInserter;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;
import com.kupybaton.web.jdbc.retrieve.ProductRetriever;
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
				response.setContentType("text/html");
				ListInserter listInserter = ListInserter.getListInserter();
				listInserter.insertNewList(listname);
				ListsRetriever listRetriever = ListsRetriever.getListsRetriever();
				List <ProductList> productlist = listRetriever.getProductListById(listId);
				List<Product> products = apse.getAllProducts();
				request.setAttribute("products", products);
				request.setAttribute("productlist", productlist);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
				view.forward(request, response);
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
        
        List <Product> allProducts = ProductRetriever.getProductRetriever().getAllProducts();
        request.setAttribute("allProducts", allProducts);

        List<Purchase> purchaseList = PurchasesRetriever.getPurchasesRetriever().getPurchasesByListId(listId);
        request.setAttribute("purchaseList", purchaseList);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/purchases.jsp");
        view.forward(request, response);
    }
}
