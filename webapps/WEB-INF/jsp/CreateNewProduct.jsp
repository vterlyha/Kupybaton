<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="pageContext.jsp"/>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>

	<form method="post" action="createNewProduct.do">

		<h1>
			New Product
		</h1>

		<c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>


		<p>
			<input type="text" name="productName" placeholder="name of the product" class = "textfield">
			Name of the product
		</p>


		<p>
			<select name="unitId" id="mySelect" class = "select">
				<c:forEach items="${allUnits}" var="oneUnit">
					<option value="${oneUnit.id}">${oneUnit.name}</option>
				</c:forEach>
			</select> Select unit
		</p>

		<p>
			<select name="categoryId" id="mySelect" class = "select">
				<c:forEach items="${allCategories}" var="oneCategory">
					<option value="${oneCategory.id}">${oneCategory.name}</option>
				</c:forEach>
			</select> Select category
		</p>
		<br>
		<input type="SUBMIT" class="b1" value="Create new Product">
		<input type="hidden" name="productlistId" value="${productList.id}" />
	</form>


	<form method="get" action="CreateNewUnit.do">
		<input type="hidden" name="productlistId" value="${productList.id}" />
		<input type="submit" class="b4" value="Create unit">
	</form>

	<br>

	<form method="get" action="CreateNewCategory.do">
		<input type="hidden" name="productlistId" value="${productList.id}" />
		<input type="submit" class="b4" value="Create category">
	</form>

</body>
</html>
