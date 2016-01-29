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
		New Unit
	</h1>

	<form method="post" action="InsertValuesIntoUnit.do">
		<p>
			<input type="text" name="unitName" placeholder="name of the unit" class = "textfield">
			Name of the unit
		</p>

		<input type="SUBMIT" class="b1" value="Create new Unit">
	</form>

</body>
</html>