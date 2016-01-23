package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetFirstProduct;
import com.kupybaton.web.jdbc.GetListById;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddFirstProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String productId = request.getParameter("product");
        String listId = request.getParameter("oneProductList");
        response.setContentType("text/html");
        GetListById gc = new GetListById();
        List<ProductList> productlist = gc.getList(listId);
        AllProductSelectExpert apse = new AllProductSelectExpert();
        List<Product> products = apse.getAllProducts();
        GetFirstProduct gfp = new GetFirstProduct();
        //List <Product> chosenProducts = gfp.getProduct(productId);
        request.setAttribute("products", products);
        request.setAttribute("productlist", productlist);
        //request.setAttribute("chosenProducts", chosenProducts);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
        view.forward(request, response);

    }
}
