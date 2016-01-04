<%@ page import="com.kupybaton.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style2.css">
</head>
<body>
<h1><center>List of products</center></h1>
<p>
<%
List <Product> a = (List <Product>)request.getAttribute("styles");
	for(Product x : a) {
		int i = x.getId();
		String t = x.getName();
		out.print(i + " ");
		out.print(t + "<br>");
}
%>
<br>
</body>
</html>