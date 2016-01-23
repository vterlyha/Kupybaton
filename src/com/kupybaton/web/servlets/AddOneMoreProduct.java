package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.web.jdbc.AllProductSelectExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddOneMoreProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String productId = request.getParameter("product");
        String listId = request.getParameter("oneproductlist");
        String[] chosenProducts = request.getParameterValues("product");

        response.setContentType("text/html");
//        GetCreatedListById gc = new GetCreatedListById();
//        List<ProductList> productlist = gc.getList(listId);
        AllProductSelectExpert apse = new AllProductSelectExpert();
        List<Product> products = apse.getAllProducts();
        request.setAttribute("chosenProducts", chosenProducts);
        request.setAttribute("products", products);
//        request.setAttribute("productlist", productlist);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
        view.forward(request, response);

    }
}
