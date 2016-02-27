package com.kupybaton.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.web.jdbc.delete.ListDeleter;

public class DeleteList extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productlistIdString = request.getParameter("productlistId");
		
		Integer productlistId = Integer.valueOf(productlistIdString);

				if (ListDeleter.getListDeleter().deleteList(productlistId)) {
					response.sendRedirect(request.getContextPath() + "/lists.html");

		} else {
			response.sendRedirect(request.getContextPath() + "/purchases.html?createNewCategoryError=true&productlistId=" + productlistIdString);
		}
	}
}
