package com.kupybaton;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ListSelect extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String[] c = request.getParameterValues("product");
		ArrayList <Integer> s = new ArrayList<Integer>();
		for (String x : c) {
			s.add(Integer.parseInt(x));
		}
		response.setContentType("text/html");
		ProductExpert pe = new ProductExpert();
		List <Product> l = pe.getProducts(s);
		request.setAttribute("styles", l);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		view.forward(request, response);
	}
}
