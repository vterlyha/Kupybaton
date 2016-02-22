package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.create.ProductInserter;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;
import com.kupybaton.web.jdbc.retrieve.ProductRetriever;
import com.kupybaton.web.jdbc.retrieve.PurchasesRetriever;
import com.kupybaton.web.jdbc.update.ListUpdater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class PurchasePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productlistIdString = request.getParameter("productlistId");

        Integer productlistId;
        try {
        	productlistId = Integer.valueOf(productlistIdString);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/lists.html?listEditError=true");
            return;
        }
        response.setContentType("text/html");
        
        String changeListName = request.getParameter("changeListName");
        boolean changeListNameBoolean = Boolean.valueOf(changeListName);
        if (changeListNameBoolean) {
            request.setAttribute("changeListNameBoolean", changeListNameBoolean);
        }
        
        String purchaseEditErrorString = request.getParameter("purchaseEditError");
        boolean purchaseEditError = Boolean.valueOf(purchaseEditErrorString);
        if (purchaseEditError) {
            String warningMessage = "Purchase edit failed. Please try one more time";
            request.setAttribute("warningMessage", warningMessage);
        }
        
        String createNewProductErrorString = request.getParameter("createNewProductError");
        boolean createNewProductError = Boolean.valueOf(createNewProductErrorString);
        if (createNewProductError) {
            String warningMessage = "Product creation failed. Please try one more time";
            request.setAttribute("warningMessage", warningMessage);
        }
        
        ProductList productList = ListsRetriever.getListsRetriever().getProductListById(productlistId);
        request.setAttribute("productList", productList);
        
        List <Product> allProducts = ProductRetriever.getProductRetriever().getAllProducts();
        request.setAttribute("allProducts", allProducts);

        List<Purchase> purchaseList = PurchasesRetriever.getPurchasesRetriever().getPurchasesByListId(productlistId);
        request.setAttribute("purchaseList", purchaseList);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/purchases.jsp");
        view.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String productlistIdString = request.getParameter("productlistId");
		String listName = request.getParameter("listName");
		String productlistDateCreatedString = request.getParameter("productlistDateCreated");
				
		Integer productlistId;
		Date productlistDateCreated;
		
		if (productlistIdString != null & productlistDateCreatedString != null & listName.length()>0) {
			
			try {
				productlistId = Integer.valueOf(productlistIdString);
				productlistDateCreated = Date.valueOf(productlistDateCreatedString);
								
				if (ListUpdater.getListUpdater().updateList(listName, productlistId, productlistDateCreated)) {
					response.sendRedirect(request.getContextPath() + "/purchases.html?productlistId=" + productlistId);

				}
				
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/purchases.html?purchaseEditError=true&productlistId=" + productlistIdString);
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/purchases.html?purchaseEditError=true&productlistId=" + productlistIdString);
		}
	}
}
