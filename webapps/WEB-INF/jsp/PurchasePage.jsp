<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<form method="post" action="AddOneMoreProduct.do">
	<h1 >
		<c:forEach items="${productlist}" var="list">
			<c:out value="${list.getName()}" />
		</c:forEach>
	</h1>
			
	<select name="productName">
		<c:forEach items="${products}" var="oneProduct">
			<option value="${oneProduct}" selected>${oneProduct.getName()}</option>
		</c:forEach>
	</select>
	<input type="SUBMIT" class="b2" value="Save">
	</form>


</body>
</html>