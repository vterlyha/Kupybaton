package com.kupybaton.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.web.jdbc.create.PurchaseInserter;


public class CreateNewPurchase extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String referer = request.getHeader("referer");
		String productlistIdString = request.getParameter("productlistId");
		String productIdString = request.getParameter("productId");
		String quantityString = request.getParameter("quantity");
		
		Integer productlistId;
		Integer productId;
		Double quantity;
		
		if (productlistIdString != null & productIdString != null & quantityString.length()>0) {
			
			try {
				productlistId = Integer.valueOf(productlistIdString);
				productId = Integer.valueOf(productIdString);
				quantity = Double.valueOf(quantityString);
				
				if (PurchaseInserter.getPurchaseInserter().insertNewPurchase(productlistId, productId, quantity)) {
					response.sendRedirect(referer);

				}
				
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				response.sendRedirect(referer + "&purchaseEditError=true");
				return;
			}
		} else {
			response.sendRedirect(referer + "&purchaseEditError=true");
		}
	  
	}
}
