package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Unit;
import com.kupybaton.model.Category;

import com.kupybaton.web.jdbc.AllCategorySelectExpert;
import com.kupybaton.web.jdbc.AllUnitSelectExpert;


public class CreateNewProduct extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		response.setContentType("text/html");
		
		AllUnitSelectExpert ause = new AllUnitSelectExpert();
		List<Unit> units = ause.getAllUnits();
		
		AllCategorySelectExpert acse = new AllCategorySelectExpert();
		List<Category> categories = acse.getAllCategories();

		request.setAttribute("units", units);
		request.setAttribute("categories", categories);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewProduct.jsp");
		view.forward(request, response);
	}

}
