package com.kupybaton.web.servlets;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;
=======
import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetFirstProduct;
import com.kupybaton.web.jdbc.GetListById;
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import com.kupybaton.model.Product;

import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetFirstProduct;
import com.kupybaton.web.jdbc.GetListById;;;

public class AddFirstProduct extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String product_id = request.getParameter("product");
		String list_id = request.getParameter("oneProductList");
		response.setContentType("text/html");
		GetListById gc = new GetListById();
		List<ProductList> productlist = gc.getList(list_id);
		AllProductSelectExpert apse = new AllProductSelectExpert();
		List <Product> products = apse.getAllProducts();
		GetFirstProduct gfp = new GetFirstProduct();
		//List <Product> chosenProducts = gfp.getProduct(product_id);
		request.setAttribute("products", products);
		request.setAttribute("productlist", productlist);
		//request.setAttribute("chosenProducts", chosenProducts);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/AddOneMoreProduct.jsp");
		view.forward(request, response);

	}
=======
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
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
}
