package com.kupybaton.web.servlets;

import com.kupybaton.model.Product;
import com.kupybaton.model.ProductList;
import com.kupybaton.web.jdbc.AllProductSelectExpert;
import com.kupybaton.web.jdbc.GetLastCreatedList;
import com.kupybaton.web.jdbc.PurchaseExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PurchasePage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String listname = request.getParameter("listname");

		if (listname.isEmpty()) {
			response.setContentType("text/html");
			String warningMessage = "You have to type the name of list!!!";
			request.setAttribute("warningMessage", warningMessage);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/CreateNewList.jsp");
			view.forward(request, response);
		}

		if (listname.length() > 0) {
			response.setContentType("text/html");
			PurchaseExpert pe = new PurchaseExpert();
			GetLastCreatedList gl = new GetLastCreatedList();
			pe.insertList(listname);
			List<ProductList> productlist = gl.getList();
			AllProductSelectExpert apse = new AllProductSelectExpert();
			List <Product> products = apse.getAllProducts();
			request.setAttribute("products", products);
			request.setAttribute("productlist", productlist);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
			view.forward(request, response);
		}
	}

    /*
     Added just for test.
     But it would be great to have doGet method (for example when edit purchases)
      */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List products = new ArrayList() {
            {
                add(new Product() {
                    {
                        setName("banana");
                        setId(1);
                    }
                });
                add(new Product() {
                    {
                        setName("kiwi");
                        setId(2);
                    }
                });
                add(new Product() {
                    {
                        setName("mango");
                        setId(3);
                    }
                });
                add(new Product() {
                    {
                        setName("apple");
                        setId(4);
                    }
                });
                add(new Product() {
                    {
                        setName("ananas");
                        setId(5);
                    }
                });
            }
        };
        request.setAttribute("products", products);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/PurchasePage.jsp");
        view.forward(request, response);
    }
}
