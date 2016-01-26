<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	
	<form method="post" action="InsertValuesIntoProduct.do">

	<h1>
		New Product
	</h1>

	
		<p>
			<input type="text" name="productName" placeholder="name of the product">
			Name of the product
		</p>


		<p>
			<select name="unitId" id="mySelect">
				<c:forEach items="${units}" var="oneUnit">
					<option value="${oneUnit.id}">${oneUnit.name}</option>
				</c:forEach>
			</select> Select unit
		</p>

		<p>
			<select name="categoryId" id="mySelect">
				<c:forEach items="${categories}" var="oneCategory">
					<option value="${oneCategory.id}">${oneCategory.name}</option>
				</c:forEach>
			</select> Select category
		</p>
		<br>
		<br>
		<input type="SUBMIT" class="b1" value="Create new Product">
	</form>


	<form method="get" action="CreateNewUnit.do">
		<input type="submit" class="b4" value="Create unit">
	</form>
	
	<br>
	<br>
	
	<form method="get" action="CreateNewCategory.do">
		<input type="submit" class="b4" value="Create category">
	</form>

</body>
</html>