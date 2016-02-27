package com.kupybaton.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.filter.DataValidator;
import com.kupybaton.web.jdbc.create.UnitInserter;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;



public class CreateNewUnit extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productlistIdString = request.getParameter("productlistId");
        Integer productlistId = Integer.valueOf(productlistIdString);
		
		response.setContentType("text/html");
		
		String createNewUnitErrorString = request.getParameter("createNewUnitError");
        boolean createNewUnitError = Boolean.valueOf(createNewUnitErrorString);
        if (createNewUnitError) {
            String warningMessage = "Unit creation failed. Please try one more time";
            request.setAttribute("warningMessage", warningMessage);
        }
		
        ProductList productList = ListsRetriever.getListsRetriever().getProductListById(productlistId);
        request.setAttribute("productList", productList);
        
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewUnit.jsp");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String productlistIdString = request.getParameter("productlistId");
		String unitName = request.getParameter("unitName");
				
		Integer productlistId;
		
		if (DataValidator.validateName(unitName)) {

				productlistId = Integer.valueOf(productlistIdString);
				
				if (UnitInserter.getUnitInserter().insertNewUnit(unitName)) {
					response.sendRedirect(request.getContextPath() + "/CreateNewProduct.html?productlistId=" + productlistId);

				}
				
		} else {
			response.sendRedirect(request.getContextPath() + "/CreateNewUnit.html?createNewUnitError=true&productlistId=" + productlistIdString);
		}
	}

}
