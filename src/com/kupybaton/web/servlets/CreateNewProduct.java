package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Category;
import com.kupybaton.model.ProductList;
import com.kupybaton.model.Unit;
import com.kupybaton.web.jdbc.create.ProductInserter;
import com.kupybaton.web.jdbc.retrieve.CategoryRetriever;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;
import com.kupybaton.web.jdbc.retrieve.UnitRetriever;

public class CreateNewProduct extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productlistIdString = request.getParameter("productlistId");

        Integer productlistId;
        try {
        	productlistId = Integer.valueOf(productlistIdString);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/purchases.html?createNewProductError=true");
            return;
        }
		response.setContentType("text/html");
		
		String createNewProductErrorString = request.getParameter("createNewProductError");
        boolean createNewProductError = Boolean.valueOf(createNewProductErrorString);
        if (createNewProductError) {
            String warningMessage = "Product creation failed. Please try one more time";
            request.setAttribute("warningMessage", warningMessage);
        }
		
		ProductList productList = ListsRetriever.getListsRetriever().getProductListById(productlistId);
        request.setAttribute("productList", productList);
		
		List <Category> allCategories = CategoryRetriever.getCategoryRetriever().getAllCategories();
		request.setAttribute("allCategories", allCategories);
		
		List <Unit> allUnits = UnitRetriever.getUnitRetriever().getAllUnits();
		request.setAttribute("allUnits", allUnits);
				
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewProduct.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String productlistIdString = request.getParameter("productlistId");
		String productName = request.getParameter("productName");
		String unitIdString = request.getParameter("unitId");
		String categoryIdString = request.getParameter("categoryId");
		
		Integer productlistId;
		Integer unitId;
		Integer categoryId;
		
		if (productlistIdString != null & unitIdString != null & categoryIdString != null & productName.length()>0) {
			
			try {
				productlistId = Integer.valueOf(productlistIdString);
				unitId = Integer.valueOf(unitIdString);
				categoryId = Integer.valueOf(categoryIdString);
				
				if (ProductInserter.getProductInserter().insertNewProduct(productName, categoryId, unitId)) {
					response.sendRedirect(request.getContextPath() + "/purchases.html?productlistId=" + productlistId);

				}
				
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/CreateNewProduct.do?createNewProductError=true&productlistId=" + productlistIdString);
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/CreateNewProduct.do?createNewProductError=true&productlistId=" + productlistIdString);
		}
	}

}
