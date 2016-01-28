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
		List of products
	</h1>
<ul>
<c:forEach items="${productlist}" var="list">
	<li>
		<a href="/Kupybaton/GetPurchaseProductsByListId.do?listId=${list.getId()}">${list.getName()}</a>
	</li>
	</c:forEach>
</ul>
		
	<form method="get" action="CreateNewList.do">
		<input type="SUBMIT" class="b1" value="Create new Productlist">
	</form>
	
</body>
</html>
