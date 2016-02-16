<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="pageContext.jsp"/>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>
	<div class="container">
		<h1>New Category</h1>

		<c:if test="${not empty warningMessage}">
			<p class="alert-danger">${warningMessage}</p>
		</c:if>

		<form method="post" action="CreateNewCategory.do">
			<p>
				<input type="text" name="categoryName" placeholder="name of the category" class="textfield"> 
				Name of the category
			</p>

			<input type="hidden" name="productlistId" value="${productList.id}" />
			<input type="SUBMIT" class="b1" value="Create new Category">
		</form>
	</div>
</body>
</html>
