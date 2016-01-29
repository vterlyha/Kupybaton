package com.kupybaton.web.servlets;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.retrieve.ListsRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListSelect extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ListsRetriever listsRetriever = ListsRetriever.getListsRetriever();

        String showAllListsString = request.getParameter("showAllLists");
        boolean showAllLists = Boolean.valueOf(showAllListsString);

        if (showAllLists) {
            List<ProductList> inactiveLists = listsRetriever.getOnlyInactiveLists();
            request.setAttribute("inactiveLists", inactiveLists);
        }

        List<ProductList> activeLists = listsRetriever.getOnlyActiveLists();
        request.setAttribute("activeLists", activeLists);

        String listEditErrorString = request.getParameter("listEditError");
        boolean listEditError = Boolean.valueOf(listEditErrorString);
        if (listEditError) {
            String warningMessage = "List edit failed. Please select existing list to edit";
            request.setAttribute("warningMessage", warningMessage);
        }

        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/listSelect.jsp");
		view.forward(request, response);
	}
}
