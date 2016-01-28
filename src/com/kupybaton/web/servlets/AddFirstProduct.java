package com.kupybaton.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kupybaton.model.Product;

import com.kupybaton.model.ProductList;
import com.kupybaton.model.Purchase;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetFirstProduct;
import com.kupybaton.web.jdbc.GetListById;
import com.kupybaton.web.jdbc.GetPurchaseByListId;
import com.kupybaton.web.jdbc.InsertValuestIntoPurchase;

public class AddFirstProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Integer productId = Integer.valueOf(request.getParameter("productId"));
        String listId = request.getParameter("oneProductList");
        String quantity = request.getParameter("quantity");
        
        response.setContentType("text/html");
        
        InsertValuestIntoPurchase ivip = InsertValuestIntoPurchase.getInsertValuestIntoPurchase();
        ivip.insertIntoPurchase(listId, productId, quantity);
        
        GetListById gc = GetListById.getGetListById();
        List<ProductList> productlist = gc.getList(listId);
        
        AllProductSelectExpert apse = AllProductSelectExpert.getAllProductSelectExpert();
        List<Product> products = apse.getAllProducts();
        
        GetPurchaseByListId gpbli = GetPurchaseByListId.getGetPurchaseByListId();
        List <Purchase> chosenProducts = gpbli.getPurchase(listId);
        
        request.setAttribute("products", products);
        request.setAttribute("productlist", productlist);
        request.setAttribute("chosenProducts", chosenProducts);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
        view.forward(request, response);

    }

}
