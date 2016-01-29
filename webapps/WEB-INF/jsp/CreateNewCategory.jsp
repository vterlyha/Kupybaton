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
		New Category
	</h1>

	<form method="post" action="InsertValuesIntoCategory.do">
		<p>
			<input type="text" name="categoryName" placeholder="name of the category" class = "textfield">
			Name of the category
		</p>

		<input type="SUBMIT" class="b1" value="Create new Category">
	</form>

</body>
</html>