package com.kupybaton.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.create.CategoryInserter;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;

public class CreateNewCategory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String productlistIdString = request.getParameter("productlistId");

		Integer productlistId;
		try {
			productlistId = Integer.valueOf(productlistIdString);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/CreateNewProduct.do?listEditError=true");
			return;
		}

		response.setContentType("text/html");

		String createNewCategoryErrorString = request.getParameter("createNewCategoryError");
		boolean createNewCategoryError = Boolean.valueOf(createNewCategoryErrorString);
		if (createNewCategoryError) {
			String warningMessage = "Category creation failed. Please try one more time";
			request.setAttribute("warningMessage", warningMessage);
		}

		ProductList productList = ListsRetriever.getListsRetriever().getProductListById(productlistId);
		request.setAttribute("productList", productList);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewCategory.jsp");
		view.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String productlistIdString = request.getParameter("productlistId");
		String categoryName = request.getParameter("categoryName");

		Integer productlistId;

		if (productlistIdString != null & categoryName.length() > 0) {

			try {
				productlistId = Integer.valueOf(productlistIdString);

				if (CategoryInserter.getCategoryInserter().insertNewCategory(categoryName)) {
					response.sendRedirect(request.getContextPath() + "/CreateNewProduct.do?productlistId=" + productlistId);

				}

			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				response.sendRedirect(request.getContextPath()
						+ "/CreateNewCategory.do?createNewCategoryError=true&productlistId=" + productlistIdString);
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/CreateNewCategory.do?createNewCategoryError=true&productlistId=" + productlistIdString);
		}
	}

}