<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<form method="post" action="AddFirstProduct.do">
	
	<h1 >
		<c:forEach items="${productlist}" var="list">
			<c:set var="listId" scope="request" value="${list.getId()}"/> 
			<c:out value="${list.getName()}" />
		</c:forEach>
	</h1>

	<select name="productName" id="mySelect">
		<c:forEach items="${products}" var="oneProduct">
			<option value="${oneProduct}" selected="selected">${oneProduct.getName()}</option>
			<c:set var="productId" scope="request" value="${doneProduct.getId()}"/>
		</c:forEach>
	</select>

	
	
	<input type="hidden" name="oneProductList" value="${listId}" />
	<input type="hidden" name="product" value="${x}" />
	<input type="SUBMIT" class="b2" value="Save">
	</form>


</body>
</html>