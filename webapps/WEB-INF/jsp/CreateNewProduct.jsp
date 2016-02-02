<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>

	<form method="post" action="InsertValuesIntoProduct.do">

		<h1>
			New Product
		</h1>

		<p>
			<c:out value="${warningMessage}"/>
		</p>


		<p>
			<input type="text" name="productName" placeholder="name of the product" class = "textfield">
			Name of the product
		</p>


		<p>
			<select name="unitId" id="mySelect" class = "select">
				<c:forEach items="${units}" var="oneUnit">
					<option value="${oneUnit.id}">${oneUnit.name}</option>
				</c:forEach>
			</select> Select unit
		</p>

		<p>
			<select name="categoryId" id="mySelect" class = "select">
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