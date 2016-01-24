package com.kupybaton.web.servlets;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;
=======
import com.kupybaton.model.Product;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import com.kupybaton.model.Product;
import com.kupybaton.model.Unit;
import com.kupybaton.model.Category;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.PurchaseExpert;
import com.kupybaton.web.jdbc.GetCreatedListById;;;

public class AddOneMoreProduct extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String product_id = request.getParameter("product");
		String list_id = request.getParameter("oneproductlist");
		String [] chosenProducts = request.getParameterValues("product");
		response.setContentType("text/html");
		GetCreatedListById gc = new GetCreatedListById();
		List<ProductList> productlist = gc.getList(list_id);
		AllProductSelectExpert apse = new AllProductSelectExpert();
		List <Product> products = apse.getAllProducts();
		request.setAttribute("chosenProducts", chosenProducts);
		request.setAttribute("products", products);
		request.setAttribute("productlist", productlist);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
		view.forward(request, response);

	}
=======
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
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
}
