package com.kupybaton.web.servlets;

import com.kupybaton.web.jdbc.create.ListInserter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class CreateNewList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewList.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String listName = request.getParameter("listName");

        boolean isListAddedSuccessfully = false;

        if (listName != null && listName.length() > 0) {
            isListAddedSuccessfully = ListInserter.getListInserter().insertNewList(listName);
        }

        if (!isListAddedSuccessfully) {
            String warningMessage = "Server-side error has occured";
            request.setAttribute("warningMessage", warningMessage);
            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/createNewList.jsp");
            view.forward(request, response);
        }

        response.sendRedirect(request.getContextPath() + "/lists.html");
	}

}
