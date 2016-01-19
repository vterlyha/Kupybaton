<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<h1>
		<center>List of products</center>
	</h1>
<p>
		<c:forEach items="${productlist}" var="list">
			<c:out value="${list.getName()}" />
			<br>
		</c:forEach>
</p>
		
	<form method="get" action="CreateNewList.do">
		<input type="SUBMIT" class="b1" value="Create new Productlist">
	</form>
	
</body>
</html>
