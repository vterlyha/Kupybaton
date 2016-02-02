package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Category;
import com.kupybaton.model.Unit;
import com.kupybaton.web.jdbc.AllCategorySelectExpert;
import com.kupybaton.web.jdbc.AllUnitSelectExpert;
import com.kupybaton.web.jdbc.InsertValuesIntoUnitExpert;

public class InsertValuesIntoUnit extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			String unitName = request.getParameter("unitName");
			response.setContentType("text/html");
			InsertValuesIntoUnitExpert iviue = InsertValuesIntoUnitExpert.getInsertValuesIntoUnitExpert();
			iviue.insertIntoUnit(unitName);

			AllUnitSelectExpert ause = AllUnitSelectExpert.getAllUnitSelectExpert();
			List<Unit> units = ause.getAllUnits();

			AllCategorySelectExpert acse = AllCategorySelectExpert.getAllCategorySelectExpert();
			List<Category> categories = acse.getAllCategories();

			request.setAttribute("units", units);
			request.setAttribute("categories", categories);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewProduct.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			String warningMessage = "Unit creation failed. Please try one more time";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewProduct.jsp");
			view.forward(request, response);
		}
	}

}